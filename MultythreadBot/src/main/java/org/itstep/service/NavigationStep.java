package org.itstep.service;

import java.io.IOException;

import org.itstep.model.KeyWord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NavigationStep extends Thread{

	private final String url;
	
	private final KeyWord keyword;
	
	public NavigationStep(KeyWord key, String url) {
		this.url = url;
		this.keyword = key;
	}
	
	@Override
	public void run() {
		
		System.out.println("Start parsing with url " + url);
		Document content = null;
		
		try {
			content = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element itemListElement = content.getElementById("productListing");
		Elements itemElements = itemListElement.getElementsByAttributeValue("class", "productListing-data");
		
		for (Element aElement : itemElements) {
			if(aElement.attr("href") != null) {
				
				String url = aElement.attr("href");
				if(url.startsWith("//www")) {
					url = "https:" + url;
				}
				
				ProductStep nextStep = new ProductStep(this.keyword, this.url, url);
				nextStep.start();
			}
		}
		
		System.out.println("Finish creating of next product steps from url " + url);
	}
}
