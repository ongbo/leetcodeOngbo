package Sortpre;

public class Bubble_Sort {
	public static void main(String[] args) {
		int[] b = {1,5,8,3,9,0,43,75,89,34,86,23,86,23,56,7};
		Bubble_Sort bubble_Sort = new Bubble_Sort();
		bubble_Sort.bubble(b);
	}
	public void bubble(int[] nums) {
		//һ��Ҫ��ס�жϱ߽��������ܶ��˲�ע����Щϸ�ڣ����Թٿ�����Ĵ����ʱ���������¿�����Ĵ����ĸ���Ŀ��������ӣ�
	//***********************************************************************
    /**/if(nums==null||nums.length<2) return;//******************************
    //***********************************************************************
		//ð������
		for(int i=nums.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(nums[j]>nums[j+1]) {
					//����
					nums[j]=nums[j]^nums[j+1];
					nums[j+1]=nums[j]^nums[j+1];
					nums[j]=nums[j]^nums[j+1];
				}
			}
		}
		
	}
}
