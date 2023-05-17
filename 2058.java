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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int twoBefore = -1;
        int oneBefore = -1;
        int index = 0;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        HashSet<Integer> mySet = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (twoBefore == -1) {
                twoBefore = cur.val;
            }
            else if (oneBefore == -1) {
                oneBefore = cur.val;
            }
            else {
                if (twoBefore < oneBefore && cur.val < oneBefore) {
                    mySet.add(index-1);
                }
                else if (twoBefore > oneBefore && cur.val > oneBefore) {
                    mySet.add(index-1);
                }

                twoBefore = oneBefore;
                oneBefore = cur.val;
            }
            cur = cur.next;
            index++;
        }

        Integer[] sortedArr = new Integer[mySet.size()];
        mySet.toArray(sortedArr);
        Arrays.sort(sortedArr);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i+1] - sortedArr[i] < minDiff) {
                minDiff = sortedArr[i+1] - sortedArr[i];
            }
        }

        if (sortedArr.length >= 2) {
            res[0] = minDiff;
            res[1] = sortedArr[sortedArr.length-1] - sortedArr[0];
        }


        return res;
    }
}