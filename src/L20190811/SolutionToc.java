package L20190811;

import java.util.ArrayList;
import java.util.List;

/*
 * ������ d ��һ�������ӣ�ÿ�������϶��� f ���棬�ֱ���Ϊ 1, 2, ..., f��

����Լ���������ӵĵõ��ܵ���Ϊ�������泯�ϵ����ֵ��ܺ͡�

�����Ҫ�������ܵ���Ϊ target�����������ж����ֲ�ͬ�������������е��������ܹ��� f^d �֣���ģ 10^9 + 7 �󷵻ء�


ʾ�� 1��
6 6 2
6 5 3
6 4 4
5 5 4

2 6 6
1+2+3+4++5
���룺d = 1, f = 6, target = 3
�����1
 * */
public class SolutionToc {
	public int numRollsToTarget(int d, int f, int target) {
       //�м������Ӿ��м����ظ����
		int retuin = 0;
		if(target<=d*f) {
			List<Integer> ar = new ArrayList<Integer>();
			while(target>d) {ar.add(d); target=target-d;}
			
		}
		return retuin;
    }
}
