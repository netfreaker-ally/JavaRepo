package HibernateDemo.pojoClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
	@NamedQuery(
			name = "getbyProductId",
			query = "FROM Product p where p.id=:pdid"
			),
	@NamedQuery(
			name = "getbyCategoryId",
			query = "FROM Product c where c.categoryId=:pcid"
			
			),
	@NamedQuery(
			name = "deletebyCategory",
			query = "From Product p where p.categoryId=:catId"
			
			)
	
	
	
})
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category categoryId;
	public Product() {
		super();
	}
	public Product(int id, String name, int price, int quantity, Category categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
