package HibernateDemo.DemoXml.Pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class projectManyToMany {
	
	private int projectId;
	private String projectName;
	//LocalDate to empProjectComposite. This will allow you to
	//reference the empProjectComposite object as a foreign key.
	private  LocalDate stdate;
	private LocalDate eddate;
	public projectManyToMany() {
		super();
	}
	public projectManyToMany(int projectId, String projectName, LocalDate stdate, LocalDate eddate) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.stdate = stdate;
		this.eddate = eddate;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDate getStdate() {
		return stdate;
	}
	public void setStdate(LocalDate stdate) {
		this.stdate = stdate;
	}
	public LocalDate getEddate() {
		return eddate;
	}
	public void setEddate(LocalDate eddate) {
		this.eddate = eddate;
	}
	
	
		
}
