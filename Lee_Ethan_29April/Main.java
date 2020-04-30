
public class Main {
/*EXPECTED:
    NEW TREE
    CATEGORY: SCHOOL; ENTRIES:
    
    NEW TREE
    CATEGORY: SCHOOL; ENTRIES:
    
 WAS:
    NEW TREE 
    CATEGORY: SCHOOL; ENTRIES:
    
    NEW TREE
    */
    public static void main(String[] args) {
        ToDoList a = new ToDoList("Homework");
        ToDoList b = new ToDoList("Job Interviews");
        ToDoList c = new ToDoList("Art");
        ToDoList d = new ToDoList("Workouts");
        ToDoList e = new ToDoList("Homework");
        ToDoList f = new ToDoList("Church Events");
        Tree t = new Tree();
        //System.out.println(t.toString());
        //t.insert(new TreeNode(a), "SCHOOL"); //Except INSERTION ERROR: check that you are referring
        //System.out.println(t.toString());
        t.insert("SCHOOL");
        System.out.println(t.toString()); //functions correctly
        System.out.println(t.toString()); //PROBLEM STARTS HERE: tree is now blank
        
        
        //rest of test code
        /*t.insert("WORK");
        t.insert("LIFE");
        t.insert("HEALTH");
        t.insert("LIFE"); //error should occur here
        t.search("NEW CAR"); //null
        t.insert(new TreeNode(a), "SCHOOL");
        t.insert(new TreeNode(b), "WORK");
        t.insert(new TreeNode(c), "LIFE");
        t.insert(new TreeNode(d), "HEALTH");
        t.insert(new TreeNode(e), "SCHOOL"); //error should occur here
        t.insert(new TreeNode(e), "LIFE"); //error should occur here
        t.insert(new TreeNode(f), "LIFE");
        t.search("LIFE").getAllChildren();
        t.search("Church Events");
        t.search("Job Interviews");
        t.search("SCHOOL").getAllChildren();
        t.search("Do Nothing"); //null
        /*t.remove("Art");
        t.search("LIFE").getAllChildren();
        t.remove("HEALTH");
        t.search("HEALTH").getAllChildren(); //null*/
    }
    
     
}
