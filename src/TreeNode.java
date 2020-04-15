
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
    private ArrayList<TreeNode<E>> children;
    private TreeNode<E> parent;
    
    public TreeNode(E elem){
        this.elem = elem;
    }
    
    public TreeNode(E elem, TreeNode<E> parent){
        this.elem = elem;
        this.parent = parent;
    }

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public ArrayList<TreeNode<E>> getChildren() {
        return children;
    }
    
    public TreeNode<E> getChild(int pos){
        return children.get(pos);
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
        
    public void addChild(E e){
        TreeNode<E> n = new TreeNode<E>(e, this);
        children.add(n);
    }

    public E removeChild(E in){
        int i = 0;
        while(i<numChildren() && !children.get(i).getElem().equals(in)){
            i++;
        }
        if(i>=numChildren()){
            return null;
        }
        return children.remove(i).getElem();
    }

    public E removeChild(int pos){
        if(pos >= numChildren()){
            return null;
        }else{
            return children.remove(pos).getElem();
        }
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
