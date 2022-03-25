package shoppingProject.user;
import java.util.*;
import java.time.*;

public class Payment {
	String name,address,state;
	long pincode;
	Scanner ob=new Scanner(System.in);
	void pay(double total) {
		System.out.println("Enter 1 for Online banking and 2 for COD");
		int p=ob.nextInt();
		if(p==1)
		{
		bank();	
		}
		else {
			System.out.println("total amount is "+ (total+420));
			System.out.print("Enter 1 to confirm purchase: ");
			int s=ob.nextInt();
			if(s==1) {
				address();
				details();
			}
		}
	}
	void bank() {
		address();
		String bankname,username,password;
		System.out.print("Enter the bank name : ");
		bankname=ob.nextLine();
		System.out.print("Username : ");
		username=ob.nextLine();
		System.out.print("Password : ");
		password=ob.nextLine();
		System.out.println("....Processing........");
		System.out.println("Payment was successful\n");
		details();
	}
	
	public static int getRandomInteger(int max,int min) {
		return ((int) (Math.random()*(max-min)))+min;
	}
	void address() {
		ob.nextLine();
		System.out.print("Name : ");
		name =ob.nextLine();
		System.out.print("Address : ");
		address=ob.nextLine();
		System.out.print("State : ");
		state=ob.nextLine();
		System.out.print("Pincode: ");
		pincode=ob.nextLong();
		ob.nextLine();
	}
	void details(){
		int r;
		LocalDate willbedelivered;
		System.out.println("Details\n");
		LocalDate today = LocalDate.now(); 
	    System.out.println("\nCurrent Date: "+today);
	    r=getRandomInteger(5,1);
	    willbedelivered=today.plusDays(r);
	    System.out.println(name+"\n"+address+"\n"+state+"\n"+pincode);
	    System.out.println("Your items will be delivered on "+ willbedelivered);
	    System.out.println("   ----------    Thank You For Shopping!!   -----------   ");
	    System.exit(0);
	}

}
