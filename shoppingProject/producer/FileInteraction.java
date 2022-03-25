package shoppingProject.producer;
import java.io.*;
import java.util.*;
import shoppingProject.Items;

public class FileInteraction {
	LinkedList<Items> item= new LinkedList<Items>();
	Scanner obj= new Scanner(System.in);
	
	public void write(String ITEMS_FILE) {
		try {
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(ITEMS_FILE));
			for(Items var: item) {
				out.writeObject(var);
			}
			out.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Caught: "+e);
		} 
		catch (IOException e) {
			System.out.println("Caught: "+e);
		}
	}
	
	
	public void read(int count , String ITEMS_FILE) {
		try {
			item.clear();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(ITEMS_FILE));
			int i=0;
			Items temp;
			while(i<count) {
				temp=(Items)in.readObject();
				item.add(temp);
				i++;
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Caught: "+ e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Caught: "+e);
		}
		catch(IOException e) {
			System.out.println("Caught: "+ e);
		}
	}
	
	public void addItem(Items temp, String ITEMS_FILE) {
		System.out.println("Enter the details: ID,Name,Price, Size,Quantity");
		temp.setId(obj.nextInt());
		obj.nextLine();
		String name= obj.nextLine();
		temp.setName(name);
		temp.setPrice(obj.nextDouble());
		temp.setSize(obj.nextInt());
		temp.setQuantity(obj.nextInt());
		item.add(temp);
		write(ITEMS_FILE);
	}
	
	
	public void display() {
		Items temp;
		ListIterator<Items> itr = item.listIterator();
		while(itr.hasNext()) {
		temp= itr.next();
		System.out.println(temp + " Quantity: "+ temp.getQuantity());
		}
	}
	
	public void deleteItem(String ITEMS_FILE) {
		System.out.println("Enter the Id you want to delete: ");
		int del= obj.nextInt();
		Items temp;
		ListIterator<Items> itr= item.listIterator();
		while(itr.hasNext()) {
			temp= itr.next();
			if(temp.getId() == del){
				itr.remove();
				break;
			}
		}
		write(ITEMS_FILE);
	}
	
	public void edit(String ITEMS_FILE) {
		System.out.println("Enter the ID to edit: ");
		int edit = obj.nextInt();
		Items temp;
		ListIterator<Items> itr= item.listIterator();
		while(itr.hasNext()) {
			temp= itr.next();
			if(temp.getId() == edit) {
				System.out.println("1. ID\t2. Name\t3. Price\t4. Size\t5. Quantity");
				int choice= obj.nextInt();
				obj.nextLine();
				switch(choice) {
				case 1: System.out.println("Enter new Id: ");
						temp.setId(obj.nextInt());
						break;
				case 2: System.out.println("Enter new Name: ");
						temp.setName(obj.nextLine());
						break;
				case 3: System.out.println("Enter new Price: ");
						temp.setPrice(obj.nextDouble());
						break;
				case 4: System.out.println("Enter new Size: ");
						temp.setSize(obj.nextInt());
						break;
				case 5: System.out.println("Enter new Quantity: ");
						temp.setQuantity(obj.nextInt());
				default: System.out.println("Invalid Input");
				}
			}
				
		}
		write(ITEMS_FILE);
	}
	
	public void increaseCount(String COUNT_FILE) {
		int icount=0;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(COUNT_FILE));
			if(in.available()>0)
				icount=in.readInt();
			in.close();
			icount++;
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(COUNT_FILE));
			out.writeInt(icount);
			out.close();
		} 
		catch (FileNotFoundException e) {
			System.out.print("Caught: ");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("Caught: "+e);
			e.printStackTrace();
		}
	}
	
	public void decreaseCount(String COUNT_FILE) {
		int dcount=0;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(COUNT_FILE));
			if(in.available()>0)
				dcount=in.readInt();
			in.close();
			dcount--;
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(COUNT_FILE));
			out.writeInt(dcount);
			out.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Caught: "+e);
		} 
		catch (IOException e) {
			System.out.println("Caught: "+e);
		}
	}
	
	public int getCount(String COUNT_FILE) {
		int fcount=0;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(COUNT_FILE));
			fcount=in.readInt();
			in.close();
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Caught: "+e);
		} 
		catch (IOException e) {
			System.out.println("Caught: "+e);
		}
		return fcount;
	}

}
