package Sortpre;

public class Bubble_Sort {
	public static void main(String[] args) {
		int[] b = {1,5,8,3,9,0,43,75,89,34,86,23,86,23,56,7};
		Bubble_Sort bubble_Sort = new Bubble_Sort();
		bubble_Sort.bubble(b);
	}
	public void bubble(int[] nums) {
		//一定要记住判断边界条件，很多人不注意这些细节，面试官看到你的代码的时候都懒得往下看，你的代码哪个项目敢往里面加？
	//***********************************************************************
    /**/if(nums==null||nums.length<2) return;//******************************
    //***********************************************************************
		//冒泡排序
		for(int i=nums.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(nums[j]>nums[j+1]) {
					//交换
					nums[j]=nums[j]^nums[j+1];
					nums[j+1]=nums[j]^nums[j+1];
					nums[j]=nums[j]^nums[j+1];
				}
			}
		}
		
	}
}
