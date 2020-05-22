
public class Main {
	
	public static void main(String [] args)
	{
		toDoEntry one = new toDoEntry("meditate", "default", 4, 20, 2020, 4, 20, 1);
		ToDoList lister = new ToDoList(4); 
		
		lister.add(one);
		System.out.println(lister.viewList());
		
		toDoEntry next = new toDoEntry("sing", "default", 4, 19, 2020, 4, 20, 1);
		lister.add(next);
		System.out.println(lister.viewList());
		
		toDoEntry next2 = new toDoEntry("dance", "default", 4, 18, 2020, 4, 20, 1);
		lister.add(next2);
		System.out.println(lister.viewList());
		
		toDoEntry next3 = new toDoEntry("oioi", "default", 4, 19, 2020, 4, 21, 1);
		lister.add(next3);
		System.out.println(lister.viewList());
		
	}

}
