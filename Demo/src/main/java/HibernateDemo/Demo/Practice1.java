package HibernateDemo.Demo;
import java.time.LocalDate;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateDemo.Demo.pojo.ProjectDetails;

public class Practice1 {
	static Configuration cfg=null;
	static SessionFactory sf=null;
	static Session session=null;
	static Transaction transaction=null;
	public static void initialize() {
		cfg=new Configuration().configure("HibernateDemo/Demo/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		session=sf.openSession();
		transaction=session.beginTransaction();
	}
	public static List<ProjectDetails> getDetails() {
		List<ProjectDetails> projectdetails=session.createQuery("FROM ProjectDetails", ProjectDetails.class).getResultList(); 		
				return projectdetails;	
	}
	public static void updatedetails(int projectid,String ProjectHead) {
		ProjectDetails pd=session.get(ProjectDetails.class, projectid);
		pd.setProjectHead(ProjectHead);
		session.update(pd);
		transaction.commit();		
	}
	public static void addDetails(int n) {
        ProjectDetails[] projectdetails=new ProjectDetails[n];
        Scanner sc=new  Scanner(System.in);
        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter projectid ");
            int pid=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter duration ");
            int duration=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter projecthead");
            String phead=sc.nextLine();
            System.out.println("Enter projectname: ");
            String pname=sc.nextLine();
            System.out.println("Enter date in format yyyy-mm-dd");
            LocalDate ld=LocalDate.parse(sc.nextLine());
            projectdetails[i]=new ProjectDetails(pid, pname, phead, duration, ld);
            session.save(projectdetails[i]);
        }  
       transaction.commit();
       sc.close();
    }                                                                                                                                                                                                                                                                                                                                   
	public static void deleteDetails(int projectid ) {
		ProjectDetails p=session.get(ProjectDetails.class, projectid);
		session.delete(p);
		transaction.commit();
	}
	
public static void main(String[] args) {	                                                                                                                                                                                                              
	initialize();
	try {
	System.out.println("Enter 1 for printing all the details and Enter 3 for adding values"	
	 + " and enter 2 for updating  any value and 4 for deleting enter 5 for exit!! "); 	
	int choice;
	do {
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		sc.nextLine();
	    switch (choice) {
	    case 1:
	        System.out.println("All the details: ");
	        List<ProjectDetails> projectDetailsList = getDetails();
	        for (ProjectDetails project : projectDetailsList) {
	            System.out.println("Project ID: " + project.getProjectId());
	            System.out.println("Project Head: " + project.getProjectHead());
	          
	            System.out.println();
	        }
	        break;
	        case 2:
	            System.out.println("Enter the project id: ");
	            int projectId=sc.nextInt();
	            sc.nextLine();
	            System.out.println("Enter projecthead name");
	        	String projectHead=sc.nextLine();
	        	updatedetails(projectId, projectHead);
	        	System.out.println("Done ");	        	
	            break;	       
	        case 3:
	            System.out.println("Enter number of data you want to add ");
	            int n=sc.nextInt();
	            addDetails(n);
	            System.out.println("Done");
	            break;
	        case 4:
	        	System.out.println("Enter project id for which you want to delete ");
	        	int pId=sc.nextInt();
	        	sc.nextLine();
	            deleteDetails(pId);
	            System.out.println("done");
	            break;	            
	        default:
	            System.out.println("Enter 1 or 2 or 3 or 4 only");        	
	            break;
	    }
	  
	} while (choice!=5);
	}catch (Exception e) {
		System.out.println("Exception ");
	}finally {
		
		session.close();
	}
}
}
