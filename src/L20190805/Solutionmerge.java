package L20190805;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.CORBA.OMGVMCID;

/*
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solutionmerge {
	 public static void main(String[] args) {
			int[][] nums = {{1,2},{5,7},{2,8},{1,9}};
			Solutionmerge solutionmerge = new Solutionmerge();
			int[][] a = solutionmerge.merge(nums);
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[i].length;j++) System.out.print(a[i][j]+"---");
				System.out.println();
			}
		 }
		 public int[][] merge(int[][] intervals) {
			 
			 int[] a = new int[intervals.length];
			 List<int[]> retuList = sort(intervals);
			 retuList = new ArrayList(retuList);
			 for(int i=0;i<retuList.size()-1;i++){
				 if(retuList.get(i)[1]>=retuList.get(i+1)[0]) {
					 if(retuList.get(i)[1]<=retuList.get(i+1)[1]) {
						 retuList.get(i+1)[0]=retuList.get(i)[0];
					 }else {
						 retuList.get(i+1)[0]=retuList.get(i)[0];
						 retuList.get(i+1)[1]=retuList.get(i)[1];
					 }
					 retuList.remove(retuList.get(i));
					 i--;
				 }
			 }
			 int[][] retu = new int[retuList.size()][];
			 for(int i =0;i<retuList.size();i++) retu[i]=retuList.get(i);
			 return retu;
	 }
		
		 public List<int[]> sort(int[][] nums) {
			 List<int[]> aList = new ArrayList<int[]>();
			 aList = Arrays.asList(nums);
			 Collections.sort(aList, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0]-o2[0];
				}
			});
			return aList;
		 }
}
