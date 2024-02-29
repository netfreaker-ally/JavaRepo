package HibernateDemo.Demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Emponetoone2 {
	@Id
	private int empId;
	@Column(length = 20)
	private String ename;
	@OneToOne(mappedBy = "emp")
	@PrimaryKeyJoinColumn
	private Addressonetoone2 address;
	public Emponetoone2() {
		super();
	}
	public Emponetoone2(int empId, String ename, Addressonetoone2 address) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.address = address;
	}
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
	public Addressonetoone2 getAddress() {
		return address;
	}
	public void setAddress(Addressonetoone2 address) {
		this.address = address;
	}
	
	
}
