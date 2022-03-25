package shoppingProject.producer;
import shoppingProject.Items;

public class Clothing extends FileInteraction{
	String clothingItems= "ClothingItems";
	String clothingCount= "ClothingCount";
	public void addItem() {
		read();
		Items temp = new Items();
		temp.setCategory("Clothing");
		super.addItem(temp, clothingItems);
		increaseCount();
		read();
	}
	
	public void read() {
		int count = getCount();
		super.read(count ,clothingItems);
	}
	
	public void deleteItem() {
		super.deleteItem(clothingItems);
		decreaseCount();
		read();
	
	}
	
	public void edit() {
		super.edit(clothingItems);
		read();
	}
	
	public void increaseCount() {
		super.increaseCount(clothingCount);
	}
	
	public void decreaseCount() {
		super.decreaseCount(clothingCount);
	}
	
	public int getCount() {
		int ccount=super.getCount(clothingCount);
		return ccount;
	}
	

}
