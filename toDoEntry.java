
import java.util.Calendar;
import java.util.Date;




public class toDoEntry {
    
    private String task; //task
    private String category; //category
    private long dueDate; //due date
    private long entryDate; //date inserted
    private int urgency; //helps determine color associated based on the days between due date and date inserted
    private boolean userurgency; //indicates if user set the urgency
    int hashCode;


    //constructors. if category or urgency values are blank, modify the parameters with default vals and put them into one of the constructors below. 
    //if time is blank see the bottom constructor
    //default category: "default", default dueDate: 24 hrs after entryDate, default urgency: 1
    public toDoEntry(String t, String c, int month, int day, int year, int hour, int min, int u)
    {
        task = t;
        category = c;
        dueDate = date(month, day, year, hour, min);
        Calendar calendar = Calendar.getInstance();
        entryDate = calendar.getTimeInMillis();
        urgency = u;
        int hashCode = hashCode();
        userurgency = false;
    }
   
    public toDoEntry(String t, String c, int u)
    {
        task = t;
        category = c;
        Calendar calendar = Calendar.getInstance();
        entryDate = calendar.getTimeInMillis();
        dueDate = entryDate + 86400000; //86,400,000 millis per day
        urgency = u;
        int hashCode = hashCode();
        userurgency = false;
    }
    
    //private method for constructors and setDueDate
    private long date(int M, int d, int y, int h, int m)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, M - 1, d, h, m, 0);
        return calendar.getTimeInMillis();
    }
    
    //getters and setters
     public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDueDate() {
        Date d = new Date(dueDate);
        String ds = d.toString();
        return ds;
    }
    
    public String getEntryDate()
    {
        Date d = new Date(entryDate);
        String ds = d.toString();
        return ds;
    }

    public void setDueDate(int month, int day, int year, int hour, int min) {
        this.dueDate = date(month, day, year, hour, min);
        Calendar calendar = Calendar.getInstance();
        entryDate = calendar.getTimeInMillis();
        update();
    }
    
    public void setEntryDate(int month, int day, int year, int hour, int min) //for testing only
    {
        entryDate = date(month, day, year, hour, min);
        update();
    }
    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) { //user input, if this is done by user the automatic update() method will NOT be used
        this.urgency = urgency; 
        userurgency = true;
    }
    
    public int getHashCode() {
        return hashCode;
    }
    
    //this modifies the urgency automatically, not the same as setUrgency, which is the result of user input
    public void update() //CALL THIS METHOD REGULARLY WHEN ACCESSING OBJECT PROPERTIES FOR THE FIRST TIME
    {
        if(!userurgency)
            {
                Calendar calendar = Calendar.getInstance();
                long current = calendar.getTimeInMillis();
                System.out.println("currently " + current);
                System.out.println("duedate   " + dueDate);
                System.out.println(dueDate - entryDate);
                if(current > dueDate) //overdue
                    {
                        urgency = 4;
                    }               
                else if(dueDate - entryDate > 86400000 )
                {                                   //to do entries put in more than a day before due date;
                    if(dueDate - current < 86400000) //if there are less than 24 hours before dueDate urgency dialed up to 3
                            urgency = 3;
                    else if(dueDate - current < 172800000) // if there are less than 48 hours before dueDate
                    {
                        if(current - entryDate > 86400000)
                        urgency = 2;
                    else
                        urgency = 1;
                        
                        
                    }
                }
                else   
                    urgency = 1;
         
            }
    }
    public String toString()
    {
        return "TASK: " + getTask() + "\nCATEGORY: " + getCategory() + "\nDUE DATE: " + getDueDate() + "\nDATE ENTERED: "
                + getEntryDate() + "\nURGENCY: " + getUrgency() + "\nHASHCODE: " + getHashCode(); 
    }
}
