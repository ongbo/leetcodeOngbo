package L20190809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutioninsert {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<int[]>();
        arr = Arrays.asList(intervals);
        int index=-2,index2=-2;
        for(int i=0;i<arr.size();i++) {
        	if(arr.get(i)[0]>newInterval[0]) index=i-1;
        	if(arr.get(i)[1]>=newInterval[1]) index2 = i;
        	
        }
        if(index==-1) {//说明待插入区间起点要比任何起点都要小
        	if(arr.get(index2)[0]>newInterval[1]) {//说明newinterval最大的比arr的index2-1位置的哪个要大，比
        		int[] arrinsert = new int[2];
        		arrinsert[0]=newInterval[0];
        		arrinsert[1]=newInterval[1];
        		arr.add(0, arrinsert);
        		for(int i=index2;i>0;i--) {arr.remove(i);}
        	}else {//说明newinterval[1]>临界的起点，但是要小于等于终点
        		arr.get(index2)[0]=newInterval[0];
        		for(int i=index2-1;i>=0;i--) arr.remove(i);
        	}
        }else if(index>-1) {//说明要比某一个取键起点要大
        	if(arr.get(index)[1]<newInterval[0]) {
        		if(arr.get(index2)[0]>newInterval[1]) {//说明newinterval最大的比arr的index2-1位置的哪个要大，比
            		int[] arrinsert = new int[2];
            		arrinsert[0]=newInterval[0];
            		arrinsert[1]=newInterval[1];
            		arr.add(0, arrinsert);
            		for(int i=index2;i>0;i--) {arr.remove(i);}
            	}else {//说明newinterval[1]>临界的起点，但是要小于等于终点
            		arr.get(index2)[0]=newInterval[0];
            		for(int i=index2-1;i>=0;i--) arr.remove(i);
            		
        	}else {
				
			}
        }
    }
}
