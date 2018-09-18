package addTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author Administrator
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l2 == null)
			return l1;
		if (l1 == null)
			return l2;

		ListNode l = new ListNode(0);
		// 循环中l会变化，所以要存储下l的最初状态
		ListNode result = l;
		int carry = 0;
		int num = 0;
		while (l1 != null || l2 != null || carry != 0) {

			ListNode l0 = new ListNode(0);
			l0.val = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry) % 10;

			carry = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry) / 10;
			l1 = (l1 == null) ? l1 : l1.next;
	        l2 = (l2 == null) ? l2 : l2.next;
			// 经典之处！！
			l.next = l0;
			l = l0;
		}
		// 经典之处！！
		return result.next;
	}
}
