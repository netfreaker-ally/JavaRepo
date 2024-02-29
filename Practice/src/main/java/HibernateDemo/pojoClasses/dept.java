package HibernateDemo.pojoClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class dept {
	@Id
	private int deptno;
	private String dname;
	private String location;
	public dept() {
		super();
	}
	public dept(int deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
