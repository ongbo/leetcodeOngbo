package L20190724;
/*
 * 
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionDivide {
	public static void main(String[] args) {
		System.out.println(divide(2147483647, 1));
	}
	public  static int divide(int dividend, int divisor) {
	     if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

	        int flag = 1; // 1 表示正数，-1表示负数；
	        if (dividend > 0) {
	            dividend = -dividend;
	        } else {
	            flag = -flag;
	        }
	        if (divisor > 0) {
	            divisor = -divisor;
	        } else {
	            flag = -flag;
	        }

	        int s = 0, tmpd, k;
	        while (dividend <= divisor) {
	            tmpd = divisor;
	            k = 1;
	            while (dividend <= tmpd + tmpd && tmpd + tmpd < 0) {
	                tmpd += tmpd;
	                k += k;
	            }
	            s = s + k;
	            dividend -= tmpd;
	        }
	        return flag > 0 ? s : -s;
	}
}
