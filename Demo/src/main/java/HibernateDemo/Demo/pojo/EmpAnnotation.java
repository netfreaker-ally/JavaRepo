package HibernateDemo.Demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmpAnnotation {
	@Id
	private int empId;
	@Column(length = 25)
	private String ename;
	public int getEmpId() {
		return empId;
	}
	public void setDeptId(int empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String Ename) {
		this.ename = ename;
	}
	public EmpAnnotation() {
		super();
	}
	public EmpAnnotation(int empId, String ename) {
		super();
		this.empId = empId;
		this.ename = ename;
	}
	
}
