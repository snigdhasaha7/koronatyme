/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Tree<E> {
    private TreeNode<E> anchor;
    
    public Tree(E root) {
        this.anchor = new TreeNode<E>(root, null);
    } 

    public TreeNode<E> getRoot() {
        return anchor;
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
}
