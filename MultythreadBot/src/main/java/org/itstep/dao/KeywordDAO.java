package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.KeyWord;
import org.itstep.util.HibernateUtil;

public class KeywordDAO {

	private Session session;

	public synchronized void save(KeyWord keyword) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(keyword);

		session.getTransaction().commit();

		session.close();
	}

	public KeyWord get(String key) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		KeyWord keyword = session.get(KeyWord.class, key);

		session.getTransaction().commit();

		session.close();

		return keyword;
	}

	public synchronized List<KeyWord> getAll() {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		String sql = "SELECT * FROM keywords";

		Query query = session.createNativeQuery(sql, KeyWord.class);

		List<KeyWord> result = query.getResultList();

		session.getTransaction().commit();

		session.close();

		return result;
	}

	public void delete(KeyWord keyword) {
		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.delete(keyword);

		session.getTransaction().commit();

		session.close();

	}
}
