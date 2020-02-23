package L20190729;

import java.util.HashMap;
import java.util.Map;

import javax.swing.border.Border;

/*
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionisValidSudoku {
	public static void main(String[] args) {
		
	}
	 public boolean isValidSudoku(char[][] board) {
		 //先一行行验证
		 for(int i=0;i<board.length;i++) {//模拟每一行
			 Map<Character, Integer> map = new HashMap<Character, Integer>();
			 for(int j=0;j<board[i].length;j++) {
				 if(board[i][j]!='.') {
					 if(map.containsKey(board[i][j])) return false;
					 else map.put(board[i][j], 1);
				 }
			 }
		 }
		 //一列列验证
		 for(int i=0;i<board[0].length;i++) {//模拟某一列
			 Map<Character, Integer> map = new HashMap<Character, Integer>();
			 for(int j=0;j<board.length;j++) {//模拟某一行
				 if(board[j][i]!='.') {
					 if(map.containsKey(board[j][i])) return false;
					 else map.put(board[j][i], 1);
				 }
			 }
		 }
		 //某个三角形验证
		 //
		 for(int i=0;i<9;i++) {//模拟每个3*3区域
			 Map<Character, Integer> map = new HashMap<Character, Integer>();
			 int hang = i/3*3;//起始行
			 int lie = i%3*3;//起始列
			 while(hang<i/3*3+3&&lie<i*3+3) {
				 
				 if(board[hang][lie]!='.') if(map.containsKey(board[hang][lie])) return false; else map.put(board[hang][lie], 1);
				 lie++;
				 if(lie>=i%3*3+3) {lie=i%3*3;hang++;}
			 }
		 }
		 
		 return true;
	 }
}
