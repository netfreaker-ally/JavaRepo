package HibernateDemo.Demo.pojo;

import java.io.Serializable;

public class EmpProjectsId  implements Serializable{
	 private EmpManyToMany emps;
	  private projectManyToMany projects;
	  
	  
	public EmpProjectsId() {
		super();
	}
	public EmpProjectsId(EmpManyToMany emps, projectManyToMany projects) {
		super();
		this.emps = emps;
		this.projects = projects;
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
	  
}
