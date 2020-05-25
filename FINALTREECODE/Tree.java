import java.util.ArrayList;

//LEVEL 0                      ANCHOR (empty)
//LEVEL 1                      ALL CATEGORIES, which are just strings, nothing more
//LEVEL 2                      ALL TODO LISTS
//so category might be "career", and todolists might include "summer job" or "job entrance exams"

public class Tree<E> {
    private TreeNode<E> anchor; //anchor is an empty TreeNode, since it would make deletion more convenient and there is no property that justifies a todolist being an anchor

    public TreeNode<E> getAnchor() {
        return anchor;
    }
    
    public Tree() {
        this.anchor = new TreeNode<E>(null, null); //for now, we will always construct a Tree obj without parameters, meaning elements will have to be added with separate code
    } 

    public TreeNode<E> getRoot() {//getAnchor, getRoot are the same, just saw it haha
        return anchor;
    }
    
    public TreeNode search(String s)
    {
        return search(anchor, s);//basically recursive tree search algo, ALWAYS starting at the anchor and traveling down. you can search for both Categories and ToDoLists with the same method
    }
    
    private TreeNode search(TreeNode n, String s)
    {   
         if (n != anchor) {
             if(n.getElem() instanceof String)
             {
                 if(((String) n.getElem()).equals(s))
                     return n;
             }
             else if(n.getElem() instanceof ToDoList)
             {
                 if(((ToDoList)n.getElem()).getName().equals(s))
                     return n;
             }
    }
         
        for (TreeNode child: (ArrayList<TreeNode>) n.getAllChildren()) { //will always pull an arraylist of the children of anchor when initiating search
            TreeNode result = search(child, s);
            if (result != null) {
                return result;
            }
        }
    return null;
    }
    
    public TreeNode insert(ToDoList n, String s) //inserting a new TODOLIST (so that you wont have to cast to TreeNode before plugging into params)
    {
        TreeNode returnVal = null; //return value
        if(!n.getName().equals(s) && search(s) != null && search(s).getElem() instanceof String && search(n.getName()) == null)
        //conditions: n must be a todolist obj, n's name cant be same as s, s must EXIST and it must be a category name
        {
                returnVal = search(s).addChild(n);
        }
        else
        {
          System.out.println("INSERTION ERROR: check that you are referring to a valid category name or that your new "
                    + "list has a unique name"); //most common error
            
        }
        return returnVal;
            
            
    }
    
    public TreeNode insert(String s) //inserting a new CATEGORY of toDoLists
    {
        TreeNode returnVal = null;
        if(search(s) != null && search(s).getElem() != null)
            System.out.println("Use a unique name for this category");
        else
        {
            returnVal = anchor.addChild((E) s);
        }
        return returnVal;
    }
    
    public TreeNode remove(String s) //you CAN NOT remove the anchor, you CAN remove both categories and todolists simply with their name, since you can search for both types of objects by name as well
    {
        TreeNode t = search(s);
        TreeNode parent = t.getParent();
        parent.removeChild(t.getElem());
        t.setParent(null);
        return t;
    }
    
    public int getHeight(){
        return childHeight(anchor);
    }
    
    private int childHeight(TreeNode<E> node){
        if(node.isExternal()){
            return 0;
        }
        int[] children = new int[node.numChildren()];
        for(int i = 0; i < node.numChildren(); i++){
            children[i] = 1 + childHeight(node.getAllChildren().get(i));
        }
        return largestInArr(children);
    }
    
    private int largestInArr(int[] arr){
        int out = arr[0];
        for(int i:arr){
            if(i>out){
                out = i;
            }
        }
        return out;
    }
    
    public String toString() // String format of all info, mostly for testing purposes
    {
        String s = "NEW TREE \n";
        //System.out.println(anchor.getAllChildren().get(anchor.getAllChildren().size() - 1).getElem()); //should be WORK, not SCHOOL
        for(TreeNode t : anchor.getAllChildren())
        {
            s += "CATEGORY: " + t.getElem() + "; ENTRIES: ";
            for(Object n : t.getAllChildren())
            { 
                s += ((ToDoList)((TreeNode) n).getElem()).getName() + ", ";
            }
            s+= "\n";
        }
        return s;
    }
}
