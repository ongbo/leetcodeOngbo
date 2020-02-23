package L20190729;

/*
 * ̩���������� Tn �������£� 

T0 = 0, T1 = 1, T2 = 1, ���� n >= 0 �������� Tn+3 = Tn + Tn+1 + Tn+2

�������� n���뷵�ص� n ��̩�������� Tn ��ֵ��

 
0 1 1 2 4 7 13
ʾ�� 1��

���룺n = 4
�����4
���ͣ�
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
 * */
public class Competition01 {
	public static void main(String[] args) {
		System.out.println(tribonacci(3));
	}
	  public  static int tribonacci(int n) {
		  int t0=0,t1=1,t2=1;
		  if(n==0) return t0;
		  if(n==1) return t1;
		  if(n==2)  return t2;
		  int retunum = 0;
		  for(int i=0;i<n-2;i++) {
			  retunum=t0+t1+t2;
			  t0=t1;
			  t1=t2;
			  t2=retunum;
		  }
		  return retunum;
	  }
}
