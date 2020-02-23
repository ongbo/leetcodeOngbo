package ByteDance;

import java.util.Stack;

/*
 * 
 * 42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 * */
public class p1 {
	public static void main(String[] args) {
		System.out.println(trapDou(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	//栈
	public static int trap(int[] height) {
		int rain = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0;i<height.length;i++) {
			while(!stack.isEmpty()&&height[i]>height[stack.peek()]) {
				//当栈顶元素小于新的元素时，就要弹出另一个，而除了前一个元素是-1外
				//先弹出来
				int top = stack.pop();
				if(!stack.isEmpty()) {
					int boundheight = Math.min(height[i], height[stack.peek()]) - height[top];
					if(boundheight>0) rain = rain + boundheight*(i-stack.peek()-1);
				}
			}
			stack.push(i);
		}
		return rain;
    }
	//双指针
	/*
	 * 双指针就比较巧妙了，
	 * 可以想一想，只要有一个低和高的柱子，那么就可以以低的柱子为基准中间比他矮的都可以填充水到相同的高度，这样我们所有遍历就可以了，
	 * 找到两边低的，然后一次计算。
	 * */
	public static int trapDou(int[] height) {
		int rain = 0;
		int i=0,j=height.length-1;
		int imax = 0,jmax = 0;
		while(i<j) {
			if(height[i]<height[j]) {
				System.out.println("imax<=jmax");
				if(imax<=height[i]) imax = height[i];
				else {
					rain = imax-height[i]+rain;
					System.out.println(imax+":"+height[i]);
				}
				i++;
			}
			else{
				System.out.println("imax>=jmax");
				if(jmax<=height[j]) jmax = height[j];
				else {
					rain = jmax -height[j]+ rain;
					System.out.println(jmax+":"+height[j]);
				}
				j--;
			}
		}
		return rain;
	}
}
