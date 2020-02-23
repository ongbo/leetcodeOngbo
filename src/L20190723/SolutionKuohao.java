package L20190723;

import java.util.ArrayList;
import java.util.List;

/*给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class SolutionKuohao {
	   public List<String> generateParenthesis(int n) {
	        List<String> ans = new ArrayList();
	        backtrack(ans, "", 0, 0, n);
	        return ans;
	    }

	    public void backtrack(List<String> ans, String cur, int open, int close, int max){
	        if (cur.length() == max * 2) {
	            ans.add(cur);
	            return;
	        }

	        if (open < max)//如果左括号小于n，也就是max，也就是可以拥有的左括号最大个数
	            backtrack(ans, cur+"(", open+1, close, max);
	        if (close < open)//只要右括号小于左括号，那么这个位置就可以是右括号
	            backtrack(ans, cur+")", open, close+1, max);
	    }

	
}
