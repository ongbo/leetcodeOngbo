package L20190726;

import java.util.Arrays;

/*
 * 
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

�����������һ����������У��������������г���С�����У����������У���

����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1

132 231 213

2321 3221 
 13675 13765
321 
132 213
��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/next-permutation
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class SolutionNextPrenum {
	public static void main(String[] args) {
		
	}
	 public static void nextPermutation(int[] nums) {
		 
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i]>nums[i-1]) {//�ж�iλ�õ���С����i-1λ�õ�������ʱ��Ҫi��ĩβ�Ĵ���i-1�ٽ�ĵ㽻��
				int j=i;
				while(j<nums.length&&nums[j]>nums[i-1])j++;
						int temp = nums[j-1];
						nums[j-1] = nums[i-1];
						nums[i-1] = temp;
						return;
			}
		}
		 //������
		 for(int i=0;i<nums.length/2;i++) {
			 int temp = nums[i];
			 nums[i] = nums[nums.length-1-i];
			 nums[nums.length-1-i] = temp;
		 }
    }
}
