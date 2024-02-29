package HibernateDemo.Demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addressonetoone {
	@Id
	private int addressId;
	@Column(length = 20)
	private String hNo;
	@Column(length = 20)
	private String area;
	@Column(length = 20)
	private String pincode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	
	public Addressonetoone() {
		super();
	}
	public Addressonetoone(int addressId, String hNo, String area, String pincode) {
		super();
		this.addressId = addressId;
		this.hNo = hNo;
		this.area = area;
		this.pincode = pincode;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
