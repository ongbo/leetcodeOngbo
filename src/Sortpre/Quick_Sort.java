package Sortpre;

public class Quick_Sort {
	public static void main(String[] args) {
		int[] a = {2,54,34,87,45,34,76,23,76};
		quicksort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++) System.out.println(a[i]);
	}
	public static void quicksort(int[] num,int s,int e) {
		if(s<e) {
			int i=s,j=e;
			int x = num[i];//��һ����׼��
			while(i<j) {
				
				while(i<j&&num[j]>x) j--;//��С�������򣬴��ұ���һ��С�ģ���ķ��ұ�
				if(i<j) {//˵���ҵ���
					num[i]=num[j];
					i++;
				}
				while(i<j&&num[i]<x) i++;
				if(i<j) {
					num[j]=num[i];
					j--;
				}				
			}
			num[i]=x;
			quicksort(num, s, i-1);
			quicksort(num, i+1, e);
		}
	}
}
