package cn.javon.leetcode.easy._021_mergetwosortedlists;

public class ExcellentMergeTwoSortedLists {

    /**
     * First, we set up a false "prehead" node that allows us to easily return the head of the merged list later.
     * We also maintain a prev pointer, which points to the current node for which we are considering adjusting its next pointer.
     * Then, we do the following until at least one of l1 and l2 points to null: if the value at l1 is less than or equal to the value at l2,
     * then we connect l1 to the previous node and increment l1. Otherwise, we do the same, but for l2.
     * Then, regardless of which list we connected, we increment prev to keep it one step behind one of our list heads.
     * After the loop terminates, at most one of l1 and l2 is non-null. Therefore (because the input lists were in sorted order),
     * if either list is non-null, it contains only elements greater than all of the previously-merged elements.
     * This means that we can simply connect the non-null list to the merged list and return it.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
