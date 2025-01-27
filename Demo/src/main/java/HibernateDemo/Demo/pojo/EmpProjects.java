package HibernateDemo.Demo.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@IdClass(EmpProjectsId.class)
@Entity
public class EmpProjects implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "empNo")
	private EmpManyToMany emps;
	@Id
	@ManyToOne
	@JoinColumn(name = "projectid")
	private projectManyToMany projects;
	private LocalDate fromdate;
	private LocalDate todate;
	public EmpProjects() {
		super();
	}
	public EmpProjects(EmpManyToMany emps, projectManyToMany projects, LocalDate fromdate, LocalDate todate) {
		super();
		this.emps = emps;
		this.projects = projects;
		this.fromdate = fromdate;
		this.todate = todate;
	}
	public EmpManyToMany getEmps() {
		return emps;
	}
	public void setEmps(EmpManyToMany emps) {
		this.emps = emps;
	}
	public projectManyToMany getProjects() {
		return projects;
	}
	public void setProjects(projectManyToMany projects) {
		this.projects = projects;
	}
	public LocalDate getFromdate() {
		return fromdate;
	}
	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}
	public LocalDate getTodate() {
		return todate;
	}
	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}
	
	
}
