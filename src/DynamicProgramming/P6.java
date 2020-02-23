
package DynamicProgramming;

import java.util.Stack;

/*
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class P6 {
	public static void main(String[] args) {
		
	}
	//暴力算法：就是枚举某一个起始点到没一个终点能不能构成矩形
	
	//动态规划优化暴力算法：
//	因为暴力算法里面遍历的话会有0，结果遍历会耗费时间，还不如直接找到最宽的
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0) return 0;
		int maxarea = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++) if(matrix[0][j]=='1') dp[0][j]=1; else dp[0][j]=0;
        //计算每一行每一个元素的最大高度
        for(int i=0;i<matrix.length;i++) {
        	//计算第i行的每一个元素高度
        	if(i!=0)
        	for(int j=0;j<matrix[i].length;j++)
        		if(matrix[i][j]=='1') dp[i][j]=dp[i-1][j]+1; else dp[i][j]=0;
        	//将每一行传过去
        	maxarea = Math.max(maxarea, largestRectangleArea(dp[i]));
        
        }
        return maxarea;
        
    }
	
	
//	柱状法解题
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int maxarea = 0;
		for(int i=0;i<heights.length;i++) {
			//只要下一个元素小于当前peek元素，就要将上一个高的给弹出
			while(stack.peek()!=-1 && heights[stack.peek()]>heights[i]) {
				maxarea = Math.max(maxarea, heights[stack.pop()]*(i-stack.peek()-1));
			}
			stack.push(i);
		}
		//可能还有没有弹出的
		while(stack.peek()!=-1) {
			maxarea=Math.max(maxarea, heights[stack.pop()]*(heights.length-stack.peek()-1));
		}
		return maxarea;
	}
}
