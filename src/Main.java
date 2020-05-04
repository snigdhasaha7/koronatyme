public class Main {
/*EXPECTED:
    NEW TREE
    CATEGORY: SCHOOL; ENTRIES:
    CATEGORY: WORK; ENTRIES:
    
  BUT WAS
    NEW TREE
    CATEGORY: SCHOOL; ENTRIES:
    CATEGORY: SCHOOL; ENTRIES:
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
        //System.out.println(t.toString()); 
        t.insert("WORK");
        t.insert("LIFE");
        t.insert("HEALTH");              
        t.insert("LIFE"); //error should occur here
        System.out.println(t.search("NEW CAR")); //null
        
        t.insert(a, "SCHOOL");
        
        t.insert(b, "WORK");
        t.insert(c, "LIFE");
        t.insert(d, "HEALTH");
        t.insert(e, "SCHOOL"); //error should occur here
        t.insert(e, "LIFE"); //error should occur here
        t.insert(f, "LIFE");
        //System.out.println(t.toString());
        System.out.println(((ToDoList)t.search("Church Events").getElem()).getName());
        System.out.println(((ToDoList)t.search("Job Interviews").getElem()).getName());
        System.out.println(((ToDoList)((TreeNode) t.search("SCHOOL").getAllChildren().get(0)).getElem()).getName()); //Homework
        System.out.println(t.search("Do Nothing")); //null
        t.remove("Art");
        t.remove("Job Interviews");
        System.out.println(t.toString());
    }
    
     
}