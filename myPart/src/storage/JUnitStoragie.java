package storage;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class JUnitStoragie {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSerialize () {
		 
		File testCharger= new File("hello.ser");
		try{
			testCharger.createNewFile();
			
		}
		catch (Exception e)
		{
			System.out.println(e);//String path = "C:\\Users\\muhan\\workspaceCS\\TextBuddy\\src\\myPart";
		}
			
			ArrayList <String> FileWrite = new ArrayList<String>();
			ArrayList <String> FileRead = null;
			FileWrite.add("apple");
			FileWrite.add("pear");
			FileWrite.add("chair");
			 
			//FileInputStream fis = new FileInputStream(path);
			//ObjectInputStream ois = new ObjectInputStream(fis);
			 
			//Comparison Test
			//Compares the outputed array with the one we recieve from the file.
			 
			FileInputStream fis;
			try {
			fis = new FileInputStream("hello.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			 
			FileRead= (ArrayList<String>) ois.readObject();
			fis.close();
			ois.close();
			 
			 
			 
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
			int i =0;
			while (i<=FileWrite.size()-1)
			{
			String writternBean = FileWrite.get(i);
			String readBean = FileRead.get(i);
			 assertEquals(writternBean,readBean);
			 
			//it.next();
			i++;
			}
			 
			 
			

		//fail("Not yet implemented");
	}

	/*@Test
	public void testDeserialize() {
		finals =storagie.deserialize(testCharger);
		fail("Not yet implemented");
	}*/

}
