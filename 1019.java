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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> myList = new ArrayList<>();
        
        ListNode cur = head;
        while (cur != null) {
            myList.add(cur.val);
            cur = cur.next;
        }

        int[] answer = new int[myList.size()];
        Stack<Integer> myStack = new Stack<>();

        for (int i = 0; i < myList.size(); i++) {
            int j = 1;
            while (!myStack.isEmpty() && myStack.peek() < myList.get(i)) {
                if (answer[i-j] == 0) {
                    answer[i-j] = myList.get(i);
                    myStack.pop();
                }
                j++;
            }
            
            myStack.push(myList.get(i));
        }

        return answer;

    }
}