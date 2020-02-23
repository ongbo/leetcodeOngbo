package L20190805;
/*
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionCanJump {
	boolean[] un = new boolean[];
	public static void main(String[] args) {
		SolutionCanJump canJump = new SolutionCanJump();
		int[] nums= {2,3,1,1,4};
		System.out.println(canJump.canJump(nums));
	}
	//方法一
//	public boolean canJump(int[] nums) {
//		boolean[] un = new boolean[nums.length];
//		for(int i=0;i<nums.length;i++) un[i]=true;
//		back(nums, 0, un);
//    }

	//回溯容易超出时间限制,这里加入了自顶向下的动态规划
//	public boolean back(int[] nums,int index,boolean[] un) {
//		if(index>=nums.length-1) {
//			return true;
//		}
//		
//		for(int i=nums[index];i>=1;i--) {
//			if(i+index<un.length) {
//				if(!un[i+index]) continue;
//			}
//			if(un[i+index]&&back(nums, i+index,un)) return true;
//		}
//		un[index]=false;
//		return false;
//	}
	//方法二,
//	public boolean canJump(int[] nums) {
//		int[] un = new int[nums.length];//0代表不可以，1代表不知道，2代表可以
//		for(int i=0;i<nums.length;i++) {
//			if(i+nums[i]>=nums.length-1) un[i]=2;
//			else un[i]=1;
//		}
//		
//	}
//	public boolean back(int[] nums,int index,int[] un) {
//		if(index>=nums.length-1) return true;
//		for(int i=nums[index];i>=1;i--) {
//			if(i+index<un.length) if(un[i+index]==0) continue;
//			if(un[i+index]==2||back(nums, i+index, un)) return true;
//		}
//	}
	//方法三
	   public boolean canJump(int[] nums) {
	        Index[] memo = new Index[nums.length];
	        for (int i = 0; i < memo.length; i++) {
	            memo[i] = Index.UNKNOWN;
	        }
	        memo[memo.length - 1] = Index.GOOD;

	        for (int i = nums.length - 2; i >= 0; i--) {
	            int furthestJump = Math.min(i + nums[i], nums.length - 1);
	            for (int j = i + 1; j <= furthestJump; j++) {
	                if (memo[j] == Index.GOOD) {
	                    memo[i] = Index.GOOD;
	                    break;
	                }
	            }
	        }

	        return memo[0] == Index.GOOD;
	    }

	
	//方法四：贪心算法，从右边一个个往做移动
//	  public boolean canJump(int[] nums) {
//	        int lastPos = nums.length - 1;
//	        for (int i = nums.length - 1; i >= 0; i--) {
//	            if (i + nums[i] >= lastPos) {
//	                lastPos = i;
//	            }
//	        }
//	        return lastPos == 0;
//	    }

	
}
