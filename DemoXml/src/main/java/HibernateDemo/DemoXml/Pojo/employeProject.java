package HibernateDemo.DemoXml.Pojo;

import java.time.LocalDate;

public class employeProject {
    private empProjectComposite compositeKey;
    private LocalDate edDate;

    public employeProject() {
        super();
    }

    public employeProject(empProjectComposite compositeKey, LocalDate edDate) {
        super();
        this.compositeKey = compositeKey;
        this.edDate = edDate;
    }

	public empProjectComposite getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(empProjectComposite compositeKey) {
		this.compositeKey = compositeKey;
	}

	public LocalDate getEdDate() {
		return edDate;
	}

	public void setEdDate(LocalDate edDate) {
		this.edDate = edDate;
	}

}
