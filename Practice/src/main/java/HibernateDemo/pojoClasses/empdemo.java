package HibernateDemo.pojoClasses;

import javax.persistence.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empdemo")
public class empdemo {
    @Id
    @Column(name = "EMPNO")
    private int empNo;

    @Column(name = "ENAME")
    private String empName;

    @Column(name = "JOB")
    private String job;

    @Column(name = "MGR")
    private Integer managerId;

    @Column(name = "HIREDATE")
    private Date hireDate;

    @Column(name = "SAL")
    private Double salary;

    @Column(name = "COMM")
    private Double commission;

    @Column(name = "DEPTNO")
    private Integer deptno;;

    // Default constructor
    public empdemo() {
    }

   

    public empdemo(int empNo, String empName, String job, Integer managerId, Date hireDate, Double salary,
			Double commission, Integer deptno) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commission = commission;
		this.deptno = deptno;
	}



	public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }



	public Integer getDeptno() {
		return deptno;
	}



	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
    
   
}

