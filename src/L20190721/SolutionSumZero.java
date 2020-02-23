package L20190721;
/*
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
import java.util.ArrayList;
import java.util.List;

public class SolutionSumZero {
	  
	public static void main(String[] args) {
		SolutionSumZero aSolutionSumZero = new SolutionSumZero();
		System.out.println(aSolutionSumZero.threeSum(null));
	}
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> retuList = new ArrayList<List<Integer>>();
		
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				for(int k=j+1;k<nums.length;k++) {
					if(nums[i]+nums[j]+nums[k]==0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						retuList.add(list);
					}
				}
			}
		}
		
		return retuList;
		
	
	}
}
