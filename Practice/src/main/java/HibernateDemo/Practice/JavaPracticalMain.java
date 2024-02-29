package HibernateDemo.Practice;
import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateDemo.pojoClasses.empdemo;

public class JavaPracticalMain {
	static Configuration cfg=null;
	static SessionFactory sf=null;
	static Session session=null;
	static Transaction transaction=null;
	Scanner scanner=new Scanner(System.in);

	public static void initialize() {
		cfg=new Configuration().configure("HibernateDemo/Practice/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		session=sf.openSession();
		transaction=session.beginTransaction();
	}
	
	public List<empdemo[]> byJob() {
	
		  TypedQuery<empdemo[]> query = session.createQuery("SELECT job, COUNT(*) AS count "
					+ "FROM empdemo "
					+ "GROUP BY job",
					empdemo[].class);

		List<empdemo[]> results = query.getResultList();
		
		return results;
		 
	}
	public List<Object[]> byDept() {
		
		  TypedQuery<Object[]> query = session.createQuery("SELECT dept.dname, COUNT(*) AS count "
				    + "FROM empdemo emp "
				    + "INNER JOIN dept dept ON emp.deptno = dept.deptno "
				    + "GROUP BY dept.dname",
				    Object[].class);

		List<Object[]> results = query.getResultList();
		
		return results;
		 
	}
	
	
	public static void main(String[] args) {
		JavaPracticalMain jp=new JavaPracticalMain();
		JavaPracticalMain.initialize();
		Scanner scanner=new Scanner(System.in);
		int choice;		
		while(true) {
			System.out.println("Enter 1 for job and 2 for dname and 3 for exit: ");
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				List<empdemo[]> result=jp.byJob();
				for (Object[] r : result) {
					  String job = (String) r[0];
					  int count =  ((Long) r[1]).intValue();

					  System.out.println("Job: " + job + ", Count: " + count);
					}
				
				break;
				
			case 2:
				List<Object[]> results=jp.byDept();
				for (Object[] r : results) {
					  String job = (String) r[0];
					  int count =  ((Long) r[1]).intValue();

					  System.out.println("Job: " + job + ", Count: " + count);
					}
				
				break;
			case 3:
				session.close();
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 or 2 or 3 only");
				scanner.nextLine();
				break;
			}
		}
		
		}	
	
				 
		
	
}
