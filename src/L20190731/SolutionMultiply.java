package L20190731;

import java.util.ArrayList;

import javax.activation.MailcapCommandMap;

/*
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionMultiply {
	public static void main(String[] args) {
		System.out.println(multiply("140", "721"));
	}
	public static String multiply(String num1, String num2) {
//        123
//        456
//        123*6
//        123*5+"0"
//        123*1+"00"
		if(num1.equals("0")||num2.equals("0")) return "0";
			if(num1.length()<num2.length()) {
				String tString= num1;
				num1=num2;
				num2=tString;
			}
		ArrayList<String> arrayList = new ArrayList<String>();
		int pre=0;
		for (int i=num2.length()-1;i>=0;i--) {
			pre=0;
			StringBuilder aBuilder = new StringBuilder();
			for(int j=0;j<num2.length()-1-i;j++) aBuilder.append(0);
			for(int j=num1.length()-1;j>=0;j--) {
				int a = pre+(num1.charAt(j)-'0')*(num2.charAt(i)-'0');
				if(a<10) {aBuilder.append(a);pre=0;}
				else {
					pre=a/10;
					aBuilder.append(a%10);
				}
			}
			if(pre!=0) aBuilder.append(pre);
			arrayList.add(aBuilder.toString());
		}
		for(int i=0;i<arrayList.size();i++) System.out.println(arrayList.get(i));
		pre=0;
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<arrayList.get(arrayList.size()-1).length();i++) {
			int num=pre;
			for(int j=0;j<arrayList.size();j++) if(i<arrayList.get(j).length()) num=num+arrayList.get(j).charAt(i)-'0';
			if(num<10) {
				builder.insert(0, num);
				pre=0;
			}else {
				pre=num/10;
				builder.insert(0, num%10);
				
			}
		}
		if(pre!=0) builder.insert(0, pre);
		return builder.toString();
    }
}
