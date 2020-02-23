package L20190726;

public class SolutionSearchInsert {
	public static void main(String[] args) {
		int[] a = {1,2,5,8,10};
		System.out.println(searchInsert(a, 3));
	}
	 public static int searchInsert(int[] nums, int target) {
		 //直接二分查找
		 int left = 0;
		 int right = nums.length-1;
		 int mid = (left+right)/2;
		 while(left<=right) {
			  mid = (left+right)/2;
			 if(target>nums[mid]) {
				 left = mid+1;
			 }else if(target<nums[mid]) {
				 right = mid-1;
			 }else return mid;
		 }
		 if(target<nums[mid])return mid; else return mid+1;
	 }
}
