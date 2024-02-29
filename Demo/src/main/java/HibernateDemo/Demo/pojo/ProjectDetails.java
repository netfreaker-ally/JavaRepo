package HibernateDemo.Demo.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateDemo.Demo.getSessionFactory;
@Entity
@Table(name="tblProjectDetails")
public class ProjectDetails {
	@Id
	private int projectId;
	@Column(length=20)
	private String projectName;
	@Column(length = 20)
	private String projectHead;
	private int duration;
	private LocalDate startDate;
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
	public String getProjectHead() {
		return projectHead;
	}
	public void setProjectHead(String projectHead) {
		this.projectHead = projectHead;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public ProjectDetails()
	{
		//Default Constructor
	}
	public ProjectDetails(int projectId, String projectName, String projectHead, int duration, LocalDate startDate) {
	//	super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectHead = projectHead;
		this.duration = duration;
		this.startDate = startDate;
	}

		
}
