package L20190731;
/*
 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
 * 
 * */
import java.util.Arrays;

public class SolutionFirstMissingpositive {
	public int firstMissingPositive(int[] nums) {
//		Arrays.sort(nums);
//		if(nums[0]>1||nums[nums.length-1]<0) return 1;
//		for(int i=0;i<nums.length;i++) {
//			if(nums[i]>1) {
//				if(nums[i-1]<=0) return 1;
//				if(nums[i-1]<nums[i]-1) return nums[i-1]+1;
//			}
//		}
//		return nums[nums.length-1]+1;
	      int n = nums.length;

	      // �������
	      int contains = 0;
	      for (int i = 0; i < n; i++)
	        if (nums[i] == 1) {
	          contains++;
	          break;
	        }

	      if (contains == 0)
	        return 1;

	      // nums = [1]
	      if (n == 1)
	        return 2;

	      // �� 1 �滻������0��
	      // �ʹ��� n ����
	      // ��ת���Ժ�nums ֻ�����
	      // ����
	      for (int i = 0; i < n; i++)
	        if ((nums[i] <= 0) || (nums[i] > n))
	          nums[i] = 1;

	      // ʹ�����������ַ�����Ϊ�����
	      // ���磬��� nums[1] �Ǹ�����ʾ�������г��������� `1`
	      // ��� nums[2] ������ ��ʾ���� 2 û�г���
	      for (int i = 0; i < n; i++) {
	        int a = Math.abs(nums[i]);
	        // ���������һ������ a - �ı�� a ��Ԫ�صķ���
	        // ע���ظ�Ԫ��ֻ�����һ��
	        if (a == n)
	          nums[0] = - Math.abs(nums[0]);
	        else
	          nums[a] = - Math.abs(nums[a]);
	      }

	      // ���ڵ�һ���������±�
	      // ���ǵ�һ��ȱʧ����
	      for (int i = 1; i < n; i++) {
	        if (nums[i] > 0)
	          return i;
	      }

	      if (nums[0] > 0)
	        return n;

	      return n + 1;

    }
}
