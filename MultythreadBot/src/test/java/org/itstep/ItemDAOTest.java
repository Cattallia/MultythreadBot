package org.itstep;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.itstep.dao.ItemDAO;
import org.itstep.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemDAOTest {

	Item item;

	@Before
	public void setDataToDB() {
		item = new Item("id12345", "test_parent_url", "test_item_ur", "test_img_url", "Sun", 5);
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.save(item);
	}

	@Test
	public void testSaveAndGet() {

		ItemDAO itemDAO = new ItemDAO();

		assertNotNull(item.getArticleId());
		assertNotNull(itemDAO.get("id12345").getArticleId());
		assertEquals("id12345", itemDAO.get("id12345").getArticleId());

	}

	@Test
	public void testAll() {
		ItemDAO itemDAO = new ItemDAO();

		List<Item> testItems = itemDAO.getAll();
		assertTrue(!testItems.isEmpty());
	}

	@After
	public void removeTempDataFromDB() {
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.delete(item);
	}
}