package HibernateDemo.Demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmpAnnotation2 {
	@Id
	private int empId;
	@Column(length = 25)
	private String ename;
	@ManyToOne
	@JoinColumn(name = "deptId")
	private DeptAnnotation2 deptId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public DeptAnnotation2 getDeptId() {
		return deptId;
	}
	public void setDeptId(DeptAnnotation2 deptId) {
		this.deptId = deptId;
	}
	public EmpAnnotation2() {
		super();
	}
	public EmpAnnotation2(int empId, String ename, DeptAnnotation2 deptId) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.deptId = deptId;
	}
	
}
