package TOP100;

import java.util.Arrays;

/**
 * @author 13081
 *在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
归并排序
 */
public class Sort_List {
	public static void main(String[] args) {
		Sort_List aList = new Sort_List();
//		ListNode a1 = new ListNode(6);
//		ListNode a2 = new ListNode(2);
//		ListNode a3 = new ListNode(8);
//		ListNode a4 = new ListNode(12);
//		ListNode a5 = new ListNode(9);
//		ListNode a6 = new ListNode(3);
//		ListNode a7 = new ListNode(11);
//		a1.next = a2;
//		a2.next=a3;
//		a3.next=a4;
//		a4.next=a5;
//		a5.next=a6;
//		a6.next=a7;
//		ListNode kListNode = aList.sortList(a1);
//		while(kListNode!=null) {System.err.println(kListNode.val); kListNode=kListNode.next;}
		int[] a = {3,87,4,76,32,1,87,0,43,1,7,4};
		int[] b = aList.sort(a,0,a.length-1);
		for(int i=0;i<b.length;i++) System.out.println(b[i]);
		
	}
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;//判断是不是已经没了，只剩一个节点，或者没有节点了，就不用排序
        //下面就是利用物理中的快慢速度，来找到中点
        //一个是一次跳一个节点，另一个跳两个节点，同样的速度，不同的步长，当第二个到了终点，第一个还在正中心
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {//如果是偶数个的话（1234），fast==null；；；；；如果是奇数个的话(12345),fast.next=null
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode tmp = slow.next;//tmp保存后半部分链表的头节点
        slow.next = null;//将前半部分与后半部分链表切开
        ListNode left = sortList(head);//求的前半部分链表
        ListNode right = sortList(tmp);//求的后半部分链表
        ListNode h = new ListNode(0);//新的头节点，来讲left和right合并
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;//将剩下的连接起来
        return res.next;
    }
	//非递归
	//Tn = T(n/2)
//	public int[] sort(int[] nums) {
//		
//	}
	public int[] sort(int[] nums,int start,int end) {
		if(nums==null||start==end) return new int[] {nums[start]};
		//计算中点
		int mid = (start+end)/2;
		int[] left = sort(nums, start, mid);//计算左半部分，从start------mid
		int[] right = sort(nums, mid+1, end);//计算右半部分，从mid+1------end
		
		//新建一个数组
		int[] retu = new int[left.length+right.length];
		int i=0,j=0,p=0;
		while(i<left.length&&j<right.length) {
			if(left[i]<right[j]) {
				retu[p]=left[i];
				i++;
			}else {
				retu[p]=right[j];
				j++;
			}
			p++;
		}
		if(i<left.length) for(;i<left.length;i++,p++) retu[p]=left[i];
		else if(j<right.length) for(;j<right.length;j++,p++) retu[p]=right[j];
		return retu;
		
	}
//	public int[] sort(int[] nums) {
//		if(nums==null || nums.length <2) return nums;
//		//length>2那么就找中点
//		int index = nums.length/2;//中点位置
//		int[] left = Arrays.copyOfRange(nums, 0, index);
//		int[] right = Arrays.copyOfRange(nums, index,nums.length);
//		left = sort(left);
//		right = sort(right);
//		int[] retu = new int[left.length+right.length];
//		int i=0,j=0,p=0;
//		while(i<left.length&&j<right.length) {
//			if(left[i]<right[j]) {
//				retu[p]=left[i];
//				i++;
//			}else {
//				retu[p]=right[j];
//				j++;
//			}
//			p++;
//		}
//		if (i<left.length) {
//			for(;i<left.length;i++,p++) retu[p]=left[i];
//		}else if(j<right.length) for(;j<right.length;j++,p++) retu[p]=right[j];
//		return retu;
//		
//	}

//	 public ListNode sortList(ListNode head) {
//	    	return mergesort(head);
//	    	
//	 }
//	 
//	 public ListNode mergesort(ListNode head) {
//		 int leng = length(head);//计算长度
//		 if(leng<2) return head;//长度为1，不用排序
//		 //切分
//		 int i =0;
//		 ListNode pList = head;
//		 while(i<leng/2-1) {pList = pList.next;i++;}
//		 ListNode qList = pList.next;
//		 pList.next = null;
//		 //分割排序
//		 head = mergesort(head);//左半边
//		 qList = mergesort(qList);//右半边
//		 ListNode reListNode = new ListNode(0);
//		 ListNode reListNode2  = reListNode;
//		 while(head!=null&&qList!=null) {
//			 if(head.val<qList.val) {reListNode.next = head; head = head.next; reListNode = reListNode.next;}
//			 else {reListNode.next = qList; qList = qList.next; reListNode = reListNode.next;}
//		 }
//		 if(qList!=null) reListNode.next = qList;
//		 if(head!=null) reListNode.next = head;
//		 return reListNode2.next;
//	 }
//	 public int length(ListNode head) {
//		 	ListNode tipListNode = head;
//	    	int length=0;
//	    	while(tipListNode!=null) {length++; tipListNode=tipListNode.next;}
//	    	return length;
//	 }
	
}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 