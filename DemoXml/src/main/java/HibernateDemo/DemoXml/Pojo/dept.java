package HibernateDemo.DemoXml.Pojo;

public class dept {
	private int deptId;
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
	public dept(int deptId, String dname) {
		super();
		this.deptId = deptId;
		this.dname = dname;
	}
	public dept() {
		super();
	}
	
}
