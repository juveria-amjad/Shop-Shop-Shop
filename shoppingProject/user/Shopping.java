package shoppingProject.user;
import java.util.Scanner;
public class Shopping {
	public static void main(String args[]) {
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter 1 to sign up and 2 to login");
		int e=obj.nextInt();
		if(e==1) {
			User ob=new User();
	        ob.signup();
	    }
		else {
			User ob=new User();
			ob.login();
		}
		obj.close();
	}
}

