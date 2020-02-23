package L20190802;
/*
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

���ܹ��ж�������ͬ��·����

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/unique-paths
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class SolutionUniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 2));
	}
    public static int uniquePaths(int m, int n) {
        int[][] a = new int[m+1][n+1];
        for(int i=0;i<m;i++) a[i][0]=1;
        for(int i=0;i<n;i++) a[0][i]=1;
        for(int i=1;i<m+1;i++) {
        	for(int j=1;j<n+1;j++) {
        		a[i][j]=a[i-1][j]+a[i][j-1];
        	}
        }
        return a[m-1][n-1];
        
    }
}
