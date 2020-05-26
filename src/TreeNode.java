import java.util.ArrayList;

//edited
public class TreeNode <E> {
    private E elem;
    private ArrayList<TreeNode<E>> children;
    private TreeNode<E> parent;
    
    public TreeNode(E elem){
        this.elem = elem;
        children = new ArrayList<>();
    }
    
    public TreeNode(E elem, TreeNode<E> parent){
        this.elem = elem;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

//    public PriorityQueue<TreeNode<E>> getChildren() {
//        return children;
//    }
    
    public TreeNode<E> getFirstChild(){
        return children.get(0);
    }

    public void setChildren(ArrayList<TreeNode<E>> children) {
        this.children = children;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }
    
    public int numChildren(){
        return children.size();
    }
        
    public TreeNode addChild(E e){
        TreeNode<E> n = new TreeNode<E>(e, this);
        children.add(n);
        return n;
    }
    
    public TreeNode addChild(int priority, E e){
        TreeNode<E> n = new TreeNode<>(e, this);
        children.add(priority, n);
        return n;
    }

    public ArrayList<TreeNode<E>> getAllChildren(){
//        PriorityQueue<TreeNode<E>> local = new PriorityQueue<>(children);
//        System.out.print(children.peek().getElem());
        
        return children;
    }
    
    
    public E removeChild(E in){
        
        ArrayList<TreeNode<E>> elements = new ArrayList<>();
        for(int i=0;i<children.size();i++){
            if(children.get(i).getElem().equals(in)){
                return children.remove(i).getElem();
            }
        }
        return null;
    }
    
    


    public E removeFirstChild(){
        if(!children.isEmpty()) return children.remove(0).getElem();
        return null;
    }

    public boolean isInternal(){
        return numChildren()>0;
    }

    public boolean isExternal(){
        return numChildren()==0;
    }

    public boolean isRoot(){
        return parent==null;
    }

    public int getDepth(){
        return depthHelper(this);
    }

    private int depthHelper(TreeNode<E> node){
        if(node.isRoot()){
            return 0;
        }else{
            return 1 + depthHelper(node.getParent());
        }
    }
    
    
}