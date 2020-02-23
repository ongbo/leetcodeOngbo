package TOP100;

import java.util.HashMap;

public class Linked_List_Cycle_II {
	public static void main(String[] args) {
		
	}
	public ListNode detectCycle(ListNode head) {
		HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
		while(head!=null) {
			if(hashMap.containsKey(head)) return head; else hashMap.put(head, new Integer(1));
			head=head.next;
		}
		return null;
    }
}
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
 