package TOP100;

/**
 * @author 13081
 *给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_of_Islands {
	 public int numIslands(char[][] grid) {
		 if(grid==null||grid.length==0) return 0;
		 int nums = 0;
		 for(int i=0;i<grid.length;i++) {
			 for(int j=0;j<grid[0].length;j++) {
				 if(grid[i][j]=='1') {
					 Island(grid, i, j);
					 nums++;
				 }
			 }
		 }
		 return nums;
	 }
	 public void Island(char[][] grid,int i,int j) {
		 if(grid[i][j]=='1') {
			 grid[i][j]='0';//将它置为0，并且看它的四周有没有1
			 if(i<grid.length-1) {
				 Island(grid, i+1, j);
			 }
			 if(j<grid[0].length-1) {
				 Island(grid, i, j+1);
			 }
			 if(i>0) {
				 Island(grid, i-1, j);
			 }
			 if(j>0) {
				 Island(grid, i, j-1);
			 }
		 } 
	 }
}
