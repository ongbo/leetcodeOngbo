package L20190729;
/*
 * ����һ�������� 0 �� 1 ��ɵĶ�ά���� grid�������ҳ��߽�ȫ���� 1 ��ɵ���� ������ �����񣬲����ظ��������е�Ԫ����������������ڣ��򷵻� 0��

 
111   000  000         
101   012  011  
111	  012  020	  



0100111100
0101111101
0100110101
1010111100

ʾ�� 1��

���룺grid = [[1,1,1],[1,0,1],[1,1,1]]
�����9
 * */
public class Competition03 {
	public int largest1BorderedSquare(int[][] grid) {
		int retu = 0;
		for(int i=0;i<grid.length;i++) {//ģ����
			int a=0;
			for(int j=0;j<grid[i].length;j++) {//���������ı߽�
				if(grid[i][j]==1) a++;else {
					//Ϊ0�˾�Ҫ�����1Ϊ�߽糢����,��ʱ��jλ�Ͳ���1��
					int[] num = new int[j-a];   
					for(int k1=j-a;k1<j;k1++) {
						for(int k2=i;k2<grid.length;k2++) {//��ÿһ���м���������1
							if(grid[k2][k1]==1) num[k1-j+1]++;
						}
					}
					//ÿһ�ж���¼���ˣ���������
					for(int k1=j-a;k1<j;k1++) {
						for(int k2=k1+1;k2<j;k2++) {
							if(k2-k1+1>retu) {
							//����ůk1�к�k2��
								int t = 0;
								if(num[k1]<num[k2]) t = k1; else t=k2;
								int dihang = i+num[t];
								int flag=0;
								for(int px=k1;px<=k2;px++)if (grid[dihang][px]==0) {flag=1; break;}
								if(flag==0) {
									if(k2-k1+1>retu) retu = k2-k1+1;
								}
								
							}
						}
					}
				}
				
			}
			
		}
		return retu;
    }
}
