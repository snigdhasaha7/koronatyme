import java.util.LinkedList;

public class Map<toDoEntry> {
	
	//LinkedList 
	//Array 
	//hashCode 
	
	private LinkedList<toDoEntry>[] arr; 
	
	public Map() 
	{
		arr = new LinkedList[10]; 
		for(int i = 0; i < 10; i++)
		{
			arr[i] = new LinkedList();
		}
	}
	
	public void add(toDoEntry value) 
	{
			int z = Math.abs(value.hashCode()) % 10;
			arr[z].add(value);
	}
	
	public void remove(toDoEntry value) 
	{
		if(!contains(value))
			return; 
		int z = Math.abs(value.hashCode()) % 10; 
		arr[z].remove(value);
	}
	
	public boolean contains(toDoEntry value)
	{
		int z = Math.abs(value.hashCode()) % 10; 
		return arr[z].contains(value);
	}
	
	public String toString() 
	{
		String x = "";
		for(int i = 0; i < arr.length; i++)
		{ 
			x += "Key " + i + ": ";
			for(int j = 0; j < arr[i].size(); j++)
			{
				x += "Task: " + ((toDoEntry) arr[i].get(j)).getTask()+ "\n Due Date: " + ((toDoEntry) arr[i].get(j)).getDueDate() + "\n\n"
				x += "\t"; 
			}
			x += "\n";			
		}
		
		return x;
	}

}
