package L20190802;
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 * 
 * */
public class SolutionClimbStaris {
	public static void main(String[] args) {
		System.out.println(climbStairs(10));
	}
	public static int climbStairs(int n) {
	    if(n==1) return 1;
	    if(n==2) return 2;
	    int c1=1,c2=2;
		int m=0;
		for(int i=3;i<=n;i++) {
			m=c1+c2;
			c1=c2;
			c2=m;
		}
		return m;
    }
}
