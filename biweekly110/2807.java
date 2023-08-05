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
    
    private int gcd(int a, int b) {
        int i;
        if (a < b)
            i = a;
        else
            i = b;
 
        for (i = i; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        
        return 1;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        List<Integer> nums = new ArrayList<>();
        //nums.add(100);
        //nums.add(250);
        //nums.add(420);
        
        ListNode node = head;
        while(node != null) {
            nums.add(node.val);
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead.next;

        int i = 0;
        
        //System.out.println(nums.toString());
        
        while(node != null && i < nums.size()-1) {
            ListNode next = node.next; //6
            //System.out.println("node.val: " + node.val);
            //System.out.println(i);
            ListNode newNode = new ListNode(gcd(nums.get(i), nums.get(i+1))); //6
            node.next = newNode;
            newNode.next = next; //6
            node = newNode;
            node = node.next;
            //System.out.println("node.val: " + node.val);
            i++;
        }


        return dummyHead.next;
    }
}