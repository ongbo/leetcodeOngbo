package L20190729;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 * 
 * */
public class Solutionpermute {
	public static void main(String[] args) {
		int[] a  = new int[] {1,2,3};
		Solutionpermute aSolutionpermute = new Solutionpermute();
		System.out.println(aSolutionpermute.permute(a));
	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>  retuList = new ArrayList<List<Integer>>();
		int[] havenums = new int[nums.length];
		for(int i=0;i<havenums.length;i++) havenums[i]=0;
		backtrack(nums, havenums, new ArrayList<Integer>(), retuList);
		return retuList;
	}
	public static void backtrack(int nums[],int[] havenums,ArrayList<Integer> temp,List<List<Integer>> retuList){
		if(temp.size()>=nums.length) {//说明排列差不多了
			System.out.println(temp);
			retuList.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(havenums[i]==0) {//还没有被用过
				havenums[i]=1;
				temp.add(nums[i]);
				backtrack(nums, havenums,temp,retuList);
				havenums[i]=0;
				temp.remove(temp.size()-1);
			}
		}
	}
}
