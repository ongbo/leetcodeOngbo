package ByteDance;

import java.util.Stack;

/*
 * 
 * 42. ����ˮ
���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��



������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��

ʾ��:

����: [0,1,0,2,1,0,1,3,2,1,2,1]
���: 6
 * */
public class p1 {
	public static void main(String[] args) {
		System.out.println(trapDou(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	//ջ
	public static int trap(int[] height) {
		int rain = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0;i<height.length;i++) {
			while(!stack.isEmpty()&&height[i]>height[stack.peek()]) {
				//��ջ��Ԫ��С���µ�Ԫ��ʱ����Ҫ������һ����������ǰһ��Ԫ����-1��
				//�ȵ�����
				int top = stack.pop();
				if(!stack.isEmpty()) {
					int boundheight = Math.min(height[i], height[stack.peek()]) - height[top];
					if(boundheight>0) rain = rain + boundheight*(i-stack.peek()-1);
				}
			}
			stack.push(i);
		}
		return rain;
    }
	//˫ָ��
	/*
	 * ˫ָ��ͱȽ������ˣ�
	 * ������һ�룬ֻҪ��һ���ͺ͸ߵ����ӣ���ô�Ϳ����Ե͵�����Ϊ��׼�м�������Ķ��������ˮ����ͬ�ĸ߶ȣ������������б����Ϳ����ˣ�
	 * �ҵ����ߵ͵ģ�Ȼ��һ�μ��㡣
	 * */
	public static int trapDou(int[] height) {
		int rain = 0;
		int i=0,j=height.length-1;
		int imax = 0,jmax = 0;
		while(i<j) {
			if(height[i]<height[j]) {
				System.out.println("imax<=jmax");
				if(imax<=height[i]) imax = height[i];
				else {
					rain = imax-height[i]+rain;
					System.out.println(imax+":"+height[i]);
				}
				i++;
			}
			else{
				System.out.println("imax>=jmax");
				if(jmax<=height[j]) jmax = height[j];
				else {
					rain = jmax -height[j]+ rain;
					System.out.println(jmax+":"+height[j]);
				}
				j--;
			}
		}
		return rain;
	}
}
