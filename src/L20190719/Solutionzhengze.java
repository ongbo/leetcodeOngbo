package L20190719;

/*
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false

 * */
public class Solutionzhengze {
	public static void main(String[] args) {
		Solutionzhengze zSolutionzhengze = new Solutionzhengze();
		System.out.print(zSolutionzhengze.isMatch("", ".*"));
	}
	 public boolean isMatch(String s, String p) {
		 int i=0,j=0;
		 if(s=="") return true;
		 while(j<p.length()&&s.charAt(0)!=p.charAt(j)&&p.charAt(j)!='*'&&p.charAt(j)!='.') j++;//找到和p的元素相配的
		 //这是的i和j是相配的
		 p=p.substring(j);
		 while(j<p.length()) {
			 if(i>=s.length()) return false;
			 if(s.charAt(i)!=p.charAt(j)) {
				 if(p.charAt(j)=='.') {
					 i++;j++;
				 }else if(p.charAt(j)=='*') {
					 char t = p.charAt(j-1);
					 if(t=='.') return true;
					 while(i<s.length()&&s.charAt(i)==t) i++;
					 j++;
				 }else return false;
			 }else {i++;j++;}
		 }
		 if(i!=s.length()||j!=p.length()) return false;
		 return true;
	 }
}
