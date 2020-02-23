package L20190724;

public class SolutionRemoveDuplicates {
	public static void main(String[] args) {
		
	}  
	public int removeDuplicates(int[] nums) {
	   if(nums==null) return 0;
	   int i=0;
	   int j=1;
	   while(j<nums.length) {
		   if(nums[j]!=nums[i]) {
			   i++;
			   nums[i]=nums[j];
			   
		   }
		   j++;
	   }
	   return i+1;
	   
	}
	  
}
