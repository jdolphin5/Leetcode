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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        Map<Integer, Integer> list1Map = new HashMap<>();
        Map<Integer, Integer> list2Map = new HashMap<>();
        int i = 0;

        while (list1 != null) {
            list1Map.put(i, list1.val);
            list1 = list1.next;
            i++;
        }

        i = 0;

        while (list2 != null) {
            list2Map.put(i, list2.val);
            list2 = list2.next;
            i++;
        }

        ListNode ret = new ListNode(0);
        ListNode head = ret;

        for (int j = 0; j < list1Map.size(); j++) {
            if (j < a) {
                head.next = new ListNode(list1Map.get(j));
                head = head.next;
            }
            else if (j == a) {
                int k = 0;
                while (k < list2Map.size()) {
                    head.next = new ListNode(list2Map.get(k));
                    head = head.next;
                    k++;
                }

            }
            else if (j > b) {
                head.next = new ListNode(list1Map.get(j));
                head = head.next;
            }
        }

        return ret.next;
    }
}