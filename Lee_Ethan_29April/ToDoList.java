import java.util.PriorityQueue;
public class ToDoList {
	
	private PriorityQueue<toDoEntry> toDoList;
        private String name; //THIS VARIABLE IS THE ONLY CHANGE I MADE
        int size = 25000; //IDK why other than to remove the compiler error on lines 36 and 38

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	public ToDoList(String s)
	{
		toDoList = new PriorityQueue(5, new toDoComparator());
                name = s;
	}
	
	public void add(toDoEntry entry)
	{
		toDoList.add(entry); 
		System.out.println(reminder()); 
	}
	
	public toDoEntry viewMostUrgent()
	{
		return toDoList.peek(); 
	}
	
	public String reminder()
	{
		if(toDoList.size() < size)
			return ""; 
		else if(toDoList.size() == size)
		{
			return "You are at your maximum size limit.";
		}
		else
		{
			return "You have exceeded your maximum size limit. Be careful not to overload!";
		}
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
