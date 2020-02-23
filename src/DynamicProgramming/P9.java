package DynamicProgramming;

import java.util.Stack;

/*
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class P9 {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,6,5,4,1}));
		System.out.println(maxProfit2(new int[] {3,3,5,0,0,3,1,4}));
	}
	 public static int maxProfit(int[] prices) {
	        Stack< Integer> stack = new Stack<Integer>();
	        stack.push(-1);
	        int maxprice = 0;
	        for(int i=0;i<prices.length;i++) {
	        	if(stack.peek()!=-1&&prices[i]>stack.peek()) {
	        		if(prices[i]-stack.peek()>maxprice) maxprice = prices[i]-stack.peek(); 	        		   		
	        	}else stack.push(prices[i]);
	        }
	        return maxprice;
	    }
	 public  static int maxProfit2(int[] prices) {
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(-1);
		 //分别保存两个最高的利润
		 int maxmore = 0;
		 int maxless = 0;
		 for(int i=0;i<prices.length;i++) {
			 if(stack.peek()!=-1&&prices[i]>stack.peek()) {
				 if(prices[i]-stack.peek()>maxless) maxless=prices[i]-stack.peek();
				 if(maxless>maxmore) {int temp = maxless; maxless= maxmore; maxmore = temp;}
			 }else {
				 stack.push(prices[i]);
			 }
		 }
		 return maxless+maxmore;
	 }
}
