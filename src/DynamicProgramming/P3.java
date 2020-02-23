package DynamicProgramming;

import java.util.Stack;

/*
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"


 * */
public class P3 {
	/*
	 * 这个题目准确来说，用栈做是最合适的。
	 * 但是这里作为动态规划，还是用动态规划写一下
	 * 还是从暴力法开始，对于找到最长的括号匹配字串，我们只需要枚举每个字串就可以了
	 * 那么对于起始位置start，结束位置end。
	 * start有n种，end从start+1开始，时间复杂度就是O(n^2)
	 * 
	 * 当然，这里面肯定包含了重复验证的过程，比如(0,4)就包括了(0,3)，而(0,3)又包括了(1,2)，对吧，我们使用动态规划，就是使用空间换时间的方式
	 * 将重复计算后的过程存储起来，从而节省时间，
	 * 这样时间复杂度就可以计算了，从最长的，知道计算每个单个的操作，就是将这个字符串遍历一遍，从而复杂度是O(N)
	 * 
	 * */
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()()"));
	}
	public static int longestValidParentheses(String s) {
		 int maxans = 0;
	        Stack<Integer> stack = new Stack<>();
	        stack.push(-1);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {
	                stack.pop();
	                if (stack.empty()) {
	                    stack.push(i);
	                } else {
	                    maxans = Math.max(maxans, i - stack.peek());
	                }
	            }
	        }
	        return maxans;


    }
}
