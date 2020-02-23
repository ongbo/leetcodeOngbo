package L20190811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。

给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。

 

示例 1：

输入：text = "ababa"
输出：3
示例 2：

输入：text = "aaabaaa"
输出：6
示例 3：

输入：text = "aaabbaaa"
输出：4
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
