/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    List<Integer> myList;

    public Solution(ListNode head) {

        myList = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            myList.add(cur.val);
            cur = cur.next;
        }
    }
    
    public int getRandom() {
        int rand = myList.get((int)(Math.random() * myList.size()));

        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */