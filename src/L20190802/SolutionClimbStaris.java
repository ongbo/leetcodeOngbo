package L20190802;
/*������������¥�ݡ���Ҫ n ������ܵ���¥����

ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�

ע�⣺���� n ��һ����������
 * 
 * */
public class SolutionClimbStaris {
	public static void main(String[] args) {
		System.out.println(climbStairs(10));
	}
	public static int climbStairs(int n) {
	    if(n==1) return 1;
	    if(n==2) return 2;
	    int c1=1,c2=2;
		int m=0;
		for(int i=3;i<=n;i++) {
			m=c1+c2;
			c1=c2;
			c2=m;
		}
		return m;
    }
}
