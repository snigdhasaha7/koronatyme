import java.util.ArrayList;

//EDITED
public class PriorityQueue<E> {

    
    static class Entry<E>{
        private int key;
        private E value;

        public Entry(int key, E value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
    
    private ArrayList<Entry<E>> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public PriorityQueue(PriorityQueue other) {
        queue = new ArrayList<>();
        while(!other.isEmpty()){
            add(other.dequeueEntry());
        }
    }
    
    public E peek(){
        return queue.get(0).getValue();
    }
    
    public E dequeue(){
        return poll();
    }
    
    public E poll(){
        return queue.remove(0).getValue();
    }
    
    public Entry dequeueEntry(){
        return queue.remove(0);
    }
    
    public void add(E e){
        //queue.add(new Entry(queue.get(queue.size()-1).getKey(), e)); //original line
        queue.add(new Entry(queue.size(), e));
    }
    
    public void add(int priority, E e){
        int i = 0;
        while(i<queue.size() && queue.get(i).getKey()<priority){
            i++;
        }
        if(i>=queue.size()){
            queue.add(new Entry(priority,e));
        }else{
            queue.add(i,new Entry(priority,e));
        }
    }
    
    private void add(Entry dequeueEntry) {
        add(dequeueEntry.getKey(), (E)dequeueEntry.getValue());
    }

    public int size(){
        return queue.size();
    }
    
    public boolean isEmpty(){
        return size()==0;
    }
}