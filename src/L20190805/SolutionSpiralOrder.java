package L20190805;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
2	3	4
5	6	7
8	9	10
11	12	13
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionSpiralOrder {
	public static void main(String[] args) {
		
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> retuIntegers = new ArrayList<Integer>();
		   if(matrix==null||matrix.length==0) return retuIntegers;
		 
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        int i=0,j=-1;
        
        while(m>0&&n>0) {
        	j++;
        	int t=0;
        	while(t<n) {retuIntegers.add(matrix[i][j]);j++;t++;}
        	if(t==0) break;
        	t=0;
        	j--;i++;
        	while(t<m-1) {retuIntegers.add(matrix[i][j]);i++;t++;}
         	if(t==0) break;
        	t=0;
        	i--;j--;
        	while(t<n-1) {retuIntegers.add(matrix[i][j]);j--;t++;}
         	if(t==0) break;
        	t=0;
        	i--;j++;
        	while(t<m-2) {retuIntegers.add(matrix[i][j]);i--;t++;}
         	if(t==0) break;
        	i++;
        	m=m-2;n=n-2;
        }
     
        return retuIntegers;
      
	}
}
