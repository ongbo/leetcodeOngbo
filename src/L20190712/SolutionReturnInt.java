package L20190712;
/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 */
public class SolutionReturnInt {
	public static void main(String[] args) {
		System.out.print(reverse(1234567899));
	}
	//-2147483648~~~~2147483647
	  public static int reverse(int x) {
		  int rever = 0;
		  while(x!=0){
			  if(rever!=rever*10/10) {
				  return 0;
			  }
			  rever = rever*10+x%10;
			  
			  x=x/10;
			  
		  }
		  return rever;
	  }
}
