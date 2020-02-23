package ByteDance;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * 一个强密码应满足以下所有条件：

由至少6个，至多20个字符组成。
至少包含一个小写字母，一个大写字母，和一个数字。
同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。

插入、删除、替换任一字符都算作一次修改。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/strong-password-checker
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class p8 {
	public static void main(String[] args) {
		strongPasswordChecker("aaa123");
	}
	 Queue<Integer>que;
	    public int strongPasswordChecker(String s) {
	        int len = s.length();
	        if (len == 0) return 6;
	        int need1 = 1;
	        int need2 = 1;
	        int need3 = 1;
	        que = new PriorityQueue<Integer>((a, b) -> a % 3 - b % 3);
	        int cnt = 1;
	        if (Character.isLowerCase(s.charAt(0))) need1 = 0;
	        if (Character.isUpperCase(s.charAt(0))) need2 = 0;
	        if (Character.isDigit(s.charAt(0))) need3 = 0;
	        for (int i = 1; i < len; ++i) {
	            if (Character.isLowerCase(s.charAt(i))) need1 = 0;
	            if (Character.isUpperCase(s.charAt(i))) need2 = 0;
	            if (Character.isDigit(s.charAt(i))) need3 = 0;
	            if (s.charAt(i) != s.charAt(i - 1)) {
	                if (cnt >= 3)
	                    que.add(cnt);
	                cnt = 1;
	            } else {
	                ++cnt;
	            }
	        }
	        if (cnt >= 3)
	            que.add(cnt);
	        int need = need1 + need2 + need3;
	        int ans = 0;
	        if (len < 6) {
	            if (len == 5) {
	                if (need >= 2 || cnt == 5) return need;
	                return 1;
	            } else {
	                return 6 - len;
	            }
	        }
	        while (!que.isEmpty() && len > 20) {
	            int now = que.poll();
	            ++ans;--len;
	            if (--now >= 3) que.add(now); 
	        }
	        if (len > 20) ans += len - 20 + Math.max(0, need);
	        else {
	            int cunt = 0;
	            while (!que.isEmpty()) {
	                int now = que.poll();
	                cunt += now / 3;
	            }
	            ans += Math.max(cunt, need);
	        }
	        return ans;
	    }
}
