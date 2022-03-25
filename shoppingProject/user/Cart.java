package shoppingProject.user;
import java.util.*;

import shoppingProject.Items;

public class Cart {
	LinkedList<Items> cart = new LinkedList<Items>();
	LinkedList<Items> AddCart =new LinkedList<Items>();
	Scanner obj = new Scanner(System.in);
	double totalpay=0;
	void addToCart() {
		System.out.println("1. Add item to Cart\t2.Quit");
		int choice=0;
		do {
			System.out.print("Enter choice : ");
			choice= obj.nextInt();
			switch(choice) {
			case 1: add();
					break;
			case 2: break;
			}
			
		}while(choice!=2);
		
		if(AddCart.size()!=0) {
			cart();
		}
	
	}
	
	void add() {
		System.out.print("Enter Id : ");
		int id = obj.nextInt();
		int flag=0;
		ListIterator<Items> itr = cart.listIterator();
		Items temp;
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getId() == id) {
				flag=1;
				AddCart.add(temp);
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Invalid Id");
		}
		
	}
	
	void cart() {
	for(Items i: AddCart)
	{
		totalpay = totalpay+ i.getPrice();
	}
	System.out.println("Total cost: "+totalpay);
	System.out.println(" ------ Redirecting ------ ");
	Payment payobject=new Payment();
	payobject.pay(totalpay);
	}
	
}
