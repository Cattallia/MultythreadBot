package org.itstep.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.model.Item;
import org.itstep.model.KeyWord;

public class HibernateUtil {

	private static SessionFactory sessionFactory = configureSessionFactory();

	/**
	 * Create SessionFactory
	 *
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory() throws HibernateException {

		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(KeyWord.class);
		
		return configuration.buildSessionFactory();

	}

	/**
	 * Get SessionFactory
	 *
	 * @return {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}