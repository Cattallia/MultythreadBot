package org.itstep;

import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.KeywordDAO;
import org.itstep.model.KeyWord;
import org.itstep.service.StartupStep;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		
		KeywordDAO keyDAO = new KeywordDAO();
		
//		List<KeyWord> keys = new ArrayList<KeyWord>();
//
//		keys.add(new KeyWord("cat toys"));
//
//		keys.add(new KeyWord("dog toys"));
//
//		keys.add(new KeyWord("cat food"));
//
//		
//
//		for (KeyWord keyword : keys) {
//
//			keyDAO.save(keyword);
//
//		}

		
		
		List<KeyWord> keysFromDB = keyDAO.getAll();

		StartupStep startupStep = new StartupStep(keysFromDB);
		
		startupStep.runParsing();

	}
}
