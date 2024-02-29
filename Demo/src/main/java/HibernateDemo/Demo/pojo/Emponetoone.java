package HibernateDemo.Demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Emponetoone {
	@Id
	private int empId;
	@Column(length = 20)
	private String ename;
	@OneToOne
	@JoinColumn(name = "AdressId",unique = true )
	private Addressonetoone address;
	public Emponetoone() {
		super();
	}
	public Emponetoone(int empId, String ename, Addressonetoone address) {
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
	public Addressonetoone getAddress() {
		return address;
	}
	public void setAddress(Addressonetoone address) {
		this.address = address;
	}
	
	
}
