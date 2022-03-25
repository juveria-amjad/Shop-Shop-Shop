package shoppingProject.producer;
import java.util.Scanner;
public class ProducerMain {

	public static void main(String[] args) {
		System.out.println("1.Footwear/ 2.Clothing");
		Scanner obj= new Scanner(System.in);
		int choice = obj.nextInt();
		if(choice == 1) {
			Footwear shoe= new Footwear();
			System.out.println("1. add\t2. read\t3. display\t4. delete\t5. edit\t 6. quit");
			do {
				choice= obj.nextInt();
				switch(choice) {
				case 1: shoe.addItem();
						break;
				case 2: shoe.read();
						break;
				case 3: shoe.display();
						break;
				case 4: shoe.deleteItem();
						break;
				case 5: shoe.edit();
						break;
				case 6: break;
				}
				
			}while(choice!=6);
		}
		else if(choice == 2) {
			Clothing shoe= new Clothing();
			System.out.println("1. add\t2. read\t3. display\t4. delete\t5. edit\t 6. quit");
			do {
				choice= obj.nextInt();
				switch(choice) {
				case 1: shoe.addItem();
						break;
				case 2: shoe.read();
						break;
				case 3: shoe.display();
						break;
				case 4: shoe.deleteItem();
						break;
				case 5: shoe.edit();
						break;
				case 6: break;
				}
				
			}while(choice!=6);
		}
		obj.close();

	}

}
