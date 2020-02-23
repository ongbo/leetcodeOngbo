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
			ListNode[] stack = new ListNode[k];//û���޲ι��췽�������ǹ�����û��ֵ�Ľ�㡣�൱��int i;
			ListNode q = head;
			while(k>0) {//�ѵ�ǰk��������ջ�С�
				stack[i-k] = q;
				if (q!=null) q=q.next;
				else return head;//���ղ���k��ʱ��ֱ�ӷ���ԭ��������
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
