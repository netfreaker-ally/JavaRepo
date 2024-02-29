package HibernateDemo.DemoXml.Pojo;

import java.time.LocalDate;

public class Vendor {
	private int vendorId;
	private String vendorName;
	private LocalDate vendorRegDate;
	private String city;
	public Vendor() {
		//default constructor
	}
	public Vendor(int vendorId, String vendorName, LocalDate vendorRegDate, String city) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorRegDate = vendorRegDate;
		this.city = city;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public LocalDate getVendorRegDate() {
		return vendorRegDate;
	}

	public void setVendorRegDate(LocalDate vendorRegDate) {
		this.vendorRegDate = vendorRegDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
