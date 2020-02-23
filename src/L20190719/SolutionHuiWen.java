package L20190719;
/*
 *�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * */
public class SolutionHuiWen {
	public static void main(String[] args) {
		SolutionHuiWen solutionHuiWen = new SolutionHuiWen();
		System.out.println(solutionHuiWen.isPalindrome(-121));
	}   
	public boolean isPalindrome(int x) {
		String string = String.valueOf(x);
		for(int i = 0;i<string.length()/2;i++) {
			if(string.charAt(i)!=string.charAt(string.length()-i-1)) return false;
		}
		return true;
	}
	//��תһ������
	public boolean isPalidrom2(int x) {
		  // ���������
        // ������������ x < 0 ʱ��x ���ǻ�������
        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
        // �����һλ����ҲӦ���� 0
        // ֻ�� 0 ������һ����
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
        return x == revertedNumber || x == revertedNumber/10;

	}
}
