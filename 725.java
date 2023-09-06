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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        ListNode[] ret = new ListNode[k];
        
        while (cur != null) { 
            size++;
            cur = cur.next;
        }

        int baseSizeEach = size / k;
        int rem = size % k;

        int i = 0;
        int j = 0;
        int offset = 0;
        
        while (i < k) {
            ListNode myListNode = new ListNode();
            ListNode myListNodeHead = new ListNode(0);
            myListNodeHead = myListNode;

            while ((j == (i+1) * baseSizeEach + offset && rem >= 1) || (j < (i+1) * baseSizeEach + offset) && head != null) {
                if (j == (i+1) * baseSizeEach + offset && rem >= 1) {
                    offset++;
                    myListNode.next = new ListNode(head.val);
                    head = head.next;
                    myListNode = myListNode.next;
                    j++;
                    rem--;
                    break;
                }

                myListNode.next = new ListNode(head.val);
                head = head.next;
                myListNode = myListNode.next;
                j++;
            }

            ret[i] = myListNodeHead.next;
            i++;
        }
        
        return ret;
    }
}