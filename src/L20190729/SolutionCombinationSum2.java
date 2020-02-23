package L20190729;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionCombinationSum2 {
	public static void main(String[] args) {
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> aList = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(candidates, 0, target, aList, new ArrayList<Integer>());
		for(int i=0;i<aList.size();i++) {
			for(int j=i+1;j<aList.size();j++) {
				if(aList.get(i).equals(aList.get(j))) {
					aList.remove(j);
					j--;
				}
			}
		}
		return aList;
	}
	public static void backtrack(int[] candidates,int start,int target,List<List<Integer>> retuList,List<Integer> temp) {
		if(target<0) return;
		if(target==0) {
			retuList.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=start;i<candidates.length;i++) {
			if(candidates[i]>target)break;
			temp.add(candidates[i]);
			backtrack(candidates, i+1, target-candidates[i], retuList, temp);
			temp.remove(temp.size()-1);
		}
	}
}
