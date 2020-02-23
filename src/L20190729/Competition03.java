package L20190729;
/*
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。

 
111   000  000         
101   012  011  
111	  012  020	  



0100111100
0101111101
0100110101
1010111100

示例 1：

输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
输出：9
 * */
public class Competition03 {
	public int largest1BorderedSquare(int[][] grid) {
		int retu = 0;
		for(int i=0;i<grid.length;i++) {//模拟行
			int a=0;
			for(int j=0;j<grid[i].length;j++) {//查找连续的边界
				if(grid[i][j]==1) a++;else {
					//为0了就要以这段1为边界尝试了,这时候j位就不是1了
					int[] num = new int[j-a];   
					for(int k1=j-a;k1<j;k1++) {
						for(int k2=i;k2<grid.length;k2++) {//看每一列有几个连续的1
							if(grid[k2][k1]==1) num[k1-j+1]++;
						}
					}
					//每一列都记录完了，就来检验
					for(int k1=j-a;k1<j;k1++) {
						for(int k2=k1+1;k2<j;k2++) {
							if(k2-k1+1>retu) {
							//先怕暖k1列和k2列
								int t = 0;
								if(num[k1]<num[k2]) t = k1; else t=k2;
								int dihang = i+num[t];
								int flag=0;
								for(int px=k1;px<=k2;px++)if (grid[dihang][px]==0) {flag=1; break;}
								if(flag==0) {
									if(k2-k1+1>retu) retu = k2-k1+1;
								}
								
							}
						}
					}
				}
				
			}
			
		}
		return retu;
    }
}
