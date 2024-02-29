package HibernateDemo.DemoXml;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;


import HibernateDemo.DemoXml.Pojo.Vendor;


/**
 * Hello world!
 *
 */
public class App 

{
    public static void main( String[] args )
    {
    	Session session = getSessionFactory.getFactory().openSession();
//    	//Vendor v=new Vendor(1, "Hanu", LocalDate.parse("2021-01-01"), "Hyd");
//    	Transaction t=session.beginTransaction();	
//    	//session.delete(new Vendor(3, "Krish", LocalDate.parse("2022-01-01"), "VSK"));
//    	//session.save(v);
//    	Vendor v=session.get(Vendor.class, 2);
//		v.setVendorName("NetFreaker");
//		session.update(v);	
	
    	//t.commit();
    	session.close();
    }
}
