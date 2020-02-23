package TOP100;
/*
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */


/**
 * @author 13081
 *解题思路
 *对于a  b    c    d    e     f      g
 *假设是最大子序列和
 *我们当前最大值是a+b+c，而如果当d为负数，说明a+b+c+d要小于之前的a+b+c
 *所以当我们遍历到e的时候，如果e>a+b+c+d那么完全可以用e来代替a+b+c+d
 *在遍历e，我们需要取个值Max（e，a+b+c+d+e）这样就保证了至少在abcde之间能够有最大值（要么是abc，要么是abcde，要么是e）
 *这样就可以利用动态规划，一个个节点加进去
 *如果新节点是正数，那么理所当然加进去
 *如果是负数，先加进去，在看下一个节点，按上面的方法进行比较。
 *
 *
 *现在题目是最大乘积
 *同样的道理了
 *对于abcdefg
 *假设有最大值a*b*c
 *但是d为负数
 *那么a*b*c*d肯定为负数，而且是当前最小的负数，但是要注意的就是，可能后面还有负数，可以让这个值回归最大值
 *在最大子序列和中是只保存了最大值，那么这里既要保存最大值，也要保存最小值。
 *当新添加的值是正数时，就Max（max*nums[i],nums[i]），比较新添加的值和以前的相乘的值哪个大
 *				Min(min*nums[i],nums[i]),同时比较哪个小
 *那么一个序列就既有了大值和小值
 *但是有个前提，既然max都已经最大值了，如果新的时负数，那么还有比较的必要吗，那么直接就是之前的值大。
 *所以在知道新来的值是负数的时候，应该将max和min的值互换，那么最小负数乘以一个负数就是一个最大正数了。
 */
public class MaxProdu {
	
    public int maxProduct(int[] nums) {
      int promax = 1;
      int promin = 1;
      int retu = Integer.MIN_VALUE;
      for(int i=0;i<nums.length;i++) {
    	  if(nums[i]<0)
    	  {
    		  int tmp = promax;
    		  promax = promin;
    		  promin = tmp;
    	  }
    	  promax = Math.max(nums[i], promax*nums[i]);
    	  promin = Math.min(nums[i], promin*nums[i]);
    	  retu = Math.max(promax, retu);
      }
      return retu;
    }
}
