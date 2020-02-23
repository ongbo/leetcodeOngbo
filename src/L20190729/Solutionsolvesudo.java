package L20190729;
/*
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class Solutionsolvesudo {
	public static void main(String[] args) {
		
	}
		  // box size
		  int n = 3;
		  // row size
		  int N = n * n;

		  int [][] rows = new int[N][N + 1];//哪一行使用过哪些数字
		  int [][] columns = new int[N][N + 1];//哪一列使用过na'xie'shu'zi
		  int [][] boxes = new int[N][N + 1];//哪些格子使用过哪些格子

		  char[][] board;

		  boolean sudokuSolved = false;

		  public boolean couldPlace(int d, int row, int col) {
		    /*
		    Check if one could place a number d in (row, col) cell
		    */
		    int idx = (row / n ) * n + col / n;
		    return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
		  }

		  public void placeNumber(int d, int row, int col) {
		    /*
		    Place a number d in (row, col) cell
		    */
		    int idx = (row / n ) * n + col / n;

		    rows[row][d]++;
		    columns[col][d]++;
		    boxes[idx][d]++;
		    board[row][col] = (char)(d + '0');
		  }

		  public void removeNumber(int d, int row, int col) {
		    /*
		    Remove a number which didn't lead to a solution
		    */
		    int idx = (row / n ) * n + col / n;
		    rows[row][d]--;
		    columns[col][d]--;
		    boxes[idx][d]--;
		    board[row][col] = '.';
		  }

		  public void placeNextNumbers(int row, int col) {
		    /*
		    Call backtrack function in recursion
		    to continue to place numbers
		    till the moment we have a solution
		    */
		    // if we're in the last cell
		    // that means we have the solution
		    if ((col == N - 1) && (row == N - 1)) {
		      sudokuSolved = true;
		    }
		    // if not yet
		    else {
		      // if we're in the end of the row
		      // go to the next row
		      if (col == N - 1) backtrack(row + 1, 0);
		        // go to the next column
		      else backtrack(row, col + 1);
		    }
		  }

		  public void backtrack(int row, int col) {
		    /*
		    Backtracking
		    */
		    // if the cell is empty
		    if (board[row][col] == '.') {
		      // iterate over all numbers from 1 to 9
		      for (int d = 1; d < 10; d++) {
		        if (couldPlace(d, row, col)) {
		          placeNumber(d, row, col);
		          placeNextNumbers(row, col);
		          // if sudoku is solved, there is no need to backtrack
		          // since the single unique solution is promised
		          if (!sudokuSolved) removeNumber(d, row, col);
		        }
		      }
		    }
		    else placeNextNumbers(row, col);
		  }

		  public void solveSudoku(char[][] board) {
		    this.board = board;

		    // init rows, columns and boxes
		    for (int i = 0; i < N; i++) {
		      for (int j = 0; j < N; j++) {
		        char num = board[i][j];
		        if (num != '.') {
		          int d = Character.getNumericValue(num);
		          placeNumber(d, i, j);
		        }
		      }
		    }
		    backtrack(0, 0);
		  }

		
//public void solveSudoku(char[][] board) {
//		for(int i=0;i<board.length;i++) {
//			for(int j=0;j<board[0].length;j++) if(board[i][j]=='.') {
//				backtrace(board, i, j);
//				return;
//			}
//	}
//    }
//	public static void backtrace(char[][] board,int x,int y) {//接下来构造x，y这个点了
//		for(int i=0;i<9;i++) {
//			char t = (char) (i+'0');
//			if(Judge(board, x, y, t)) {
//				board[x][y]=t;
//				//找到下一个为空的节点
//				int flag=0,p=x,px=y;
//				for(p=x;p<board.length;p++) {
//					for (px=y;px<board[0].length;px++) {
//						if(!(p==x&&px==y)&&board[x][y]=='.')
//						{flag =1; break;}
//					}
//					if(flag==1) break;
//				}
//				//回溯p，px这个点，因为这个点是空的
//				if(flag==1) backtrace(board, p, px);//还有可以回溯的点
//				else {//没有可以回溯构造的点了
//					for(int ii=0;ii<board.length;ii++) {
//						for(int j=0;j<board.length;j++) System.out.print(board[i][j]);
//						System.out.println();
//					}
//				}
//			}
//		}
//		board[x][y]='.';
//		
//	}
//	public static boolean Judge(char[][] board,int x,int y,char c) {//判断某个点行不行的通
//		//先判断行
//		for(int i=0;i<board[x].length;i++) {
//			if(c==board[x][i]&&i!=y) return false;
//		}
//		//判断列
//		for(int i=0;i<board.length;i++) {
//			if(board[i][y]==c&&i!=x) return false;
//		}
//		//判断格子
//		int hang = x/3*3;
//		int lie = y/3*3;
//		for(;hang<x/3*3+3;hang++) {//判断这个点和格子内其他点即可
//			lie=y/3*3;
//			while(lie<y/3*3+3) {
//				if(!(x==hang&&y==lie)&&board[x][y]==board[hang][lie]) lie++;
//				else {return false;}
//			}
//		}
//		return true;
//	}
}
