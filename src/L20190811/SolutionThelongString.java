package L20190811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * ����ַ����е������ַ�����ͬ����ô����ַ����ǵ��ַ��ظ����ַ�����

����һ���ַ��� text����ֻ�ܽ������������ַ�һ�λ���ʲô��������Ȼ��õ�һЩ���ַ��ظ����Ӵ���������������Ӵ��ĳ��ȡ�

 

ʾ�� 1��

���룺text = "ababa"
�����3
ʾ�� 2��

���룺text = "aaabaaa"
�����6
ʾ�� 3��

���룺text = "aaabbaaa"
�����4
 * */
public class SolutionThelongString {
	public static void main(String[] args) {
		SolutionThelongString t = new SolutionThelongString();
		System.out.println(t.maxRepOpt1("aaabbaaa"));
	}
	 public int maxRepOpt1(String text) {
	    HashMap<Integer, String> reHashMap = new HashMap<Integer, String>();
	    List<Integer> reIntegers = new ArrayList<Integer>();
	    int maxlength=0;
	    int i=0;
	    while(i<text.length()) {
	    	int j=i+1;
	    	while(j<text.length()&&text.charAt(j)==text.charAt(i)) j++;
	    	 reHashMap.put(i, text.substring(i, j));
	    	if(reIntegers.size()>1) {
	    		if(reHashMap.get(reIntegers.get(reIntegers.size()-2)).charAt(0)==reHashMap.get(i).charAt(0)&&reHashMap.get(reIntegers.get(reIntegers.size()-1)).length()<=1) {//
	    			int len = reHashMap.get(reIntegers.get(reIntegers.size()-2)).length()+reHashMap.get(i).length();
	    			if(len>maxlength) maxlength=len;
	    		}
	    		for(int t=0;t<reIntegers.size()-1;t++) {
    				if(reHashMap.get(reIntegers.get(t)).charAt(0)==reHashMap.get(i).charAt(0)) {
    					if(t+2<reIntegers.size()&&reHashMap.get(reIntegers.get(t+2)).charAt(0)==reHashMap.get(i).charAt(0)) {
    						if(reHashMap.get(reIntegers.get(t+1)).length()<=1) {
    							int len = reHashMap.get(reIntegers.get(t+2)).length()+reHashMap.get(reIntegers.get(t)).length()+1;
    							if(len>maxlength) maxlength=len;
    						}
    					}else {
    						if(reHashMap.get(reIntegers.get(t)).length()>reHashMap.get(i).length()) {
    							if(reHashMap.get(reIntegers.get(t)).length()>maxlength-1) maxlength=reHashMap.get(reIntegers.get(t)).length(); 
    						} else if(reHashMap.get(i).length()+1>maxlength) maxlength=reHashMap.get(i).length()+1;
    					}
    				}
    			}
	    		
	    	}
	    	reIntegers.add(i);
	    	i=j;
	    }
	    if(maxlength==0) {
	    	for(int p=0;p<reIntegers.size();p++) {
	    		if(reHashMap.get(reIntegers.get(p)).length()>maxlength) maxlength=reHashMap.get(reIntegers.get(p)).length();
	    	}
	    }
	    return maxlength;
	 }
	
}
