package HibernateDemo.Demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getSessionFactory {
	public static SessionFactory getFactory() {
		 //Step 1 specify cfg file path
    	Configuration cfg=new Configuration();
    	cfg.configure("HibernateDemo/Demo/hibernate.cfg.xml");
    	//step 2 create session factory
    	SessionFactory factory=cfg.buildSessionFactory();
    	return factory;
	}
}
