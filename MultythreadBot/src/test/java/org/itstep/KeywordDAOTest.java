package org.itstep;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.dao.KeywordDAO;
import org.itstep.model.KeyWord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KeywordDAOTest {
	KeyWord keyword = new KeyWord();

	@Before
	public void setDataToDB() {
		keyword = new KeyWord("1234");
		KeywordDAO keywordDAO = new KeywordDAO();
		keywordDAO.save(keyword);
	}

	@Test
	public void testSaveAndGet() {

		KeywordDAO keywordDAO = new KeywordDAO();

		assertNotNull(keyword.getKey());
		assertEquals("1234", keywordDAO.get("1234").getKey());

	}

	@Test
	public void testAll() {
		KeywordDAO keywordDAO = new KeywordDAO();

		List<KeyWord> testKeywords = keywordDAO.getAll();
		assertTrue(!testKeywords.isEmpty());
	}

	@After
	public void removeTempDataFromDB() {
		KeywordDAO KeywordDAO = new KeywordDAO();
		KeywordDAO.delete(keyword);
	}
}