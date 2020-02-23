package TOP100;

import java.util.HashMap;

/**
 * @author 13081
 *编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：



在节点 c1 开始相交。

 

示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection_of_Linked_Lists {
	
	
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//   暴力法     ListNode aListNode = headA;
//        ListNode bListNode = headB;
//        while(aListNode!=null) {
//        	bListNode = headB;
//        	while(bListNode!=null) {
//        		if(aListNode==bListNode) return aListNode;
//        		bListNode=bListNode.next;
//        	}
//        	aListNode=aListNode.next;
//        }
//        return null;
	/*
	 * Hash法
	 * */	
//		HashMap<ListNode, Integer> aHashMap = new HashMap<Intersection_of_Linked_Lists.ListNode, Integer>();
//		while(headA!=null) {
//			aHashMap.put(headA, 1);
//			headA=headA.next;
//		}
//		while(headB!=null) {
//			if(aHashMap.containsKey(headB)) return headB;
//			headB=headB.next;
//		}
//		return null;
		
		
		
		/*
		 * 双指针法
		 * 当headA遍历完，又从headB遍历，然后B也遍历完从A遍历
		 * A：123
		 * B：23
		 * A   B
		 * 1   2
		 * 2   3
		 * 3   1
		 * 2   2   
		 * 
		 * */
		   ListNode ha = headA, hb = headB;
	        while (ha != hb) {
	            ha = ha != null ? ha.next : headB;
	            hb = hb != null ? hb.next : headA;
	        }
	        return ha;

	
    }
	
//	public class ListNode {
//		      int val;
//		      ListNode next;
//		      ListNode(int x) {
//		          val = x;
//		          next = null;
//		      }
//		  }
}
