/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode answer = null;

        ListNode prev = null;
        int remainder = 0;
        while (c1 != null || c2 != null) {

            int val1 = c1 == null ? 0 : c1.val;
            int val2 = c2 == null ? 0 : c2.val;

            int sum = val1 + val2 + remainder;
            remainder = sum / 10;
            sum = sum % 10;

            if (answer == null) {
                answer = new ListNode(sum);
                prev = answer;
            } else {
                prev.next = new ListNode(sum);
                prev = prev.next;
            }
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        if (remainder > 0) {
            prev.next = new ListNode(remainder);
        }

        return answer;
    }
}
// @lc code=end
