package L20190804Compe148;
/*
 * ����һ���������� nums��ÿ�� ���� �����ѡ��һ��Ԫ�ز� ����Ԫ�ص�ֵ���� 1��

��������������֮һ�������� A ���� ������飺

ÿ��ż��������Ӧ��Ԫ�ض��������ڵ�Ԫ�أ��� A[0] > A[1] < A[2] > A[3] < A[4] > ...
���ߣ�ÿ������������Ӧ��Ԫ�ض�С�����ڵ�Ԫ�أ��� A[0] < A[1] > A[2] < A[3] > A[4] < ...
���ؽ����� nums ת��Ϊ��������������С����������
 * */
public class Competition1 {
	public static void main(String[] args) {
		int[] a = {10,4,4,10,10,6,2,3};
		Competition1 aCompetition1 = new Competition1();
		System.out.println(aCompetition1.movesToMakeZigzag(a));
	}
	public int movesToMakeZigzag(int[] nums) {
		if(nums.length<3) return 0;
		int[] num = new int[nums.length];
		for(int i=0;i<nums.length;i++) num[i]=nums[i];
		int sum1=0;
		for(int i=1;i<nums.length;i=i+2) {
			if(i==nums.length-1) {
				if(nums[i]>nums[i-1]) {
					sum1=sum1+nums[i]-nums[i]+1;
					nums[i]=nums[i-1]-1;
					
				}
			}else if(nums[i]>nums[i+1]||nums[i]>nums[i-1]) {
				if(nums[i-1]<nums[i+1]) {
					sum1=sum1+nums[i]-nums[i-1]+1;
					nums[i]=nums[i-1]-1;
				}else {
					sum1=sum1+nums[i]-nums[i+1]+1;
					nums[i]=nums[i+1]-1;
				}
				i=i-2;
			}
		}
		for(int i=0;i<nums.length;i++) System.out.print(nums[i]+" ");

		int sum2=0;
		for(int i=0;i<num.length;i=i+2) {
			if(i>0&&i<num.length-1) {
				if(num[i]>num[i-1]||num[i]>num[i+1]) {
					if(num[i-1]<num[i+1]) {
						sum2=sum2+num[i]-num[i-1]+1;
						num[i]=num[i-1]-1;
					}else {
						sum2=sum2+num[i]-num[i+1]+1;
						num[i]=num[i+1]-1;
					}
					i=i-2;
				}
			}else if(i==0) {
				if(num[0]>num[1]) {
					sum2=sum2+num[0]-num[1]+1;
					num[0]=num[1]-1;
				}
			}else if(i==num.length-1) {
				if(num[i]>num[i-1]) {
					sum2=sum2+num[i]-num[i-1]+1;
					num[i]=num[i-1]-1;
				}
			}
		}
		System.out.println();
		System.out.println(sum1);
		for(int i=0;i<nums.length;i++) System.out.print(num[i]+" ");
		System.out.println();
		return sum2;
		
		
	}
}
