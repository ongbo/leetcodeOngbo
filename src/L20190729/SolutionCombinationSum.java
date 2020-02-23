package L20190729;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionCombinationSum {
	public static void main(String[] args) {
		
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	if(target<0) return null;
    	List<List<Integer>> retuList = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	combina(candidates, 0, target, retuList, new ArrayList<Integer>());
    	return retuList;
    }
    public static void combina(int[] candidates,int start,int target,List<List<Integer>> retuList,List<Integer> temp) {
    	if(target<0) return;
    	if(target==0) {
    		retuList.add(new ArrayList(temp));
    		return;
    	}
    	for(int i=start;i<candidates.length;i++) {
    		if(target<candidates[i]) break;
    		temp.add(candidates[i]);
    		combina(candidates, i, target-candidates[i], retuList, temp);
    		temp.remove(temp.size()-1);//移除掉原来的
    	}
    }
    
}
