public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode left = head;
        ListNode right = head;

        int rotation = k % (length * 2);

        while (rotation != 0) {
            ListNode prev = right;
            right = right.next;
            if (right.next == null) {
                System.out.println(right.val);
                right.next = left;
                left = right;
                prev.next = null;
                right = left;
                rotation--;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(2);
        ListNode n4 = new ListNode(1, n5);
        ListNode n3 = new ListNode(0, n4);
        // ListNode n2 = new ListNode(2, n3);
        // ListNode n1 = new ListNode(1, n2);

        Solution solution = new Solution();

        ListNode newN = solution.rotateRight(n3, 4);

        System.out.println("Result:");
        while (newN != null) {
            System.out.println(newN.val);
            newN = newN.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
