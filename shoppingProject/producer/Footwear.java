package shoppingProject.producer;
import shoppingProject.Items;

public class Footwear extends FileInteraction{
		String footwearCount= "FootwearCount";
		String footwearItems= "FootwearItems";
		public void addItem() {
			read();
			Items temp= new Items();
			temp.setCategory("Footwear");
			super.addItem(temp, footwearItems);
			increaseCount();
			read();
		}
		
		public void read() {
			int count = getCount();
			super.read(count ,footwearItems);
			
		}
		
		public void deleteItem() {
			super.deleteItem(footwearItems);
			decreaseCount();
			read();
		
		}
		
		public void edit() {
			super.edit(footwearItems);
			read();
		}
		
		public void increaseCount() {
			super.increaseCount(footwearCount);
		}
		
		public void decreaseCount() {
			super.decreaseCount(footwearCount);
		}
		
		public int getCount() {
			int fcount=super.getCount(footwearCount);
			return fcount;
		}
		
}
