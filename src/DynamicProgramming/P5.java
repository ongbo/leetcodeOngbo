package DynamicProgramming;

import javax.swing.text.AbstractDocument.LeafElement;

/*
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class P5 {
	public static void main(String[] args) {
		P5 p5 = new P5();
		System.out.println(p5.minDistance("zoologicoarchaeologist","zoogeologist"));
		
	}
	/*
	 * 这里的word1——》word2
	 * 只有三种方式，分别是删除，替换，插入。
	 * 我们把word看成二维矩阵
	 *    i n t e n t i o n
	 *  e 1 2 3 3 
	 *  x 2 2 3 4
	 *  e 3 3 3 3
	 *  c 4 4 4 4
	 *  u 5
	 *  t 6
	 *  i
	 *  o
	 *  n
	 *  每个第i，j代表，横向单词的前i位转换成竖向单词前j位要多少步
	 *  像这样的话，如果对应位置字母先等就不需要增加步数
	 *  而计算一个位置(i,j)可以由(i-1,j)或者(i,j-1)或者(i-1,j-1)位置的来，取决于哪个位置较小
	 *  (i-1,j)-》(i,j)代表最后一步是要删除一个字母
	 *  (i,j-1)->(i,j)代表最后一步是要增加一个单词
	 *  (i-1,j-1)-》(i,j)代表最后是替换一个字符
	 *  拿上面的(2,4)来说即in->exec
	 *  (i-1,j)-》(i,j)即(1,4)->(2,4)：其实是先让i转换成exec，再删除最后一个字母n
	 *  (i,j-1)->(i,j)即(2,3)->(2,4)：其实是先让in转换成exe，最后加一个c
	 *  (i-1,j-1)-》(i,j)即(1,3)->(2,4)：其实是先让i转换成exe，最后将n替换成c
	 *  a b
	 * b1 1
	 * c 
	 * */
	public int minDistance(String word1, String word2) {
		
        int word1length = word1.length();
        int word2length = word2.length();
        if(word1length*word2length==0) return word1length+word2length;
        int[][] dp = new int[word1length+1][word2length+1];
        for(int i=0;i<word1length+1;i++) dp[i][0]=i;
        for(int j=0;j<word2length+1;j++) dp[0][j]=j;
        
        for(int i=1;i<word1length+1;i++) {
        	for(int j=1;j<word2length+1;j++) {
        		int left = dp[i-1][j]+1;
        		int down = dp[i][j-1]+1;
        		int left_down = dp[i-1][j-1];
        		
        		if(word1.charAt(i-1)!=word2.charAt(j-1)) {
        			left_down++;
        		}
        		dp[i][j]=Math.min(left, Math.min(down, left_down));
        	}
        }
       
        return dp[word1length][word2length];
    }


}
