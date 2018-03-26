package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Item;
import org.itstep.util.HibernateUtil;

public class ItemDAO {

	private Session session;

	public synchronized void save(Item item) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(item);

		session.getTransaction().commit();

		session.close();
	}

	public Item get(String articleId) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		Item item = session.get(Item.class, articleId);

		session.getTransaction().commit();

		session.close();

		return item;
	}

	public synchronized List<Item> getAll() {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		String sql = "SELECT * FROM items";

		Query query = session.createNativeQuery(sql, Item.class);

		List<Item> result = query.getResultList();

		session.getTransaction().commit();

		session.close();

		return result;
	}

	public void delete(Item item) {
		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.delete(item);

		session.getTransaction().commit();

		session.close();

	}
}