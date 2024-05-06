private ListNode reverseLL(ListNode head) {
    ListNode prev = null;
    ListNode next = null;

    while (head != null) {
        next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }

    return prev;
}