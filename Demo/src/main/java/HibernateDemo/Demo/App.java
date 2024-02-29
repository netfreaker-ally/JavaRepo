package HibernateDemo.Demo;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateDemo.Demo.pojo.ProjectDetails;
/**
 * Hello world!
 *
 */
public class App 
{
//	public static List<ProjectDetails> fetchProject() {
//	Session session = getSessionFactory.getFactory().openSession();
//		//ProjectDetails p=session.get(ProjectDetails.class,projectId);
//	//	ProjectDetails p=session.load(ProjectDetails.class, projectId);
//		//session.close();
//	List<ProjectDetails> projects = session.createQuery("FROM ProjectDetails", ProjectDetails.class).getResultList();
//		return projects;
	//}
    public static void main( String[] args )
    {
       
    	Session session = getSessionFactory.getFactory().openSession();
		ProjectDetails p=new ProjectDetails(5, "Project5", "Hanu", 10, LocalDate.parse("2020-01-01"));
    	//Transaction t=session.beginTransaction();
    	//session.save(p);
    	//t.commit();
    	//ProjectDetails p=fetchProject(1);
//    	List<ProjectDetails> p=fetchProject();
//    	//System.out.println(p.getProjectHead()+" "+p.getProjectId());
//    //	p.setProjectName("Net Freakerr ");
//    	Transaction t=session.beginTransaction();
//    	for (ProjectDetails projectDetails : p) {
//    		System.out.println(projectDetails.getProjectHead()+" "+projectDetails.getProjectId());
//		}
//    	//session.update(p);
//    	t.commit();
//    	System.out.println("Done");
// 	
    	
    	
    	session.close();
    }
}
