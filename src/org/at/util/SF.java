package org.at.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SF {
	private static  SessionFactory sf = null;
	
	public static SessionFactory getSf() {
		Configuration cf =  new Configuration().configure();
		SessionFactory sf = cf.buildSessionFactory();
		return sf;
	}
}
