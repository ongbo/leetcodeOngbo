package ByteDance;
/*
 * 给定一个由不同正整数的组成的非空数组 A，考虑下面的图：

有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。
返回图中最大连通组件的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-component-size-by-common-factor
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class p13 {
	public static void main(String[] args) {
		p13 paP13 = new p13();
		paP13.largestComponentSize(new int[] {4,6,15,35});
	}
	public int largestComponentSize(int[] A) {
		 int maxVal = 0;
	        for (int num : A) {
	            maxVal = Math.max(maxVal, num);
	        }

	        // 0 位置不使用，因此需要 + 1
	        UnionFind unionFind = new UnionFind(maxVal + 1);

	        for (int num : A) {
	            double upBound = Math.sqrt(num);
	            for (int i = 2; i <= upBound; i++) {
	                if (num % i == 0) {
	                    unionFind.unionElements(num, i);
	                    unionFind.unionElements(num, num / i);
	                }
	            }
	        }

	        // 将候选数组映射成代表元，统计代表元出现的次数，找出最大者
	        int[] cnt = new int[maxVal + 1];
	        int res = 0;
	        for (int num : A) {
	            int root = unionFind.find(num);
	            cnt[root]++;
	            res = Math.max(res, cnt[root]);
	        }
	        return res;
    }
	public int zhan(int a,int b) {
//		System.out.print(a+":"+b+":::");
		int r = -1;
		if(a<b) {r=a;a=b;b=r;} 
		while(r!=0) {
			r = a%b;
			a=b;
			b=r;
		}
//		System.out.println(a);
		return a;
	}
	public static class UnionFind {
		private int[] parents;
		//rank[i]表示i为根的集合所表示的树的层数，而不是上面的基于元素个数大小
				private int[] rank;
				private int[] size;
		public UnionFind(int size) {
			// TODO Auto-generated constructor stub
			parents = new int[size];
			 rank = new int[size];
			 this.size = new int[size];
			for(int i=0;i<parents.length;i++) {parents[i]=i; rank[i]=1; this.size[i]=1;}
		}
		public int size() {
			return parents.length;
		}
		public boolean isConnected(int a, int b) {
			return find(a)	== find(b); 
		}
		//向上找到根结点
		public int find(int e) {
			while(e!=parents[e]) 
				{
				parents[e] = parents[parents[e]];
				e = parents[e];
					
				}
			return e;
		}
		
		public int unionElements(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			//本身就是一个根结点，说明在同一个集合
			if(qRoot == pRoot) return size[qRoot];
			//根据根结点树的高度来判断合并方向
			//层级矮的树往层级高的树合并并不需要维护rank
			if(rank[pRoot] <rank[qRoot]) {
				parents[pRoot] = qRoot;
				size[qRoot] += size[pRoot];
				return this.size[qRoot];
			}else if(rank[pRoot]>rank[qRoot]) {
				parents[qRoot] = pRoot;
				size[pRoot]+= size[qRoot];
				return this.size[pRoot];
			}else {
				//这时候就会高度+1，比如最开始1，2两个元素合并，就是1<-2，高度为2，如果有1<-2，3<-4合并，就是1<-2，1<-3<-4高度就是3
				parents[pRoot] = qRoot;
				size[qRoot] += size[pRoot];
				rank[qRoot] +=1;
				return this.size[qRoot];
			}
		}
	}
	
}
