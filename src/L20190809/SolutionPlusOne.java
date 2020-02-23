package L20190809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionPlusOne {
	public int[] plusOne(int[] digits) {
		int jinwei = 0;
		digits[digits.length-1]++;
		for(int i=digits.length-1;i>0;i--) {
			digits[i]=digits[i]+jinwei;
			if(digits[i]>9) {
				digits[i-1]++;
				digits[i]=digits[i]%10;
			}
			else return digits;
		}
        if(digits[0]<10) return digits;
        else {
        	List<Integer> ar = new ArrayList<Integer>();
        	for(int i=0;i<digits.length;i++) ar.add(digits[i]);
        	ar.add(0,1);
        	ar.set(1, ar.get(1)%10);
        	int[] retun = new int[ar.size()];
        	for(int i=0;i<ar.size();i++) retun[i]=ar.get(i);
        	return retun;
        }
    }
}
