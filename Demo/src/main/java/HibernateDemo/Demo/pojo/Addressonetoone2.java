package HibernateDemo.Demo.pojo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Addressonetoone2  implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name = "empId")
	public Emponetoone2 emp;
	@Column(length = 20)
	private String hNo;
	@Column(length = 20)
	private String area;
	@Column(length = 20)
	private String pincode;
	public Addressonetoone2() {
		super();
	}
	
	public Addressonetoone2(Emponetoone2 emp, String hNo, String area, String pincode) {
		super();
		this.emp = emp;
		this.hNo = hNo;
		this.area = area;
		this.pincode = pincode;
	}

	public Emponetoone2 getEmp() {
		return emp;
	}
	public void setEmp(Emponetoone2 emp) {
		this.emp = emp;
	}
	public String gethNo() {
		return hNo;
	}
	public void sethNo(String hNo) {
		this.hNo = hNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
