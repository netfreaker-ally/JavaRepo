package HibernateDemo.Demo.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmpManyToMany {
	@Id
	private int empNo;
	
	private String eName;
	@ManyToMany(mappedBy = "emps")
	private List<projectManyToMany> projects;
	public EmpManyToMany() {
		super();
	}
	public EmpManyToMany(int empNo, String eName, List<projectManyToMany> projects) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.projects = projects;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public List<projectManyToMany> getProjects() {
		return projects;
	}
	public void setProjects(List<projectManyToMany> projects) {
		this.projects = projects;
	}
	
	
	
}
