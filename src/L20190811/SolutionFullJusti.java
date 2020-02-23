package L20190811;

import java.util.ArrayList;
import java.util.List;

/*给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/text-justification
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SolutionFullJusti {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>  retuList = new ArrayList<String>();
        int length = 0,start=0,end=0;
        for(int i=0;i<words.length;i++) {
        	if(length+words[i].length()+1<=maxWidth) {//这时候可以放下这个单词
        		length = words[i].length()+1+length;
        		end++;
        	}else if(length+words[i].length()==maxWidth) {
        		//这种情况就是空格均匀，刚好放入所有单词
        		end++;
        		StringBuilder builder = new StringBuilder();
        		for(int j=start;j<end-1;j++) builder.append(words[j]+" ");
        		builder.append(words[i]);
        		retuList.add(builder.toString());
        		start=end;
        		length=0;
        	}else {//这种情况就是空格分配不会均匀
        		//但是要保证做左边空格大于右边空格
        		int nums = end-start+1+maxWidth-length;//总共这一行需要的空格个数
        		int wordnums = end-start+1;//这一行的单词个数
        		int space = nums/(wordnums-1);//至少每一个都要分配的空格个数
        		int sen = nums-space*(wordnums-1);//剩余怎么分配
        		
        		
        	}
        }
        return retuList;
    }
}
