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
        if(index==-1) {//˵���������������Ҫ���κ���㶼ҪС
        	if(arr.get(index2)[0]>newInterval[1]) {//˵��newinterval���ı�arr��index2-1λ�õ��ĸ�Ҫ�󣬱�
        		int[] arrinsert = new int[2];
        		arrinsert[0]=newInterval[0];
        		arrinsert[1]=newInterval[1];
        		arr.add(0, arrinsert);
        		for(int i=index2;i>0;i--) {arr.remove(i);}
        	}else {//˵��newinterval[1]>�ٽ����㣬����ҪС�ڵ����յ�
        		arr.get(index2)[0]=newInterval[0];
        		for(int i=index2-1;i>=0;i--) arr.remove(i);
        	}
        }else if(index>-1) {//˵��Ҫ��ĳһ��ȡ�����Ҫ��
        	if(arr.get(index)[1]<newInterval[0]) {
        		if(arr.get(index2)[0]>newInterval[1]) {//˵��newinterval���ı�arr��index2-1λ�õ��ĸ�Ҫ�󣬱�
            		int[] arrinsert = new int[2];
            		arrinsert[0]=newInterval[0];
            		arrinsert[1]=newInterval[1];
            		arr.add(0, arrinsert);
            		for(int i=index2;i>0;i--) {arr.remove(i);}
            	}else {//˵��newinterval[1]>�ٽ����㣬����ҪС�ڵ����յ�
            		arr.get(index2)[0]=newInterval[0];
            		for(int i=index2-1;i>=0;i--) arr.remove(i);
            		
        	}else {
				
			}
        }
    }
}
