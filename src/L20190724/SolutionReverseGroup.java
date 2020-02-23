package L20190724;

import L20190724.SolutionExchange2.ListNode;

public class SolutionReverseGroup {
	public static void main(String[] args) {
		SolutionReverseGroup a = new SolutionReverseGroup();
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);
		ListNode cListNode = new ListNode(3);
		ListNode dListNode = new ListNode(4);
		ListNode eListNode = new ListNode(5);
		aListNode.next=bListNode;
		bListNode.next=cListNode;
		cListNode.next=dListNode;
		dListNode.next=eListNode;
		ListNode bListNode2 = a.reverseKGroup(aListNode, 3);
		while(bListNode2!=null) {System.out.println(bListNode.val); bListNode=bListNode.next;}
	}
	  public ListNode reverseKGroup(ListNode head, int k) {
			int i = k;
			ListNode[] stack = new ListNode[k];//没有无参构造方法，但是构建了没有值的结点。相当于int i;
			ListNode q = head;
			while(k>0) {//把当前k个结点存入栈中。
				stack[i-k] = q;
				if (q!=null) q=q.next;
				else return head;//结点凑不到k个时，直接返回原部分链表。
				k--;
			}
			while(k<i-1) {
				k++;
				stack[i-k].next=stack[i-k-1];
			}
			stack[0].next=reverseKGroup(q, k+1);
			return stack[i-1];
	    }

	
	  
	  
	  public static class ListNode{
		  int val;
		  ListNode next;
		  ListNode(int val){this.val = val;}
	  }
}
