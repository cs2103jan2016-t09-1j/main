package storage;
import java.io.Serializable;

public class Task implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name=null;
	
	public Task()
	{
		
	}
	public Task (String name)
	{
		this.name=name;
		
	}
	public String getName()
	{
		return this.name;
	}
	
	public void changeName(String name)
	{
		this.name=name;
	}
	
}
