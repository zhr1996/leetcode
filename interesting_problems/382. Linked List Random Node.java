/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    //Reservoir Sampling
    //Basically problem is if we want to select certaim amout for intance k elements
    //from a given array
    //How could we do it in one pass?
    //The solution is to first keep the first kth element 
    //and each round, determine whehter to keep the (k+i) element by generate a number from 1 to i (includive) and see if it is smaller than k
    //This means each round, an element survives with probablity k/(k+i)
    //Then next round, it changes to k/(k+i+1)
    //So eventually, every element has probablity k/n (n is the total element) to be in the chosen list.
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int k = 1;
        ListNode node = this.head;
        int res = node.val;
        int i = 0;
        ArrayList<Integer> reservoir = new ArrayList<Integer>();
        
        while (i < k && node != null) {
            reservoir.add(node.val);
            node = node.next;
            i++;
        }
        i++; // i == k  =>  i == k+1
        while (node != null) {
            if (rand.nextInt(i) < k) {
                reservoir.set(rand.nextInt(k), node.val);
            }
            i++;
            node = node.next;
        }
        return reservoir.get(0);// or return reservoir when k > 1;
    }
 
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */