package L20190711;
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
*/
public class SolutionLongestHuiwen {
	public static void main(String[] args) {
		System.out.print(longestPalindrome("cbbd"));
	}
	//算法一样，时间复杂度一样
	 public static String longestPalindrome(String s) {
          if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);

    }
    private static int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
    }
	//这个方法超出时间限制
//	public static String longestPalindrome(String s) {
//        String longString = "";//存储当前最长回文子串
//        int length = 0;//当前最长回文子串长度
//        for(int i=0;i<s.length();i++) {
//        	//枚举每个回文子串的中心点
//        	//如果i的后面一个字符和当前i的字符一样，则优先判断模拟最长回文子串为偶数个的情况，如果不一样，则i一定是某个奇数回文子串的中心点
//        	char th = s.charAt(i);
//        	char next = 0;//保存i的后面那个字符
//        	if(i<s.length()-1) next=s.charAt(i+1);
//        	if(th==next&&i<s.length()-1) {//枚举这个回文子串可能为偶数的情况
//        		int leng = 2;
//        		String lString =""+th+next;
//        		int pre=i-1,nex=i+2;
//        		while(pre>=0&&nex<=s.length()-1) {
//        			if(s.charAt(pre)==s.charAt(nex)) {
//        				leng+=2;
//        				lString=s.charAt(pre)+lString+s.charAt(nex);
//        			}else break;
//        			pre--;nex++;
//        		}
//        		if(leng>length) {//这个偶数回文子串长度大于原来的子串
//        			length=leng;
//        			longString=lString;
//        		}
//        		
//        	}
//        	//枚举这个回文子串可能为奇数的情况
//        		//为奇数那个这个i位置的字符就是中心点，朝两边扩展
//        		int leng=1;
//        		String lString = ""+s.charAt(i);
//        		int pre=i-1,nex=i+1;
//        		while(pre>=0&&nex<=s.length()-1) {
//        			if(s.charAt(pre)==s.charAt(nex)) {
//        				leng+=2;
//        				lString=s.charAt(pre)+lString+s.charAt(nex);
//        			}else break;
//        			pre--;nex++;
//        		}
//        		if(leng>length) {
//        			length=leng;
//        			longString=lString;
//        		}
//        		if(i>s.length()/2&&length>=s.length()) break;
//        	          	
//        }
//        return longString;
//    }
}
