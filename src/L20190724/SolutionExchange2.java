package L20190724;

/*
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionExchange2 {
	public static void main(String[] args) {
		SolutionExchange2 exchange2 = new SolutionExchange2();
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);
		ListNode cListNode = new ListNode(3);
		ListNode dListNode = new ListNode(4);
		aListNode.next=bListNode;
		bListNode.next=cListNode;
		cListNode.next=dListNode;
		System.out.println(exchange2.swapPairs(aListNode));
	}
    public ListNode swapPairs(ListNode head) {
        ListNode firsthead =  new ListNode(0);
        ListNode retuListNode = firsthead;
        firsthead.next=head;
        System.out.println(firsthead.val);
        while(firsthead.next!=null) {
        	if(firsthead.next.next==null) break;//说明没有相邻节点了，只有留下的单个节点
        	//如果没有跳出循环，说明可以有配套的相邻节点
        	//将这两个相邻节点交换
        	ListNode first = firsthead.next;
        	ListNode second = firsthead.next.next;
         first.next=second.next;
        	firsthead.next=second;
        	second.next=first;
        	firsthead = first;
        	
        }
        
        return retuListNode.next;
    }
    
    public static class ListNode{
    	public int val;
    	public ListNode next;
    	public ListNode(int x){val=x;}
    }
}
