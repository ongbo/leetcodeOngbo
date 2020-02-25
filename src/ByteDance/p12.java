package ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p12 {
	public static void main(String[] args) {
		p12 pwP12 = new p12();
		System.out.println(pwP12.numDupDigitsAtMostN(20));
	}
public int numDupDigitsAtMostN(int N) {
      return N - dp(N);  
    }
	public int dp(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int k = digits.size();

        int[] used = new int[10];
        int total = 0;

        for (int i = 1; i < k; i++) {
            total += 9 * A(9, i - 1);
        }

        for (int i = k - 1; i >= 0; i--) {
            int num = digits.get(i);

            for (int j = i == k - 1 ? 1 : 0; j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - (k - i), i);
            }

            if (++used[num] > 1) {
                break;
            }

            if (i == 0) {
                total += 1;
            }
        }
        return total;
    }

    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }
    //计算比如，9个数取三个数，那么就是9*8*7
    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }


//	public int numDupDigitsAtMostN(int N) {
//		int nums = 0;
//		int i=1;
//		for(i=1;i<N/10;i++) {
//			nums = nums + getcount(N,i);
//		}
//		System.out.println(nums);
//		//最后还要计算一次N/10+1的情况。
//		if(i*10>N) return nums;
//		else {
//			int n = i*10;
//			while(n<=N) {
//				Map<Integer, Integer> h = new HashMap<Integer, Integer>();
//				int nn =n;
//				while(nn>0) {
//					if(h.get(nn%10)!=null && h.get(nn%10)>=1) {
//						nums++;
//						break;
//					}
//					h.put(nn%10, 1);
//					nn = nn/10;
//				}
//				h = null;			
//				n++;
//			}
//			
//		}
//		return nums;
//    }
//	public int getcount(int N,int i) {
//		int nums = 0;
//		int num = i;
//		Set<Integer> set = new HashSet<Integer>();
//		while(num>0) {set.add(num%10); num = num/10;}
//		int multi = set.size();
//		set = null;
//		num = i*10;
//		while(num<N) {
//			nums = nums + multi;
//			num = num*10;
//		}
//		return nums;		
//	}
}
