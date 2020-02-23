package ByteDance;

import java.util.Arrays;

/*
 * 351. 安卓系统手势解锁
我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。

给你两个整数，分别为 ​​m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。

 

先来了解下什么是一个有效的安卓解锁手势:

每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
解锁手势里不能设置经过重复的点。
假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
经过点的顺序不同则表示为不同的解锁手势。
 


 

解释:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
无效手势：4 - 1 - 3 - 6
连接点 1 和点 3 时经过了未被连接过的 2 号点。

无效手势：4 - 1 - 9 - 2
连接点 1 和点 9 时经过了未被连接过的 5 号点。

有效手势：2 - 4 - 1 - 3 - 6
连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。

有效手势：6 - 5 - 4 - 1 - 9 - 2
连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。

 

示例:

输入: m = 1，n = 1
输出: 9
 * */
public class p10 {
	int nums;
	public static void main(String[] args) {
		p10 p10 = new p10();
		p10.numberOfPatterns(1, 2);
	}
	public int numberOfPatterns(int m, int n) {
		int[][] num = new int[3][3];
		Arrays.fill(num[0], 0);
		Arrays.fill(num[1], 0);
		Arrays.fill(num[2], 0);
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[0].length;j++) {
				num[i][j]=1;
				number(m, n, num, i, j, 1);
				num[i][j]=0;
			}
		}
		
		System.out.println(nums);
		return nums;
    }
	public void number(int m,int n,int[][] num,int lasti,int lastj,int currentnums) {
		if(currentnums>n) return;
		if(currentnums>=m) nums++;
		if(currentnums==n) return;
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[0].length;j++) {
				if(num[i][j]==0) {
					if((i-lasti)==0) {
						//在同一行
						if(Math.abs(lastj-j)>1&&num[i][1]==0) {
							//同一行的节点中间为0，则不行，也就是不能暂时不能经过这一点
							continue;
						}else {
							//那么可以经过i，j这个点
							num[i][j]=1;currentnums++;
							number(m, n, num, i, j, currentnums);
							num[i][j]=0;currentnums--;
						}
					}else if((j-lastj)==0) {
						//在同一列
						if((Math.abs(lasti-i)>1)&&num[1][j]==0) {
							continue;
						}else {
							num[i][j]=1;currentnums++;
							number(m, n, num, i, j, currentnums);
							num[i][j]=0;currentnums--;
						}						
					}else if(Math.abs(i-lasti)==Math.abs(j-lastj)) {
						//在同一斜列
						if((Math.abs(i-lasti)>1)&&num[1][1]==0)continue;
						else {
							num[i][j]=1;currentnums++;
							number(m, n, num, i, j, currentnums);
							num[i][j]=0;currentnums--;
						}
					}else {
						num[i][j]=1;currentnums++;
						number(m, n, num, i, j, currentnums);
						num[i][j]=0;currentnums--;
				}
			}
		}
	}
	}
}