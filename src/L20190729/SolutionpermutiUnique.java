package L20190729;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
 * */
public class SolutionpermutiUnique {
	public static void main(String[] args) {
		int[] a  = new int[] {1,1,2};
		SolutionpermutiUnique aSolutionpermute = new SolutionpermutiUnique();
		System.out.println(aSolutionpermute.permute(a));
	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>  retuList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int[] havenums = new int[nums.length];
		for(int i=0;i<havenums.length;i++) havenums[i]=0;
		backtrack(nums, havenums, new ArrayList<Integer>(), retuList);
		return retuList;
	}
	public static void backtrack(int nums[],int[] havenums,ArrayList<Integer> temp,List<List<Integer>> retuList){
		if(temp.size()>=nums.length) {//˵�����в����
			System.out.println("h");
			retuList.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(i>0&&nums[i]==nums[i-1]&&havenums[i-1]==0) continue;//������һ���ķ�֧�ˣ���ʱ���������
			
			if(havenums[i]==0) {//��û�б��ù�
				havenums[i]=1;
				temp.add(nums[i]);
				backtrack(nums, havenums,temp,retuList);
				havenums[i]=0;
				temp.remove(temp.size()-1);
			}
		}
	}
}
