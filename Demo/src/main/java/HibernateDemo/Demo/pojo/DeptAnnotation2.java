package HibernateDemo.Demo.pojo;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class DeptAnnotation2 {
	@Id
	private int deptId;
	@Column(length = 25)
	private String dname;
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
	public DeptAnnotation2() {
		super();
	}
	public DeptAnnotation2(int deptId, String dname) {
		super();
		this.deptId = deptId;
		this.dname = dname;
	}
	
	
	
}
