package DynamicProgramming;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * 
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 * /
 * */
public class P4 {
	public static void main(String[] args) {
		int[] nums=new int[] {-2,1,-3,4,-1,2,1,-5,4};
		P4 p4 = new P4();
		System.out.println(p4.maxSubArraybaoli(nums));
		System.out.println(p4.maxSubArrayDP(nums));
		System.out.println(p4.maxSubArray(nums));
	}
	/*
	 * 从暴力法开始，我们直接算出每个子数组的和，哪个最大就是哪个，但是这样的复杂度是非常大的，子数组有1+2+。。。+n个一共是(n+1)n/2，所以时间复杂度达到了O(N)
	 * 而我们知道，利用动态规划用空间换取时间
	 * 那么每个计算过的子序列，就不用计算了。
	 * */
	public int maxSubArraybaoli(int[] nums) {
		
		int length = nums.length;
		int max = 0;
		for(int i=0;i<length;i++) {
			int sum =0;
//			分别计算0-0，0-1，0-2，0-3........1-1，1-2，1-3.。。。。。。
			for(int j=i;j<length;j++) {
				sum=sum+nums[j];
				if(sum>max) max=sum;
			}
		}	
		return max;
	}
//	上面的暴力破解难免会有重复计算的过程
	public int maxSubArrayDP(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		for(int i=0;i<nums.length;i++) dp[i][i]=nums[i];
		int max = 0;
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<nums.length-i;j++) {
				dp[j][j+i]=dp[j][j+i-1]+nums[j+i];
				if(dp[j][j+i]>max) max=dp[j][j+i];
			}
		}
		return max;
	}
//	Kadane算法
	public int maxSubArray(int[] nums) {
		  int n = nums.length, maxSum = nums[0];
		    for(int i = 1; i < n; ++i) {
		      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
		      maxSum = Math.max(nums[i], maxSum);
		    }
		    return maxSum;

		
    }
}
