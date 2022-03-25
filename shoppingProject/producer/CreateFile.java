package shoppingProject.producer;

import java.io.*;

public class CreateFile {

	public static void main(String[] args) {
		try {
			ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("StudentCount"));
			out.writeInt(0);
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

}
