package L20190811;
/*
 * 
 * ����һ���� YYYY-MM-DD ��ʽ��ʾ���ڵ��ַ��� date��������㲢���ظ������ǵ���ĵڼ��졣

ͨ������£�������Ϊ 1 �� 1 ����ÿ��ĵ� 1 �죬1 �� 2 ����ÿ��ĵ� 2 �죬�������ơ�ÿ���µ����������й�Ԫ���귨�������������һ�¡�

 

ʾ�� 1��

���룺date = "2019-01-09"
�����9*/
public class SolutionData {
	public static void main(String[] args) {
		SolutionData data = new SolutionData();
		System.out.println(data.ordinalOfDate("2004-03-01"));
	}
	int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	 public int ordinalOfDate(String date) {
		 String[] dateStrings = date.split("-");
		 int year = Integer.parseInt(dateStrings[0]);//��
		 int month = Integer.parseInt(dateStrings[1]);
		 int day = Integer.parseInt(dateStrings[2]);
		 int retudays=0;
		 if(year/400==0||(year%4==0&&year%100!=0)) days[1]++;
		 for(int i=0;i<month-1;i++) retudays = retudays+days[i];
		 retudays = retudays+day;
		 return retudays;
		 
	 }
}
