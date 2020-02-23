package L20190726;

import java.awt.Robot;

/*
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
1,2,3,4,5,6
7,8,9,0,1,2,3,4,5,6
4,5,6,7,8,9,1,2,3
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class Solutionsearch {
	public static void main(String[] args) {
		int[] a = new int[] {1,3,5};
		System.out.println(search(a,3));
	}
	 public static int search(int[] nums, int target) {
		   if(nums==null||nums.length==0) return -1;
		 int length = nums.length;
		 int left = 0;
		 int right = length-1;
		 int mid = (left+right)/2;
		 while(left<right) {
			 int midnum = nums[mid];
			 if((midnum<nums[right]&&(target<=midnum||target>nums[right]))||(midnum>nums[right]&&target<=midnum&&target>nums[right])||(nums[left]<=midnum&&midnum<=nums[right]&&target<=midnum)) {
				 if(nums[mid]==target) return mid;
				 right = mid-1;
			 }else if((midnum<nums[right]&&target>=midnum&&target<nums[left])||(midnum>nums[right])&&(target>=midnum||target<nums[left])||(nums[left]<=midnum&&midnum<=nums[right]&&target>=midnum)) {
				 if(nums[mid]==target) return mid;
				 left = mid+1;
			 }
			 mid = (left+right)/2;
		 }
		 if(nums[mid]==target) return mid; else return -1;
	 }
}
