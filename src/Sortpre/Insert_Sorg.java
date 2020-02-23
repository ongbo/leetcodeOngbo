package Sortpre;

public class Insert_Sorg {
	public static void main(String[] args) {
		int[] a = {3,6,755,23,4,5,7,43,7,34,2,12,4,5,76,34,21,6,3,43,7};
		insertSort(a);
	}
	//插入排序
	public static void insertSort(int[] nums) {
		if(nums==null||nums.length<2) return;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>nums[i-1])//满足已经排好序的队列中 
			{
				int temp = nums[i];
				int j=i;
				for(;j>0;j--) {
					if(nums[j-1]<temp) nums[j]=nums[j-1];
					else break;
				}
				nums[j]=temp;
			}
		}
		for(int i=0;i<nums.length;i++) System.out.println(nums[i]);
	}
}
