package HibernateDemo.Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateDemo.Demo.pojo.ProjectDetails;
import HibernateDemo.pojoClasses.Category;
import HibernateDemo.pojoClasses.Product;
import oracle.net.aso.q;

import java.util.*;
import java.util.function.Consumer;

import javax.management.Query;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
	static Configuration cfg=null;
	static SessionFactory sf=null;
	static Session session=null;
	static Transaction transaction=null;
	Scanner scanner=new Scanner(System.in);
	public static void initialize() {
		cfg=new Configuration().configure("HibernateDemo/Practice/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		session=sf.openSession();
		transaction=session.beginTransaction();
	}
	public void insert() {
	    System.out.println("Enter number of category: ");
	    int n = scanner.nextInt();
	    int categoryId;
	    String categoryName = null;
	    Category category[] = new Category[n];
	    for (int i = 0; i < n; i++) {
	        System.out.println("Enter category id of " + (i + 1));
	        categoryId = scanner.nextInt();
	        scanner.nextLine();
	        System.out.println("Enter category name of " + (i + 1));
	        categoryName = scanner.nextLine();
	        category[i] = new Category(categoryId, categoryName);
	        session.save(category[i]);
	    }
	    transaction.commit();

	    try {
	       transaction = session.beginTransaction(); 

	        System.out.println("Enter number of Products: ");
	        int size = scanner.nextInt();
	        Product product[] = new Product[size];
	        scanner.nextLine();
	        int pid;
	        String pName = null;
	        int price;
	        int quantity;
	        int catId;
	        for (int i = 0; i < size; i++) {
	            System.out.println("Enter productid: ");
	            pid = scanner.nextInt();
	            scanner.nextLine();
	            System.out.println("Enter Product name: ");
	            pName = scanner.nextLine();
	            System.out.println("Enter Price: ");
	            price = scanner.nextInt();
	            scanner.nextLine();
	            System.out.println("Enter Quantity: ");
	            quantity = scanner.nextInt();
	            scanner.nextLine();
	            boolean check = false;
	            while (!check) {
	                try {
	                    System.out.println("Enter category Id of this product belongs");
	                    catId = scanner.nextInt();
	                    scanner.nextLine();
	                    Category cat = session.get(Category.class, catId);
	                 
	                    if (cat != null) {
	                        product[i] = new Product(pid, pName, price, quantity, cat);
	                        session.save(product[i]);
	                        check = true;
	                    }
	                } catch (IllegalStateException e) {
	                    System.out.println("Enter only those category IDs that exist.");
	                    scanner.nextLine();
	                }
	            }
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        System.out.println("Error " + e.getMessage());
	        transaction.rollback();
	    }
	}
	@SuppressWarnings("unchecked")
	public List<Product> retrieve(int productIdd){
		TypedQuery query= session.getNamedQuery("getbyProductId");
    	
    	query.setParameter("pdid",productIdd);
		List<Product> list=query.getResultList();
		return list;
		
	}
    public List<Product> fetchData(int catId){
    	
    	TypedQuery query2=session.getNamedQuery("getbyCategoryId");
    	Category category = session.get(Category.class, catId);
    	query2.setParameter("pcid", category);
    	List<Product> list2=query2.getResultList();
    	return list2;
    	
    }
	public boolean updatePrice(int productId,int price) {
		boolean check=false;
		try {
			Product product=session.get(Product.class, productId);
			product.setPrice(price);
			session.update(product);
			transaction.commit();
			check=true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while updating "+e.getMessage());
			
		}
		return check;
	}
   public boolean updateCategory(int productId,int categoryId2) {
	   boolean check=false;
	   try {				  
		   Product product=session.get(Product.class, productId);
		   Category category=session.get(Category.class, categoryId2);
		   if (category == null) {
			   throw new RuntimeException("Category with id " + categoryId2 + " does not exist in Category Table");
			 }else {
				 product.setCategoryId(new Category(categoryId2,category.getName()));
				   session.update(product);
				   
				   check=true;
				   
			 }

		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error while updating "+e.getMessage());
	}	
	   transaction.commit();
	   return check;	
}
   public static List<Product> getDetails() {
		List<Product> productdetails=session.createQuery("FROM Product", Product.class).getResultList(); 		
				return productdetails;	
	}
   public boolean deleteProduct(int productId) {
	   boolean check=false;
	   try {
		   Product product=session.get(Product.class, productId);
		   if(product!=null) {
			   session.delete(product);
			   transaction.commit();
			   check=true;
		   }
		 
		   
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error: "+e.getMessage());
	}
	   
	   return check;
}
   public boolean  deleteCategory(int catId) {
	  boolean isValid=false;
	   try {
		   Category cat=session.get(Category.class, catId);
		  // Category cat1=session.get(Category.class, catId);
		   if(cat!=null) {
			//  Query<Product> query=session.getNamedQuery("deletebyCategory");
			   TypedQuery<Product> query = session.createNamedQuery("deletebyCategory", Product.class);
			  query.setParameter("catId", cat);
			  List<Product> list=query.getResultList();
			  for (int i = 0; i < list.size(); i++) {
				session.delete(list.get(i));
			}
			  session.delete(cat);
			  transaction.commit();
			  isValid=true;
		   }
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error while updating"+e.getMessage());
	}
	   
	 return isValid;  
   }
   public List<Product> fetchProduct(int price){
	   List<Product> list=new ArrayList<Product>();
	   try {
		   String query="From Product p where p.price>=:inputPrice";
		   TypedQuery<Product> query2=session.createQuery(query,Product.class);
		   query2.setParameter("inputPrice", price);
		    list=query2.getResultList();
		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error");
	}
	   return list; 
   }
   public boolean insertUpdate(int productId,String productName,int price,int quantity,int categoryId,int newCategoryId) {
	   Category category=session.get(Category.class, categoryId);
	   boolean isUpdate=false;
	   if(category!=null) {
		   try {
			Product product=new Product(productId, productName, price, quantity, new Category(categoryId, category.getName()));
			session.save(product);
			Category category2=session.get(Category.class, newCategoryId);
			if(category2!=null) {
				try {
					//Product product2=new Product(productId, productName, price, quantity, new Category(newCategoryId, category2.getName()));
					product.setCategoryId(new Category(newCategoryId, category2.getName()));
					session.update(product);
					isUpdate=true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error: "+e.getMessage());
				}
			}else {
				System.out.println("This Category does not exsits!!!!!!!!!!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage()); 
		}
	   }
		transaction.commit();	
		return isUpdate;
   }
   public boolean updateCategoryName(int catId,String catName) {
	  // transaction.commit();
	 // Transaction transaction2 = session.beginTransaction();
	   boolean isValid=false;
	   Category category=session.get(Category.class, catId);
	   if(category!=null) {
		   try {
			category.setName(catName);
			session.save(category);
			TypedQuery<Product> query=session.createQuery("FROM Product p where categoryId.id=:cat",Product.class);
			query.setParameter("cat", catId);
			List<Product> list=query.getResultList();
			for (Product product : list) {
				product.setCategoryId(new Category(catId, catName));
				session.update(product);
			}
			transaction.commit();
			isValid=true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
			//transaction2.rollback();
		}
	   }
	 return isValid;  
   }
// //  public static void main( String[] args )
//  //  {
//  ///  	Scanner sc=new Scanner(System.in);
//    //	initialize();
//   // 	App app=new App();
////    	app.insert();
////    	System.out.println("Enter product id for which you want to retrieve data: ");
////    	int productIdd=sc.nextInt();
////    	sc.nextLine();
////    	List<Product> list=app.retrieve(productIdd);
////    	list.forEach(new Consumer<Product>() {
////			public void accept(Product i) {
////				System.out.println("Product Name: "+i.getName()+"ProductId: "+i.getId());
////			}
////		});
////    	System.out.println("Enter category id for which you want to retrieve all the products ");
////    	int catid=sc.nextInt();
////    	sc.nextLine();
////    	List<Product> list2=app.fetchData(catid);
////    	list2.forEach(new Consumer<Product>() {
////			public void accept(Product p) {
////				System.out.println("Product Name: "+p.getName()+"ProductId: "+p.getId());
////			}
////		});
////    	System.out.println("Enter for which product you want to modify the price: ");
////    	int userInput=sc.nextInt();
////    	sc.nextLine();
////    	System.out.println("Enter the price: ");
////    	int userInput2=sc.nextInt();
////    	sc.nextLine();
////    	if(app.updatePrice(userInput, userInput2)) {
////    		System.out.println("Updated Succesfully of id "+userInput+"to price"+userInput2);
////    	}
////    	System.out.println("Enter producId for which you want to change category: ");
////    	int userinput3=sc.nextInt();
////    	sc.nextLine();
//// 	System.out.println("Enter new categoryId");
////    	int userinput4=sc.nextInt();
////    	sc.nextLine();
////    	if(app.updateCategory(userinput3, userinput4)) {
////    		System.out.println("Updated Succesfully of id "+userinput3+" to category "+userinput4);
////    	}
////    	List<Product> list= app.getDetails();
////    	for (Product i : list) {
////    		System.out.println("Product Id: "+i.getId()+"productName: "+i.getName()+"Price: "+i.getPrice()+"Quantity: "+i.getQuantity()+"Category: "+i.getCategoryId().getId()+"\n");
////		}
////    	System.out.println("Enter productId for which you want to delete: ");
////    	int userInput5=sc.nextInt();
////    	sc.nextLine();
////    	if(app.deleteProduct(userInput5)) {
////    		System.out.println("Succcessfully Deleted of Product with Id: "+userInput5);
////    	}
////    	else {
////    		System.out.println("There is no product with this productId");
////    	}
////    	System.out.println("Enter the categoryId");
////    	int userInput6=sc.nextInt();
////    	sc.nextLine();
////    	if(app.deleteCategory(userInput6)) {
////    		System.out.println("Deleted Successfully");
////    	}else {
////    		System.out.println("Unsuccessful");
////    	}
////    	System.out.println("Enter the threshold price ");
////    	int price=sc.nextInt();
////    	sc.nextLine();
////    	List<Product> list=app.fetchProduct(price);
////    	for (Product product : list) {
////			System.out.println("Product Id: "+product.getId()+"Product Name: "+product.getName()+"Price: "+product.getPrice());
////		}
//    	//System.out.println("Enter productId: ");
////    	int userInput7=sc.nextInt();
////    	sc.nextLine();
////    	System.out.println("Enter productName: ");
////    	String userInput8=sc.nextLine();
////    	System.out.println("Enter Price: ");
////    	int userInput9=sc.nextInt();
////    	sc.nextLine();
////    	System.out.println("Enter Quantity: ");
////    	int userInput10=sc.nextInt();
////    	sc.nextLine();
////    	System.out.println("EnterCategoryid: ");
////    	int userInput11=sc.nextInt();
////    	sc.nextLine();
////    	System.out.println("Enter new CategoryId");
////    	int userInput12=sc.nextInt();
////    	sc.nextLine();
////    	if(app.insertUpdate(userInput7, userInput8, userInput9, userInput10, userInput11, userInput12)) {
////    		System.out.println("Inserted Successfully: ");
////    	}else {
////    		System.out.println("Unsuccessful");
////    	}
//    	System.out.println("Enter valid categoryID: ");
//    	int userInput13=sc.nextInt();
//    	sc.nextLine();
//    	System.out.println("enter the new name: ");
//   	String userInput14=sc.nextLine();    	if(app.updateCategoryName(userInput13, userInput14)) {
//    		System.out.println("Updated successfully");
//    	}else
//    		System.out.println("categoryId is Invalid!!!!!!!");
//    	sc.close();
//    	session.close();
////    }
//}
   public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    initialize();
	    App app = new App();

	    int choice;
	    try {
	    	do {
		        System.out.println("Choose an option:");
		        System.out.println("1. Insert product");
		        System.out.println("2. Retrieve a specific product");
		        System.out.println("3. Retrieve all products");
		        System.out.println("4. Fetch products belonging to a category");
		        System.out.println("5. Update the price of a product");
		        System.out.println("6. Update the category of a product");
		        System.out.println("7. Delete a specific product");
		        System.out.println("8. Delete a category and associated products");
		        System.out.println("9. Fetch products with price above a certain threshold");
		        System.out.println("10. Insert or update a product");
		        System.out.println("11. Update the name of a category and its associated products");
		        System.out.println("0. Exit");

		        choice = scanner.nextInt();
		        scanner.nextLine();

		        switch (choice) {
		            case 1:
		                // Insert a new product
		                app.insert();
		                break;
		            case 2:
		                // Retrieve a specific product based on its ID
		                System.out.println("Enter the product ID:");
		                int productId = scanner.nextInt();
		                scanner.nextLine();
		                List<Product> productList = app.retrieve(productId);
		                for (Product product : productList) {
		                    System.out.println("Product Name: " + product.getName() + ", Product ID: " + product.getId());
		                }
		                break;
		            case 3:
		                // Retrieve all products from the database
		                List<Product> allProducts = app.getDetails();
		                for (Product product : allProducts) {
		                    System.out.println("Product ID: " + product.getId() + ", Product Name: " + product.getName() +
		                            ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity() +
		                            ", Category ID: " + product.getCategoryId().getId());
		                }
		                break;
		            case 4:
		                // Fetch all products belonging to a particular category
		                System.out.println("Enter the category ID:");
		                int categoryId = scanner.nextInt();
		                scanner.nextLine();
		                List<Product> categoryProducts = app.fetchData(categoryId);
		                for (Product product : categoryProducts) {
		                    System.out.println("Product ID: " + product.getId() + ", Product Name: " + product.getName());
		                }
		                break;
		            case 5:
		                // Update the price of a product
		                System.out.println("Enter the product ID:");
		                int productToUpdateId = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the new price:");
		                int newPrice = scanner.nextInt();
		                scanner.nextLine();
		                boolean priceUpdated = app.updatePrice(productToUpdateId, newPrice);
		                if (priceUpdated) {
		                    System.out.println("Product price updated successfully.");
		                } else {
		                    System.out.println("Failed to update product price.");
		                }
		                break;
		            case 6:
		                // Update the category of a product
		                System.out.println("Enter the product ID:");
		                int productToUpdateCategoryId = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the new category ID:");
		                int newCategoryId = scanner.nextInt();
		                scanner.nextLine();
		                boolean categoryUpdated = app.updateCategory(productToUpdateCategoryId, newCategoryId);
		                if (categoryUpdated) {
		                    System.out.println("Product category updated successfully.");
		                } else {
		                    System.out.println("Failed to update product category.");
		                }
		                break;
		            case 7:
		                // Delete a specific product
		                System.out.println("Enter the product ID:");
		                int productToDeleteId = scanner.nextInt();
		                scanner.nextLine();
		                boolean deleted = app.deleteProduct(productToDeleteId);
		                if (deleted) {
		                    System.out.println("Product deleted successfully.");
		                } else {
		                    System.out.println("Failed to delete product.");
		                }
		                break;
		            case 8:
		                // Delete a category and associated products
		                System.out.println("Enter the category ID:");
		                int categoryToDeleteId = scanner.nextInt();
		                scanner.nextLine();
		                boolean categoryDeleted = app.deleteCategory(categoryToDeleteId);
		                if (categoryDeleted) {
		                    System.out.println("Category and associated products deleted successfully.");
		                } else {
		                    System.out.println("Failed to delete category and associated products.");
		                }
		                break;
		            case 9:
		                // Fetch products with price above a certain threshold
		                System.out.println("Enter the threshold price:");
		                int thresholdPrice = scanner.nextInt();
		                scanner.nextLine();
		                List<Product> productsAboveThreshold = app.fetchProduct(thresholdPrice);
		                for (Product product : productsAboveThreshold) {
		                    System.out.println("Product ID: " + product.getId() + ", Product Name: " + product.getName() +
		                            ", Price: " + product.getPrice());
		                }
		                break;
		            case 10:
		                // Insert or update a product
		                System.out.println("Enter the product ID:");
		                int productIdInput = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the product name:");
		                String productNameInput = scanner.nextLine();
		                System.out.println("Enter the price:");
		                int priceInput = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the quantity:");
		                int quantityInput = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the category ID:");
		                int categoryIdInput = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter new CategoryId: ");
		                int categoryIdInput2=scanner.nextInt();
		                scanner.nextLine();
		                
		               // Product productInput = new Product(productIdInput, productNameInput, priceInput, quantityInput, new Category(categoryIdInput,categoryNameInput));
		                boolean insertedOrUpdated = app.insertUpdate(productIdInput, productNameInput, priceInput, quantityInput, categoryIdInput,categoryIdInput2);
		                if (insertedOrUpdated) {
		                    System.out.println("Product inserted or updated successfully.");
		                } else {
		                    System.out.println("Failed to insert or update product.");
		                }
		                break;


		            case 11:
		                // Update the name of a category and its associated products
		                System.out.println("Enter the category ID:");
		                int categoryToUpdateId = scanner.nextInt();
		                scanner.nextLine();
		                System.out.println("Enter the new category name:");
		                String newCategoryName = scanner.nextLine();
		                boolean categoryUpdatedWithName = app.updateCategoryName(categoryToUpdateId, newCategoryName);
		                if (categoryUpdatedWithName) {
		                    System.out.println("Category name and associated products updated successfully.");
		                } else {
		                    System.out.println("Failed to update category name and associated products.");
		                }
		                break;
		            case 0:
		                System.out.println("Exiting the program...");
		                break;
		            default:
		                System.out.println("Invalid choice. Please try again.");
		                break;
		        }
		    } while (choice != 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Occured :"+e.getMessage());
		}finally {
			 scanner.close();
			   session.close();
		}

	   
	}
}   