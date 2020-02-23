package L20190719;

import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

*/
public class SolutionIsValid {
	public static void main(String[] args) {
		SolutionIsValid valid = new SolutionIsValid();
		System.out.print(valid.isValid("()[]{}"));
	}
	
	 public boolean isValid(String s) {
		 //两种方法算法一样，但是数据结构不一样
		  Stack<Character> stack = new Stack<Character>();

		    for (int i = 0; i < s.length(); i++) {
		      char c = s.charAt(i);

		      // If the current character is a closing bracket.
		      if (this.mappings.containsKey(c)) {

		        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
		        char topElement = stack.empty() ? '#' : stack.pop();

		        // If the mapping for this bracket doesn't match the stack's top element, return false.
		        if (topElement != this.mappings.get(c)) {
		          return false;
		        }
		      } else {
		        // If it was an opening bracket, push to the stack.
		        stack.push(c);
		      }
		    }

		    // If the stack still contains elements, then it is an invalid expression.
		    return stack.isEmpty();

//		 int i=0;
//		 while(i<s.length()) {
//			 switch (s.charAt(i)) {
//			case ')':
//				if(i>0&&s.charAt(i-1)=='(') {
//					StringBuffer buffer = new StringBuffer(s);
//					buffer.delete(i-1, i+1);
//					s=buffer.toString();
//					i--;
//				}else return false;
//				break;
//			case ']':
//				if(i>0&&s.charAt(i-1)=='[') {
//					StringBuffer buffer = new StringBuffer(s);
//					buffer.delete(i-1, i+1);
//					s=buffer.toString();
//					i--;
//				}else return false;
//				break;
//			case '}':
//				if(i>0&&s.charAt(i-1)=='{') {
//					StringBuffer buffer = new StringBuffer(s);
//					buffer.delete(i-1, i+1);
//					s=buffer.toString();
//					i--;
//				}else return false;
//				break;
//			default:
//				i++;
//				break;
//			}
//		 }
//		 if(s.equals("")) return true;else return false;
	 }
}
