/**
 * Definition for singly-linked list.
 * 
 */
public class LinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int ctr = 0;
		int carry = 0;
		ListNode temp = null, head = null;

		while (l1.next != null || l2.next != null) {

			// 1st node created as head
			if (ctr++ == 0) {
				head = new ListNode((carry + getNodeValue(l1) + getNodeValue(l2)) % 10);
				System.out.println("Value is - " + (carry + getNodeValue(l1) + getNodeValue(l2)) % 10);
				carry = (getNodeValue(l1) + getNodeValue(l2)) > 9 ? 1 : 0;
				temp = head;

				advancePointers(l1, l2);

			}

			else {
				ListNode newNode = new ListNode((carry + getNodeValue(l1) + getNodeValue(l2)) % 10);
				System.out.println("Value is - " + (carry + getNodeValue(l1) + getNodeValue(l2)) % 10);
				carry = (getNodeValue(l1) + getNodeValue(l2)) > 9 ? 1 : 0;
				advancePointers(l1, l2);
				
				// Add to the list
				temp.next = newNode;
				temp = newNode;
			}

		}

		return head;
	}

	public int getNodeValue(ListNode node) {
		if (node == null)
			return 0;
		return node.val;
	}

	public void advancePointers(ListNode l1, ListNode l2) {
		if (l1.next != null)
			l1 = l1.next;
		if (l2.next != null)
			l2 = l2.next;
	}
	
	public static void main(String[] args) {
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}