package Sortpre;

public class Shell_Sort {
	public static void main(String[] args) {
		int[] a = {3,6,755,23,4,5,7,43,7,34,2,12,4,5,76,34,21,6,3,43,7};
		ShellSort(a);
	}
	public static void ShellSort(int[] nums) {
		//ϣ������
		if(nums==null||nums.length<2) return;
		for(int step=nums.length/2;step>=1;step=step/2) {//���Ʋ���
			for(int i=0;i<step;i++) {//ģ��ÿһ��
				for(int j=i+step;j<nums.length;j+=step) {//��������
					int temp = nums[j];
					if(nums[j-step]>temp) {
						int k=j;
						for(;k>i;k-=step) {
							if(nums[k-step]>temp) nums[k]=nums[k-step]; else break;
						}
						nums[k]=temp;
					}
				}
			}
			
		}
		for(int i=0;i<nums.length;i++) System.out.println(nums[i]);
	}
}
