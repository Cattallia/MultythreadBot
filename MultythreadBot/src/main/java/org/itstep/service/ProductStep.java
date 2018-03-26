package org.itstep.service;

import java.io.IOException;

import org.itstep.dao.Item;
import org.itstep.model.Item;
import org.itstep.model.KeyWord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ProductStep extends Thread {

	private final KeyWord key;

	private final String url;

	private final String parentUrl;

	public ProductStep(KeyWord key, String parentUrl, String url) {
		this.key = key;
		this.url = url;
		this.parentUrl = parentUrl;
	}

	@Override
	public void run() {

		System.out.println("Start product parsing with url " + url);
		Document content = null;

		Item item = new Item();
		item.setItemUrl(url);
		item.setParentUrl(parentUrl);
		item.setKeyword(key);

		try {
			content = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// extract ID
		Element skuElement = content.getElementsByAttributeValue("itemprop", "sku").first();
		if (skuElement.attr("content")!=null ) {
			item.setArticleId(skuElement.attr("content"));
		}

		// extract name
		Element h1Element = content.getElementsByTag("h1").first();
		if (h1Element.attr("itemprop").equals("name")) {
			item.setName(h1Element.text());
		}

		Item itemDAO = new Item();
		itemDAO.save(item);

		System.out.println("Finish product parsing from url " + url);

	}

}
