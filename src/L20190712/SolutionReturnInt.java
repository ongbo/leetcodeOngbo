package L20190712;
/*
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��

ʾ�� 1:

����: 123
���: 321
 */
public class SolutionReturnInt {
	public static void main(String[] args) {
		System.out.print(reverse(1234567899));
	}
	//-2147483648~~~~2147483647
	  public static int reverse(int x) {
		  int rever = 0;
		  while(x!=0){
			  if(rever!=rever*10/10) {
				  return 0;
			  }
			  rever = rever*10+x%10;
			  
			  x=x/10;
			  
		  }
		  return rever;
	  }
}
