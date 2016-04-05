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
	 
	public static void serialize(ArrayList<Task> tasks, File charger) {
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
	public static ArrayList<Task> deserialize(File charger) {
		
		try {
			FileInputStream fileIn = new FileInputStream(charger);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Task> tasks = (ArrayList<Task>) in.readObject();
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
		
		ArrayList <Task> task = new ArrayList <Task>();  
		File charger= new File("charger");
		Task test = new Task();
		test.changeName("hard");
		task.add(test);
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
