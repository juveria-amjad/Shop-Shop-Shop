package shoppingProject.user;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

import shoppingProject.Items;
import shoppingProject.producer.Clothing;

public class User {
	Scanner obj=new Scanner(System.in);
	void signup() {
		JFrame frame = new JFrame("Sign Up");
		frame.setVisible(true);
		String emailid=JOptionPane.showInputDialog(frame,"Enter your emailid");
		String name=JOptionPane.showInputDialog(frame,"Enter your name");
		String gender=JOptionPane.showInputDialog(frame,"Enter your gender");
		long phone=Long.parseLong(JOptionPane.showInputDialog(frame,"Enter your mobile no."));
		String password=JOptionPane.showInputDialog(frame,"Enter your password");
		wish();
    }
	void login() {
		JFrame frame = new JFrame("Login");
		frame.setVisible(true);
		long phone=Long.parseLong(JOptionPane.showInputDialog(frame,"Enter your mobile no."));
		String otp=JOptionPane.showInputDialog(frame,"Enter the otp");	
		wish();
    }
	void wish() {
	System.out.println("Enter 1 to shop 2 to sell goods");
	int e=obj.nextInt();
	if(e==1){
		shop();
	}
	else{
		sell();
		
	 }
	}

	void shop() {
		Cart shoppingcart= new Cart();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ClothingItems"));
			int i=0;
			Items temp;
			while(i< getCount()) {
				temp=(Items)in.readObject();
				shoppingcart.cart.add(temp);
				System.out.println(temp);
				i++;
			}
			System.out.println();
			in.close();
			shoppingcart.addToCart();
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
	
	int getCount() {
		int fcount=0;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ClothingCount"));
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
	
	void sell() {
		int choice=0;
		Clothing cloth= new Clothing();
		System.out.println("1. Add\t2. Read\t3. Display\t4. Delete\t5. Edit\t 6. Quit");
		do {
			System.out.print("\nEnter choice: ");
			choice= obj.nextInt();
			switch(choice) {
			case 1: cloth.addItem();
					break;
			case 2: cloth.read();
					break;
			case 3: cloth.display();
					break;
			case 4: cloth.deleteItem();
					break;
			case 5: cloth.edit();
					break;
			case 6: System.exit(0);;
			}
			
		}while(choice!=6);
	}

}

	