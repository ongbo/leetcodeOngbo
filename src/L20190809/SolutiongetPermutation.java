package L20190809;

import java.util.ArrayList;
import java.util.List;

/*
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutiongetPermutation {
	public static void main(String[] args) {
		System.out.println(getPermutation(3, 2));
	}
	public static String getPermutation(int n, int k) {
		List<Integer> aIntegers = new ArrayList<Integer>();
		for(int i=1;i<=n;i++) aIntegers.add(i);
        int s = 1;
        for(int i=1;i<=n;i++) s=s*i;
        StringBuilder retuBuilder = new StringBuilder();
        for(int i=n;i>1;i--) {
        	s=s/i;//代表根据第一位情况分别有多少中排列        	
        	retuBuilder=retuBuilder.append(aIntegers.get((k-1)/s));
        	aIntegers.remove((k-1)/s);
        	k=(k-1)%s+1;//表示代表剩下的几位中的第几个
        
        }
        return retuBuilder.append(aIntegers.get(0)).toString();
    }
}
