package L20190810;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

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
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。s
 * */
public class SolutionFullJutify {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> retuList  = new ArrayList<String>();
		int i=0,start=0;
		while(i<words.length) {
			int length=0;
			while(i<words.length) {
				if(length+words[i].length()+1>maxWidth) {//多加一个1是保证要有多余的空格
					break;
				}else {length=length+words[i].length()+1;i++;}
			}
			//可以一行的为start---->i-1；
			int slen= maxWidth-length+(i-start);//剩余多少个空格,并且把预留的空格重新分配
			int elemSpace = slen/(i-1-start);
			StringBuilder spaceBuilder = new StringBuilder();
			for(int mm=0;mm<elemSpace;mm++) spaceBuilder.append(" ");
			StringBuilder stringBuilder = new StringBuilder();
			int firstspace = slen-elemSpace*(i-1-start);
			for(int mm=0;mm<slem-elemSpace*(i-1-start);i++)
			for(int mm=start;mm<i-1;mm++) {
				stringBuilder=stringBuilder.append(words[mm]).append(spaceBuilder).append(firstspace);
				firstspace="";
			}
		}
	}
}
