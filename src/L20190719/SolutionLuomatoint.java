package L20190719;

import java.util.HashMap;
import java.util.Map;

public class SolutionLuomatoint {
	public static void main(String[] args) {
		SolutionLuomatoint aLuomatoint = new SolutionLuomatoint();
		System.out.print(aLuomatoint.romanToInt("IV"));
	}
	  public int romanToInt(String s) {
	        Map<String, Integer> map = new HashMap<>();
	        map.put("I", 1);
	        map.put("IV", 4);
	        map.put("V", 5);
	        map.put("IX", 9);
	        map.put("X", 10);
	        map.put("XL", 40);
	        map.put("L", 50);
	        map.put("XC", 90);
	        map.put("C", 100);
	        map.put("CD", 400);
	        map.put("D", 500);
	        map.put("CM", 900);
	        map.put("M", 1000);
	        
	        int ans = 0;
	        for(int i = 0;i < s.length();) {
	            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
	                ans += map.get(s.substring(i, i+2));
	                i += 2;
	            } else {
	                ans += map.get(s.substring(i, i+1));
	                i ++;
	            }
	        }
	        return ans;

//			HashMap<String, Integer> pHashMap = new HashMap<String, Integer>();
//			pHashMap.put("I", 1);
//			pHashMap.put("IV", 4);
//			pHashMap.put("V", 5);
//			pHashMap.put("IX", 9);
//			pHashMap.put("X", 10);
//			pHashMap.put("XL", 40);
//			pHashMap.put("L", 50);
//			pHashMap.put("XC", 90);
//			pHashMap.put("C", 100);
//			pHashMap.put("CD", 400);
//			pHashMap.put("D", 500);
//			pHashMap.put("CM", 900);
//			pHashMap.put("M", 1000);
//			int x=0;
//			for(int i=0;i<s.length();i++) {
//				String tString ="";
//				char p = s.charAt(i);
//				switch (p) {
//				case 'I':
//					
//					if((i<s.length()-1)&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')) {tString=s.substring(i,i+2);i++;}
//					else tString = s.substring(i,i+1);
//					break;
//				case 'X':
//					if((i<s.length()-1)&&(s.charAt(i+1)=='C'||s.charAt(i+1)=='L')) {tString=s.substring(i,i+2);i++;}
//					else tString = s.substring(i,i+1);
//					break;
//				case 'C':
//					if((i<s.length()-1)&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')) {tString=s.substring(i,i+2);i++;}
//					else tString = s.substring(i,i+1);
//					break;
//				default:
//					tString = s.substring(i,i+1);
//					break;
//				}
//			
//				x=x+pHashMap.get(tString);
//			}
//			return x;
	   }
}
