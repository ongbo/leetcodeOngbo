package L20190731;
/*
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class SolutionTrap {
	public static void main(String[] args) {
		SolutionTrap pSolutionTrap = new SolutionTrap();
		int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(pSolutionTrap.trap(a));
	}
	 public int trap(int[] height) {
		    int left = 0, right = height.length - 1;
		    int ans = 0;
		  int 	 left_max = 0;
			int right_max = 0;
		    while (left < right) {
		        if (height[left] < height[right]) {
		            if(height[left]>=left_max) 
		            	left_max = height[left]; 
		            else ans+=(left_max - height[left]);
		            ++left;
		        }
		        else {
		            if(height[right] >= right_max) 
		            	right_max = height[right];
		            else ans += (right_max - height[right]);
		            --right;
		        }
		    }
		    return ans;

		
		 //我的算法就是从每一个找起，直到找到一个比自己高的来堵住自己要向右边流出的水
//		 int i=0,j=0;
//		 int num=0;
//		 while(i<height.length) {
//			 j=i+1;
//			 int nums =0;
//			 while(j<height.length&&height[j]<height[i]) {
//				 nums=nums+height[i]-height[j];
//				
//				 j++;
//			 }//直到找到一个比自己高的,或者等于自己的
//			 if(j>i+1&&j<height.length) {//必须是不是相邻的
//				 for(int k=i;k<j;k++) height[k]=height[i];
//				  num=nums+num;
//				  i=j;
//			 }else {//相邻两个装不了水，这时候起点编程i+1,也有可能没有找到比当前这个高的柱子，都要移动到下一个柱子
//				 i=i+1;				 
//			 }
//		 }
//		 i=height.length-1;j=height.length-1;
//		 while(i>=0) {
//			 j=i-1;
//			 int nums=0;
//			 while(j>=0&&height[j]<height[i]) {
//				 nums=nums+height[i]-height[j];
//				
//				 j--;
//			 }
//			 if(j<i-1&&j>=0) {
//				 num=num+nums;
//				 for(int k=i;k>j;k--) height[k]=height[i];
//				 i=j;
//			 }else i--;
//		 }
//		 return num;
	 }
}
