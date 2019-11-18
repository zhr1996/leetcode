/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //priority queue
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length==0){
           return null;
       }
       PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
                       new Comparator<ListNode>(){
                           @Override
                           public int compare(ListNode node1,ListNode node2){
                               return node1.val-node2.val;
                           } 
                       });
       ListNode resultpre = new ListNode(0);
       ListNode node = resultpre;
       for(int i=0;i<=lists.length-1;i++){
           if(lists[i]!=null){
           queue.offer(lists[i]);
           }
       }
       while(!queue.isEmpty()){
           node.next = queue.poll();
           if(node.next.next!=null){
               queue.offer(node.next.next);
           }
           node = node.next;
       }
       return resultpre.next;
           
    }
}