package ByteDance;

import TOP100.Min_Stack;

/*
 * 
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。

注意：1 ≤ k ≤ n ≤ 109。

示例 :

输入:
n: 13   k: 2

输出:
10

解释:
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class p5 {
	public static void main(String[] args) {
		p5 p5 = new p5();
		System.out.println(p5.findKthNumber(681692778,
				351251360));
	}
	public int findKthNumber(int n, int k) {
		int p=1;//标志当前按照字典序列的第几小的，标准是k
		int pre = 1;//字典前缀
		while(p<k) {//当还没有达到第k小的时候
			long count = getcount(n, pre);
			System.out.println(pre+":"+count);
			if(p+count>k) {//说明第k小的数在这个点的子树上，那么*10进入它的子树
				pre = pre*10;//*10进入子树
				p++;//因为上一前缀也代表一个数，所以进入子树后虽然加了一个数字，但是加之前也是一种前缀
			}else if(p+count<=k) {//如果没在子树，说明在更高的序列中比如没有在10的子树，就要去11，12的子树找
				pre++;//前缀+1
				p+=count;
			}
		}
		return pre;
	}
	public long getcount(long n,long pre) {
		//算出每一个子树的个数
		 long cnt = 0;
		 for(long i=pre,j=pre+1;i<=n;i*=10,j*=10) {
			 cnt = cnt + Math.min(n+1,j) - i;
		 }
		 return cnt;
	}

}
