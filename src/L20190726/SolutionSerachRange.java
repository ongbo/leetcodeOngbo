package L20190726;

public class SolutionSerachRange {
	public static void main(String[] args) {
		int[] a = {1};
		int[] p = searchRange(a, 1);
		for(int  i=0;i<p.length;i++) System.out.println(p[i]);
	}
	public static int[] searchRange(int[] nums, int target) {
        //先二分查找
		int left = 0;
		int right = nums.length-1;
		int mid = (left+right)/2;
		while(left<=right) {
			System.out.println("a");
			if(target<nums[mid]) {
				right = mid-1;
			}else if(target>nums[mid]) {
				left = mid+1;
			}else {
				int i=mid,j=mid;
				while(i>=0&&nums[i]==target) i--;
				while(j<nums.length&&nums[j]==target) j++;
				int[] p = {i+1,j-1};
				return p;
			}
			mid = (left+right)/2;
		}
		return new int[] {-1,-1};
    }
}
