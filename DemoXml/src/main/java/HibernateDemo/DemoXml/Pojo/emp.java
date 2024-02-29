package HibernateDemo.DemoXml.Pojo;

public class emp {
	private int empId;
	private String eName;
	private int deptId;
	public emp() {
		super();
	}
	public emp(int empId, String eName, int deptId) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.deptId = deptId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
