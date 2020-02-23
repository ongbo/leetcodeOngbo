package L20190709;
/*
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SoluctionADD {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 	int adndum = 0;
						ListNode listNode2 = new ListNode(1);
						ListNode listNode=listNode2;
						while(l2!=null&&l1!=null){
							int ad =l1.val+l2.val+adndum;
							if(ad>=10) {ad=ad-10;adndum=1;} else adndum=0;
							ListNode xListNode = new ListNode(ad);
							listNode.next=xListNode;
							listNode=listNode.next;
							l1=l1.next;
							l2=l2.next;
						}
						while(l1!=null) {
							int ad = l1.val+adndum;
							if(ad>=10) {ad=ad-10;adndum=1;} else adndum=0;
							listNode.next=new ListNode(ad);
							listNode=listNode.next;
							l1=l1.next;
						}
						while(l2!=null) {
							int ad = l2.val+adndum;
							if(ad>=10) {ad=ad-10;adndum=1;} else adndum=0;
							listNode.next=new ListNode(ad);
							listNode=listNode.next;
							l2=l2.next;
						}
				        if(adndum!=0) listNode.next = new ListNode(adndum);
						
						return listNode2.next;

		    }
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
}
