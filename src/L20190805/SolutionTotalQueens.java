package L20190805;

import java.util.ArrayList;
import java.util.List;

public class SolutionTotalQueens {
	int x = 0;
	public int solveNQueens(int n) {
        int[] queens = new int[n];
      	for(int j=0;j<queens.length;j++) queens[j]=-1;
      	backTrace(queens, 0);
      	return x;
        
    }
	public void backTrace(int[] queens,int n) {
		if(n>0) {
			int hang =	n-1,lie = queens[n-1];
			for(int i=0;i<n-1;i++) {
				if(queens[i]-lie==0||Math.abs(hang-i)==Math.abs(lie-queens[i])) return;
			}
		}
		if(n==queens.length) {
			x++;
			return;
		}
		for(int i=0;i<queens.length;i++) {
			queens[n]=i;
			backTrace(queens, n+1);
			queens[n]=-1;
		}
	}
}
