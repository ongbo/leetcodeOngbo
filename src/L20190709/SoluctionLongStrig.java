package L20190709;
/*
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


执行用时 :
9 ms, 在所有 Java 提交中击败了96.41%的用户
内存消耗 :37.3 MB, 在所有 Java 提交中击败了93.19%的用户
炫耀一下:
 * */
public class SoluctionLongStrig {
	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring("hkcpmprxxxqw"));
	}
	 public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.equals("")) return 0;
		 int leng=1;		
		int lastindex=0;
		int startindex = 0;//起点位置,初始化0
		int endindex=0;
		while((startindex<s.length()-leng+1)) {
			endindex++;
			if(endindex>=s.length()) break;
			int flag=0;
			int j=0;
			for(j=startindex;j<endindex;j++) {
				if(s.charAt(j)==s.charAt(endindex)) {flag=1;break;}
			}
			if(flag==1) {
				
				startindex=j+1;
			}else {
				if(endindex-startindex+1>leng)leng=endindex-startindex+1;
			}
		}
		
		 return leng;
	 }
}
