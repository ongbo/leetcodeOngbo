package L20190801;
/*
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class SolutionJump {
	int minjump=10000;
	public static void main(String[] args) {
		int[] a= {2,3,1,1,4};
		SolutionJump jump = new SolutionJump();
		System.out.println(jump.jump(a));
	}
	 public int jump(int[] nums) {
		  int end = 0;
		    int maxPosition = 0; 
		    int steps = 0;
		    for(int i = 0; i < nums.length - 1; i++){
		        //找能跳的最远的
		        maxPosition = Math.max(maxPosition, nums[i] + i); 
		        if( i == end){ //遇到边界，就更新边界，并且步数加一
		            end = maxPosition;
		            steps++;
		        }
		    }
		    return steps;

	
		 //	        backtrack(0, nums, 0);
//	        return minjump;
	 }
//	 public void backtrack(int jump,int[] nums,int index) {//nums是跳跃数组，index是当前跳到了哪个位置,jump是跳的步数
//		 if(index+1>=nums.length) {
//			 if(jump<minjump) minjump=jump;
//			 return;
//		 }
//		 for(int i=1;i<=nums[index];i++) {
//			 backtrack(jump+1, nums, i+index);
//		 }
//	 }
}
