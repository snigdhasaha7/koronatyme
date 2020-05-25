import java.util.Comparator;

public class toDoComparator implements Comparator<toDoEntry>{
	
	public toDoComparator()
	{
	}
	
	public int compare(toDoEntry toDoEntry1, toDoEntry toDoEntry2)
	{
		if(toDoEntry1.getUrgency() > toDoEntry2.getUrgency())
			return -1; 
		else if(toDoEntry1.getUrgency() < toDoEntry2.getUrgency())
			return 1; 
		else
		{
			if(toDoEntry1.getDate().compareTo(toDoEntry2.getDate()) < 0)
				return -1; 
			else if(toDoEntry1.getDate().compareTo(toDoEntry2.getDate()) > 0)
				return 1;
			else
				return 0; 
		}
	}

}
