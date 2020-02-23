package DynamicProgramming;
/*
 * 
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class P1 {
	public static void main(String[] args) {
		System.out.println("the result:  "+DPlongestPalindrome("aba"));
	}
	//动态规划:
	/*
	 * 暴力法：将所有的字串弄出来，那么就一共有n+n-1+n-2+...+1=(n+1)n/2种，但是对于每个字符串都要检查，检查一次需要n的时间复杂度（即遍历每个字符）那么就需要O(n^3)
	 * 空间需要O(1)
	 * 然后使用动态规划，就是对验证过的不需要验证了。
	 * 将它存在空间中，以空间换时间
	 * 那么
	 * */
	public static String DPlongestPalindrome(String s) {

		if(s==null||s.equals("")) return "";
        //先创建P（i，j）来存储i-j是不是回文串
		int length = s.length();//这里为了避免重复获取s的长度，使用一个变量保存，提高性能
		int maxlength = 1;
		String maxString = s.substring(0, 1);
		int[][] p = new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) 
				if(i>=j) p[i][j]=1;//单个是回文串
				else p[i][j]=0;//默认全不是回文串
		}
		for(int i=2;i<length+1;i++) {//外面控制字符串长度
			for(int start=0;start<length-i+1;start++) {//控制起始位置
				int end = start+i-1;
				if(p[start+1][end-1]==1&&s.charAt(start)==s.charAt(end)) {
					p[start][end] = 1;//将这个字串置为1
					if(end-start+1 > maxlength) {
						maxlength = end-start+1;
						maxString = s.substring(start, end+1);
						System.out.println(maxString);
					}
				}
			}
		}
		return maxString;
    }
	//扩展中心算法
//	public static String CelongestPalindrome(String s) {
//		
//	}
}

