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
    private ListNode reverse(ListNode cur) {
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 0;

        ListNode dummyHeadRet = new ListNode();
        ListNode ret = dummyHeadRet;
        ListNode dummyHead = head;
        while (index < left-1) {
            ret.next = dummyHead;
            ret = ret.next;
            dummyHead = dummyHead.next;
            index++;
        }

        ListNode reverseListDummy = new ListNode();
        ListNode reverseList = reverseListDummy;
        while (index < right) {
            reverseList.next = dummyHead;
            reverseList = reverseList.next;
            dummyHead = dummyHead.next;
            index++;
        }

        reverseList.next = null;
        reverseListDummy = reverse(reverseListDummy.next);
        while (reverseListDummy != null) {
            ret.next = reverseListDummy;
            ret = ret.next;
            //System.out.println(ret.val);
            reverseListDummy = reverseListDummy.next;
        }

        while (dummyHead != null) {
            ret.next = dummyHead;
            ret = ret.next;
            dummyHead = dummyHead.next;
        }

        return dummyHeadRet.next;

    }
}