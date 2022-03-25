package shoppingProject;
import java.io.Serializable;

public class Items implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;
	private String category;
	private int size;
	private int quantity;
	public Items() {
		id=0; price=0; size=0; quantity=0;
	}
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public int getSize() {
		return size;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public void setName(String name) {
		this.name= new String(name);
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setCategory(String category) {
		this.category= new String(category);
	} 
	public void setSize(int size) {
		this.size=size;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public String toString() {
		return "ID: "+id+" Name: "+name+" Price: "+price+" Category: "+category+" Size: "+size;
	}
}
