package L20190725;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 

示例 1：

输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */



/****
 * *
 * @author 13081
 *待优化
 */
public class SolutionFindSubString {
	public static void main(String[] args) {
		String[] wordStrings = new String[] {"word","good","best","word"};
		System.out.println(findSubstring("wordgoodgoodgoodbestword", wordStrings));
	}
	public static List<Integer> findSubstring(String s, String[] words) {
       //
		List<Integer> retuIntegers = new ArrayList<Integer>();
		if(s==null||s.equals("")||words==null||words.length==0) return retuIntegers;
		int wordlength = words[0].length();//单词长度
		Map<String, Integer> allWordsMap = new HashMap<String, Integer>();
		for(int i=0;i<words.length;i++) {
			allWordsMap.put(words[i], allWordsMap.getOrDefault(words[i], 0)+1);
		}
		for(String key:allWordsMap.keySet()) System.out.println(key+"----"+allWordsMap.get(key));
		//模拟位置
		for(int i=0;i<wordlength;i++) {
		
			for(int j=i;j<s.length()-wordlength*words.length+1;j=j+wordlength) {
				System.out.print(j);
				Map<String, Integer> hasWordMap = new HashMap<String, Integer>();
				String string = s.substring(j,j+wordlength*words.length);//一下截取整段
				int num=0;
				System.out.print("&&&"+string+"&&&");
				while(num<words.length) {
					String tString = string.substring(num*wordlength,(num+1)*wordlength);
					hasWordMap.put(tString, hasWordMap.getOrDefault(tString, 0)+1);
					num++;
				}
				int flag = 0;
				for(String key:hasWordMap.keySet()) {
					System.out.print(key+"---"+hasWordMap.get(key)+"@@@@@");
					if(!hasWordMap.get(key).equals(allWordsMap.get(key))) {
						flag = 1;
						break;
					}
				}
				System.out.println();
				if(flag==0) {
					retuIntegers.add(j);
				}
				
			}			
		}
		return retuIntegers;
    }
	
	
}
