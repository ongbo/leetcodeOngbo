package L20190723;

import L20190723.SolutionMergeList.ListNode;

/*
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionMergerK {

	  public ListNode mergeKLists(ListNode[] lists) {
		  ListNode retuListNode = lists[0];
		  for(int i=1;i<lists.length;i++) {
			  retuListNode=mergeTwoLists(retuListNode,lists[i]);			  
		  }
		  return retuListNode.next;
	  }
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode headListNode = new ListNode(0);
			ListNode retuListNode = headListNode;
			while(l1!=null&&l2!=null) {
				if(l1.val<l2.val) {
					headListNode.next=l1;
					headListNode=headListNode.next;
					l1=l1.next;
				}else {
					headListNode.next=l2;
					headListNode=headListNode.next;
					l2=l2.next;
				}
			}
			while(l1!=null) {headListNode.next=l1;headListNode=headListNode.next;l1=l1.next;}
			while(l2!=null) {headListNode.next=l2;headListNode=headListNode.next;l2=l2.next;}
			System.out.println(retuListNode.next);
			return retuListNode.next;
	    }
	  public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
			public ListNode() {
				// TODO Auto-generated constructor stub
			}
	  }
}
