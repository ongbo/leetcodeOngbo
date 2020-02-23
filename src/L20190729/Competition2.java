package L20190729;
/*
 * ���Ǵ�һ����ĸ���ϵ�λ�� (0, 0) �������������Ӧ���ַ�Ϊ board[0][0]��

�ڱ������ĸ��Ϊboard = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
abcde 	
fghij
klmno
pqrst
uvwxy
z
���ǿ��԰������ָ������ж���

���������ڣ�'U' ��ζ�Ž����ǵ�λ������һ�У�
���������ڣ�'D' ��ζ�Ž����ǵ�λ������һ�У�
���������ڣ�'L' ��ζ�Ž����ǵ�λ������һ�У�
���������ڣ�'R' ��ζ�Ž����ǵ�λ������һ�У�
'!' ��������ǵ�ǰλ�� (r, c) ���ַ� board[r][c] ��ӵ����С�
����ָ�����У�����С���ж������ô𰸺�Ŀ�� target ��ͬ������Է����κδ��Ŀ���·����
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
