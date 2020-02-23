package L20190805;

import java.util.ArrayList;
import java.util.List;
public class SolutionsolveNQueens {
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> retuList = new ArrayList<List<String>>();
        int[] queens = new int[n];
      	for(int j=0;j<queens.length;j++) queens[j]=-1;
      	backTrace(queens, 0, retuList);
      	return retuList;
        
    }
	public void backTrace(int[] queens,int n,List<List<String>> retuList) {
		if(n>0) {
			int hang =	n-1,lie = queens[n-1];
			for(int i=0;i<n-1;i++) {
				if(queens[i]-lie==0||Math.abs(hang-i)==Math.abs(lie-queens[i])) return;
			}
		}
		if(n==queens.length) {
			List<String> aList2 = new ArrayList<String>();
			for(int i=0;i<queens.length;i++) {
				StringBuilder stringBuilder = new StringBuilder();
				for(int j=0;j<queens[i];j++) stringBuilder.append(".");
				stringBuilder.append("Q");
				for(int j=queens[i]+1;j<queens.length;j++) stringBuilder.append(".");
				aList2.add(stringBuilder.toString());
			}
			retuList.add(aList2);
			return;
		}
		for(int i=0;i<queens.length;i++) {
			queens[n]=i;
			backTrace(queens, n+1, retuList);
			queens[n]=-1;
		}
	}
}
