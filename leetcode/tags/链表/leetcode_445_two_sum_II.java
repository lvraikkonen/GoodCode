import java.util.Stack;

public class leetcode_445_two_sum_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry!=0) {
            int x = stack1.isEmpty() ? 0 : stack1.peek();
            int y = stack2.isEmpty() ? 0 : stack2.peek();
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (!stack1.isEmpty()){
                stack1.pop();
            }
            if (!stack2.isEmpty()){
                stack2.pop();
            }
        }
        return reverse(dummy.next);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
