
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TreeNode <E> {
    private E elem;
    private PriorityQueue<TreeNode<E>> children;
    private TreeNode<E> parent;
    
    public TreeNode(E elem){
        this.elem = elem;
        children = new PriorityQueue<>();
    }
    
    public TreeNode(E elem, TreeNode<E> parent){
        this.elem = elem;
        this.parent = parent;
        children = new PriorityQueue<>();
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
        return children.peek();
    }

    public void setChildren(PriorityQueue<TreeNode<E>> children) {
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
        
    public void addChild(E e){
        TreeNode<E> n = new TreeNode<E>(e, this);
        children.add(n);
    }
    
    public void addChild(int priority, E e){
        TreeNode<E> n = new TreeNode<>(e, this);
        children.add(priority, n);
    }

    public ArrayList<TreeNode<E>> getAllChildren(){
        PriorityQueue<TreeNode<E>> local = new PriorityQueue<>(children);
        ArrayList<TreeNode<E>> localOut = new ArrayList<>();
        while(!local.isEmpty()){
            localOut.add(local.poll());
        }
        return localOut;
    }
    
    
    public E removeChild(E in){
        ArrayList<TreeNode<E>> children = getAllChildren();
        int i = 0;
        while(i<numChildren() && !children.get(i).getElem().equals(in)){
            i++;
        }
        if(i>=numChildren()){
            return null;
        }
        return children.remove(i).getElem();
    }

    public E removeFirstChild(){
        if(!children.isEmpty()) return children.poll().getElem();
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
