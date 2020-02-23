package L20190811;
/*
 * 
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

 

示例 1：

输入：date = "2019-01-09"
输出：9*/
public class SolutionData {
	public static void main(String[] args) {
		SolutionData data = new SolutionData();
		System.out.println(data.ordinalOfDate("2004-03-01"));
	}
	int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	 public int ordinalOfDate(String date) {
		 String[] dateStrings = date.split("-");
		 int year = Integer.parseInt(dateStrings[0]);//年
		 int month = Integer.parseInt(dateStrings[1]);
		 int day = Integer.parseInt(dateStrings[2]);
		 int retudays=0;
		 if(year/400==0||(year%4==0&&year%100!=0)) days[1]++;
		 for(int i=0;i<month-1;i++) retudays = retudays+days[i];
		 retudays = retudays+day;
		 return retudays;
		 
	 }
}
