package HibernateDemo.Demo.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class projectManyToMany {
	@Id
	private int projectId;
	private String projectName;
	private LocalDate stdate;
	private LocalDate eddate;
	@ManyToMany
	private List<EmpManyToMany> emps;
	public projectManyToMany() {
		super();	
}
	public projectManyToMany(int projectId, String projectName, LocalDate stdate, LocalDate eddate,
			List<EmpManyToMany> emps) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.stdate = stdate;
		this.eddate = eddate;
		this.emps = emps;
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
	public List<EmpManyToMany> getEmps() {
		return emps;
	}
	public void setEmps(List<EmpManyToMany> emps) {
		this.emps = emps;
	}
	
}
