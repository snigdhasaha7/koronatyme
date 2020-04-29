import java.util.PriorityQueue;

public class ToDoList {
	
	private PriorityQueue<toDoEntry> toDoList;
	
	public ToDoList()
	{
		toDoList = new PriorityQueue(5, new toDoComparator());
	}
	
	public void add(toDoEntry entry)
	{
		toDoList.add(entry); 
	}
	
	public toDoEntry viewMostUrgent()
	{
		return toDoList.peek(); 
	}
	
	public void finish()
	{
		toDoList.poll();
	}
	
	public String viewList()
	{
		Object[] displist =  toDoList.toArray(); 
		String x = "Your To-Do List: \n"; 
		for(int i = 0; i < displist.length; i++)
		{
			x += (i + 1) + ". Task: " + ((toDoEntry) displist[i]).getTask()+ "\n Due Date: " + ((toDoEntry) displist[i]).getDueDate() + "\n\n";
		}
		
		return x;
		
	}
}
