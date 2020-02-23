package L20190801;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:

����: ["eat", "tea", "tan", "ate", "nat", "bat"],
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/group-anagrams
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

 * 
 * */
public class SolutionGroupAndgrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

        
    }

}
