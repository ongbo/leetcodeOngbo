package TOP100;

/**
 * @author 13081
 *反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
        //反转一个单向链表
		ListNode prev = null;
		ListNode currnt = head;
		
		while(currnt!=null) {
			ListNode tempListNode = currnt.next;
			currnt.next = prev;
			prev = currnt;
			currnt = tempListNode;
		}
		return prev;
    }
}
