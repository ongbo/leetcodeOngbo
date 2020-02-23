package L20190810;
/*
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionBinarySum {
	public static void main(String[] args) {
		SolutionBinarySum solutionBinarySum = new SolutionBinarySum();
		System.out.println(solutionBinarySum.addBinary("101","1011"));
	}
	/* 1010
	 * 1011
	 * 10101
	 * */
	public String addBinary(String a, String b) {
        StringBuilder retuBuilder = new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        char t = '0';
        while(i>=0&&j>=0) {
        	int c = a.charAt(i)+b.charAt(j)+t-'0'-'0'-'0';
        	if(c>=2) {
        		t='1';
        		c=c%2;
        	}else t='0';
        	retuBuilder=retuBuilder.append(c);
        	i--;j--;
        }
        if(i<0&&j<0) {
        	if(t=='1') retuBuilder.append(1);
        }else if(i>=0&&j<0) {
        	for(int m=i;m>=0;m--) {
        		int c = a.charAt(m)+t-'0'-'0';
        		if(c>=2) {
        			t='1';
        			c=c%2;
        		}else t='0';
        		retuBuilder=retuBuilder.append(c);
        	}
        	if(t=='1')retuBuilder.append(1);
        }else if(i<0&&j>=0) {
        	for(int m=j;m>=0;m--) {
        		int c = b.charAt(m)+t-'0'-'0';
        		if(c>=2) {
        			t='1';
        			c=c%2;
        		}else t='0';
        		retuBuilder=retuBuilder.append(c);
        	}
        	if(t=='1')retuBuilder.append(1);
        }
        StringBuilder reuBuilder = new StringBuilder();
        for(i=retuBuilder.length()-1;i>=0;i--) reuBuilder.append(retuBuilder.charAt(i));
        return reuBuilder.toString();
    }
}
