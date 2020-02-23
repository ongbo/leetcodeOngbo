package L20190720;

/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class SolutionThglongString {
	public static void main(String[] args) {
		SolutionThglongString thglongString = new SolutionThglongString();
		System.out.println(thglongString.longestCommonPrefix(new String[] {"abc","abb"}));
	}
	 public String longestCommonPrefix(String[] strs) {
		 int minlength=10000000;
		 String minString ="";
		 for(int i=0;i<strs.length;i++) if(strs[i].length()<minlength) {minlength=strs[i].length();minString=strs[i];}

		 String pubString = "";
		 if(minString.equals("")) return "";
		 for(int i=0;i<minlength;i++) {
			 String string = minString.substring(0,i+1);
			 for(int j=0;j<strs.length;j++) {
				 if(!strs[j].substring(0,i+1).equals(string)) return pubString;
			 }
			 pubString = string;
		 }
		 
		 return pubString;
		 
	 }
}
