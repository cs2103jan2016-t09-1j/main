package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class storagie {
	
	 private static storagie theInstance = new storagie(); 
	 
	public static void serialize(ArrayList<String> tasks, File charger) {
		try {
			
			FileOutputStream fileOut = new FileOutputStream(charger);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tasks);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	/**
	 * Deserializes tasks.ser and casts it to an ArrayList of tasks.
	 * 
	 * @return ArrayList of tasks
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<String> deserialize(File charger) {
		
		try {
			FileInputStream fileIn = new FileInputStream(charger);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<String> tasks = (ArrayList<String>) in.readObject();
			in.close();
			fileIn.close();
			return tasks;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;
		}
	
	}
	public static void main(String args[] )
	{
		
		ArrayList <String> task = new ArrayList <String>();  
		File charger= new File("charger");
		task.add("this is hard!");
		serialize(task,charger);
		deserialize(charger);
		
	
	
	}

	public static storagie getInstance() {
		//patterns
		// page 84, restrict the number of instantiated objects of storagie class to just one.
		//use private constructor, a public method to access the single instance.
		return theInstance;
	}

}
