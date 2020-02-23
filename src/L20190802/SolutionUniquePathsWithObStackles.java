package L20190802;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionUniquePathsWithObStackles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
        int m=obstacleGrid.length;//多少行
        int n=obstacleGrid[0].length;//多少列
        int[][] a = new int[m][n];
        if(obstacleGrid[0][0]==1) {a[0][0]=0; } else {a[0][0]=1;}
        for(int i=1;i<m;i++)
        	if(obstacleGrid[i][0]==1) {
        		a[i][0]=0;
        		if(i<m-1) obstacleGrid[i+1][0]=1;
        	}else a[i][0]=a[i-1][0];  
        for(int i=1;i<n;i++)
        	if(obstacleGrid[0][i]==1) {
        		a[0][i]=0;
        		if(i<n-1) obstacleGrid[0][i+1]=1;
        	}else a[0][i]=a[0][i-1];
        for(int i=1;i<m;i++) {
        	for(int j=1;j<n;j++) {
        		if(obstacleGrid[i][j]!=1) {
        			a[i][j]=a[i-1][j]+a[i][j-1];
        		}else a[i][j]=0;
        	}
        }
        return a[m-1][n-1];
    }
}
