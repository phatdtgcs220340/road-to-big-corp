/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

/**
 * Merge two sorted list
 * Difficulty: Easy
 * Type: Linked list
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = list1;
        if (list1.val > list2.val) {
            result = list2;
            list2 = list2.next;
        }
        else list1 = list1.next;
        ListNode curr = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            }
            else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list2 != null) curr.next = list2;
        else curr.next = list1;
        return result;
    }
}