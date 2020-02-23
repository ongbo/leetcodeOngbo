package TOP100;

public class Min_Stack {
	//������ʵ��һ��ջ
	int capacity=5;//����
	int nums=0;//ջ��Ԫ�ظ���
	int[] minstack = new int[capacity];
	 public Min_Stack() {
	        
	  }
	    
	    public void push(int x) {
	        if(nums==capacity) {//����
	        	int[] ak = new int[2*capacity];
	        	for(int i=0;i<nums;i++) ak[i] = minstack[i];
	        	minstack=ak;
	        	capacity=capacity*2;
	        }
	        nums++;
	        minstack[nums-1]=x;
	    }
	    
	    public void pop() {
	        nums--;
	        minstack[nums]=0;
	    }
	    
	    public int top() {
	        return minstack[nums-1];
	    }
	    
	    public int getMin() {
	    	int min = Integer.MAX_VALUE;
	        for(int i=0;i<nums;i++) if(minstack[i]<min) min = minstack[i];
	        return min;
	    }
}
