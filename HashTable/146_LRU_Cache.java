import java.util.Hashtable;

class LRUCache {
    //Key point is understanding cache and how it updates which componenet is recently used
    //This is done by continuing remove and add in node in a doubly linked list.
    //Then create a hashtable, every key corressponds to a doublelinked node.
    //Use Duoblely linked list 
    //Because each time we remove a node, we can add it in front
    //so every time we know what is in the head, which is most recently used
    //and what is in the tail, which is last recently used
    
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }
    
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        
        head.next.pre = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    private DLinkedNode popTail(){
      DLinkedNode res = tail.pre;
      this.removeNode(res);
      return res;
    }
    
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        head.pre = null;
        
        tail = new DLinkedNode();
        tail.next = null;
        
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
          return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */