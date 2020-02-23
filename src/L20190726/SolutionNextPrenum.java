package L20190726;

import java.util.Arrays;

/*
 * 
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

132 231 213

2321 3221 
 13675 13765
321 
132 213
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionNextPrenum {
	public static void main(String[] args) {
		
	}
	 public static void nextPermutation(int[] nums) {
		 
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i]>nums[i-1]) {//判断i位置的数小于了i-1位置的数，这时候要i到末尾的大于i-1临界的点交换
				int j=i;
				while(j<nums.length&&nums[j]>nums[i-1])j++;
						int temp = nums[j-1];
						nums[j-1] = nums[i-1];
						nums[i-1] = temp;
						return;
			}
		}
		 //否则倒序
		 for(int i=0;i<nums.length/2;i++) {
			 int temp = nums[i];
			 nums[i] = nums[nums.length-1-i];
			 nums[nums.length-1-i] = temp;
		 }
    }
}
