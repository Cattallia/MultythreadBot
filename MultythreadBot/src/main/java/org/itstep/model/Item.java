package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "items")
public class Item {

	@Id
	@Column(name = "article_id")
	private String articleId;

	@Column(name = "parent_url", length = 800)
	private String parentUrl;

	@Column(name = "item_url", length = 800, nullable = false)
	private String itemUrl;

	@Column(name = "img_url", length = 800)
	private String imgUrl;

	@Column(name = "item_name", nullable = false)
	private String name;

	@Column(name = "price")
	private Integer price;

	@ManyToOne(targetEntity = KeyWord.class)
	private KeyWord keyword;

	public Item(String articleId, String parentUrl, String itemUrl, String imgUrl, String name, int price) {
		this.articleId = articleId;
		this.parentUrl = parentUrl;
		this.itemUrl = itemUrl;
		this.imgUrl = imgUrl;
		this.name = name;
		this.price = price;

	}

	public Item() {
	}

	public void save(Item item) {

	}

}
