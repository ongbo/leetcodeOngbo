package TOP100;

import java.util.Arrays;
//������
public class MajorElement {
	 public int majorityElement(int[] nums) {
		 Arrays.sort(nums);
		 int num =0;//��������ֵ
		 int a = nums[0];//���浱ǰֵ
		 int b = 0;//�������
		 int bmax = 0;
		 for(int i=0;i<nums.length;i++) {
			 if(nums[i]==a) {
				 b++;
			 }else {
				 if(b>bmax) {bmax = b; num=nums[i-1];}
				 a=nums[i];
				 b=1;
			 }
		 }
		 if(b>bmax) {num = nums[nums.length-1];}
		 
		 return num;
	 }
}
