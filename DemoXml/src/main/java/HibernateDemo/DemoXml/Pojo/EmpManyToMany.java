package HibernateDemo.DemoXml.Pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class EmpManyToMany {
	
	private int empNo;
	
	private String eName;
	public EmpManyToMany() {
		super();
	}
	public EmpManyToMany(int empNo, String eName) {
		super();
		this.empNo = empNo;
		this.eName = eName;
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
	
		
	
}
