package L20190802;
/*
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/unique-paths-ii
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class SolutionUniquePathsWithObStackles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
        int m=obstacleGrid.length;//������
        int n=obstacleGrid[0].length;//������
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
