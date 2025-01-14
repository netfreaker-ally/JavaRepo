package HibernateDemo.Demo.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
//	@NamedQuery(
//			name = "getbyDeptno",
//			query = "from empDemo e where e.deptNo=:dno"
//			);
	@NamedQuery(
			name = "getbyEmpno",
			query = "from empDemo e where e.empNo=:eno"
			),
	@NamedQuery(
			name = "getbyDname",
			query = "from empDemo E inner join Dept D on"+" E.deptNo=D.deptNo where D.dname=:dn"
			)
})
@Entity
public class empDemo {
	@Id
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private LocalDate hireDate;
	private int sal;
	@Column(nullable = true)
	private Integer comm;
	private int deptNo;
	public empDemo() {
		super();
	}
	public empDemo(int empNo, String eName, String job, int mgr, LocalDate hireDate, int sal, int comm, int deptNo) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	
	
}
