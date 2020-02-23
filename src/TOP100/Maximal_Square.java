package TOP100;

/**
 * @author 13081
 *在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

101101
111211
012012
112010
012111
110122

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Maximal_Square {
	public static void main(String[] args) {
		char[][] a = {{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
		Maximal_Square tMaximal_Square = new Maximal_Square();
		System.out.println(tMaximal_Square.maximalSquare(a));
	}
	public int maximalSquare(char[][] matrix) {
		int max = 0;
       for(int i=0;i<matrix.length;i++) {
    	   for(int j=0;j<matrix[0].length;j++) {
    		   if(i>0&&j>0&&matrix[i][j]!='0') {
    			   matrix[i][j]=(char) (matrix[i][j]+Integer.min(Integer.min(matrix[i-1][j]-'0', matrix[i][j-1]-'0'),matrix[i-1][j-1]-'0'));
    			   
    		   }
    		   if(matrix[i][j]-'0'>max) {max = matrix[i][j] - '0';}
    	   }
       } 
       
       return max*max;
    }
}
