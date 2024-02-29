package HibernateDemo.DemoXml.Pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class empProjectComposite  implements Serializable{
	
	private EmpManyToMany empNo;
	private projectManyToMany projectId;
	private LocalDate stdate;
	
	public empProjectComposite() {
		super();
	}

	public empProjectComposite(EmpManyToMany empNo, projectManyToMany projectId, LocalDate stdate) {
		super();
		this.empNo = empNo;
		this.projectId = projectId;
		this.stdate = stdate;
	}

	public EmpManyToMany getEmpNo() {
		return empNo;
	}

	public void setEmpNo(EmpManyToMany empNo) {
		this.empNo = empNo;
	}

	public projectManyToMany getProjectId() {
		return projectId;
	}

	public void setProjectId(projectManyToMany projectId) {
		this.projectId = projectId;
	}

	public LocalDate getStdate() {
		return stdate;
	}

	public void setStdate(LocalDate stdate) {
		this.stdate = stdate;
	}
}
