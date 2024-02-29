package HibernateDemo.Demo.pojo;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class DeptAnnotation {
	@Id
	private int deptId;
	@Column(length = 25)
	private String dname;
	@OneToMany
	@JoinColumn(name = "deptId")
	private List<EmpAnnotation> emp;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<EmpAnnotation> getEmp() {
		return emp;
	}
	public void setEmp(List<EmpAnnotation> emp) {
		this.emp = emp;
	}
	public DeptAnnotation() {
		//default constructor
	}
	public DeptAnnotation(int deptId, String dname, List<EmpAnnotation> emp) {
		super();
		this.deptId = deptId;
		this.dname = dname;
		this.emp = emp;
	}
	
}
