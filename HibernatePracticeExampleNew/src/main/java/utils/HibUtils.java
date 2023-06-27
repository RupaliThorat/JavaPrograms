package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibUtils {
	
	private static SessionFactory sf ;
	static{
		System.out.println("In Static block HibUtils");
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSf() {
		return sf;
	}
	
	

}
