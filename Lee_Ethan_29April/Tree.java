
import java.util.ArrayList;

//edited
public class Tree<E> {
    private TreeNode<E> anchor;
    
    public Tree() {
        this.anchor = new TreeNode<E>(null, null);
    } 

    public TreeNode<E> getRoot() {
        return anchor;
    }
    
    public TreeNode search(String s)
    {
        return search(anchor, s);
    }
    
    private TreeNode search(TreeNode n, String s)
    {   //System.out.println(n.getElem());
         if (n != anchor) {
             if(n.getElem() instanceof String)
             {//System.out.println("INSTANCE OF STRING");
                 if(n.getElem().equals(s))
                     return n;
             }
             else if(n.getElem() instanceof ToDoList)
             {
                 if(((ToDoList)n.getElem()).getName().equals(s))
                     return n;
             }
    } else {
        for (TreeNode child: (ArrayList<TreeNode>) n.getAllChildren()) {
            TreeNode result = search(child, s);
            if (result != null) {
                return result;
            }
        }
    }
    return n;
    }
    
    public TreeNode insert(TreeNode n, String s) //inserting a new toDoList, NOTE THE PARAMETERS ARE TREENODE OBJECTS!!!
    {
        TreeNode returnVal = null;
        if((((Object)n.getElem()) instanceof ToDoList && !(((ToDoList)n.getElem()).getName().equals(s))
                && search(s) != null && search(s).getElem() instanceof String))
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
    
    public TreeNode insert(String s) //inserting a new category of toDoLists
    {
        TreeNode returnVal = null;
        if(search(s).getElem() != null)
            System.out.println("Use a unique name for this category");
        else
            returnVal = anchor.addChild((E) s);
        return returnVal;
    }
    
    public TreeNode remove(String s) //you CAN NOT remove the anchor
    {
        TreeNode t = search(s);
        TreeNode parent = t.getParent();
        parent.removeChild(t);
        t.setParent(null);
        return t;
    }
    
//missing insert and search algos
    
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
    
    public String toString()
    {
        String s = "NEW TREE \n";
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