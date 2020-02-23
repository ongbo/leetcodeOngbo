package L20190729;
/*
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。

在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
abcde 	
fghij
klmno
pqrst
uvwxy
z
我们可以按下面的指令规则行动：

如果方格存在，'U' 意味着将我们的位置上移一行；
如果方格存在，'D' 意味着将我们的位置下移一行；
如果方格存在，'L' 意味着将我们的位置左移一列；
如果方格存在，'R' 意味着将我们的位置右移一列；
'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * */
public class Competition2 {
	public static void main(String[] args) {
		System.out.println(alphabetBoardPath("zz"));
	}
public static String alphabetBoardPath(String target) {
		int hangstart=0;
		int liestart = 0;
		StringBuilder builder = new StringBuilder();
        for(int i=0;i<target.length();i++) {
        	int hang=0,lie=0,falg=0;
        	
        	if(target.charAt(i)!='z') {
        		hang = (target.charAt(i)-'a')/5;
        		lie = (target.charAt(i)-'a')%5;
        	}else {
        		if(i>0&&target.charAt(i-1)=='z') {
        			hang = 5;
            		lie = 0;
            		falg=1;
        		}else {
        		hang = 4;lie=0;}
        	}
        	if(hang>hangstart) for(int j=0;j<hang-hangstart;j++) builder.append("D");
        	else for(int j=0;j<hangstart-hang;j++) builder.append("U");
        	if(lie>liestart) for(int j=0;j<lie-liestart;j++) builder.append("R");
        	else for(int j=0;j<liestart-lie;j++) builder.append("L");
        	if(target.charAt(i)=='z'&&falg==0) {builder.append("D");hang++;}
        	builder.append("!");
        	hangstart=hang;
        	liestart=lie;
        }
        return builder.toString();
    }
}
