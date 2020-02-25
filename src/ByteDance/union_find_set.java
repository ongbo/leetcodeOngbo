package ByteDance;

import java.util.Random;

public class union_find_set{
	
	
	public static void main(String[] args) {
		int size = 1000000;
		int m = 1000000;
//		System.out.println(testfind(new UnionFind1(size), m));
//		System.out.println(testunion(new UnionFind2(size), m));
		System.out.println(testunion(new UnionFind3(size), m));
		System.out.println(testunion(new UnionFind4(size), m));
		System.out.println(testunion(new UnionFind5(size), m));
	}
	public static double testfind(UnionFind1 UF, int m) {
		long startTime = System.nanoTime();
		Random random = new Random();
				
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.unionElements(p, q);
		}
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.isConnected(p, q);
			
		}
		long endtime = System.nanoTime();
		return (endtime-startTime)/1000000000.0;
		
			
	}
	public static double testunion(UnionFind2 UF, int m) {
		long startTime = System.nanoTime();
		Random random = new Random();
				
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.unionElements(p, q);
		}
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.isConnected(p, q);
			
		}
		long endtime = System.nanoTime();
		return (endtime-startTime)/1000000000.0;
		
			
	}
	public static double testunion(UnionFind3 UF, int m) {
		long startTime = System.nanoTime();
		Random random = new Random();
				
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.unionElements(p, q);
		}
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.isConnected(p, q);
			
		}
		long endtime = System.nanoTime();
		return (endtime-startTime)/1000000000.0;
		
			
	}
	public static double testunion(UnionFind4 UF, int m) {
		long startTime = System.nanoTime();
		Random random = new Random();
				
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.unionElements(p, q);
		}
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.isConnected(p, q);
			
		}
		long endtime = System.nanoTime();
		return (endtime-startTime)/1000000000.0;
		
			
	}public static double testunion(UnionFind5 UF, int m) {
		long startTime = System.nanoTime();
		Random random = new Random();
				
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.unionElements(p, q);
		}
		for(int i=0;i<m;i++) {
			int p = random.nextInt(UF.size());
			int q = random.nextInt(UF.size());
			UF.isConnected(p, q);
			
		}
		long endtime = System.nanoTime();
		return (endtime-startTime)/1000000000.0;
		
			
	}
	public static class UnionFind1{
		private int[] array;
		public UnionFind1(int size) {
			// TODO Auto-generated constructor stub
			array = new int[size];
			for(int i=0;i<array.length;i++) array[i]=i;
		}
		
		public int size() {
			return array.length;
		}
		public int find(int p) {
			return array[p];
		}
		
		public boolean isConnected(int a, int b) {
			return find(a) == find(b); 
		}
		
		public void unionElements(int p, int q) {
			int pID = find(p);
			int qID = find(1);
			//他们两个本来就是相连的
			if(qID == pID) return;
			for(int i=0;i<array.length;i++) {
				if(array[i]==pID ) array[i] = qID; 
			}			
		}
	}
	
public static class UnionFind2 {
		private int[] parents;
		public UnionFind2(int size) {
			// TODO Auto-generated constructor stub
			parents = new int[size];
			for(int i=0;i<parents.length;i++) parents[i]=i;
		}
		public int size() {
			return parents.length;
		}
		public boolean isConnected(int a, int b) {
			return find(a)== find(b); 
		}
		//向上找到根结点
		public int find(int e) {
			while(e!=parents[e]) e = parents[e];
			return e;
		}
		
		public void unionElements(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			//本身就是一个根结点，说明在同一个集合
			if(qRoot == pRoot) return;
			parents[pRoot] = qRoot;
		}
	}
public static class UnionFind3 {
	private int[] parents;
	private int[] sz;//记录每棵树的节点个数
	public UnionFind3(int size) {
		// TODO Auto-generated constructor stub
		parents = new int[size];
		sz = new int[size];
		for(int i=0;i<parents.length;i++) {
			parents[i]=i;
			sz[i]=1;//每个根结点的一开始都只有一个节点
		}
		
	}
	public int size() {
		return parents.length;
	}
	public boolean isConnected(int a, int b) {
		return find(a)== find(b); 
	}
	//向上找到根结点
	public int find(int e) {
		while(e!=parents[e]) e = parents[e];
		return e;
	}
	
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		//本身就是一个根结点，说明在同一个集合
		if(qRoot == pRoot) return;
		
		//节点数少的合并到节点数多的。
		if(sz[pRoot]<sz[qRoot]) {
			parents[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}else {
			parents[qRoot]= pRoot;
			sz[pRoot] += sz[qRoot];
		}
	}
}
public static class UnionFind4 {
	private int[] parents;
	//rank[i]表示i为根的集合所表示的树的层数，而不是上面的基于元素个数大小
			private int[] rank;
	public UnionFind4(int size) {
		// TODO Auto-generated constructor stub
		parents = new int[size];
		 rank = new int[size];
		for(int i=0;i<parents.length;i++) {parents[i]=i; rank[i]=1;}
	}
	public int size() {
		return parents.length;
	}
	public boolean isConnected(int a, int b) {
		return find(a)== find(b); 
	}
	//向上找到根结点
	public int find(int e) {
		while(e!=parents[e]) e = parents[e];
		return e;
	}
	
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		//本身就是一个根结点，说明在同一个集合
		if(qRoot == pRoot) return;
		//根据根结点树的高度来判断合并方向
		//层级矮的树往层级高的树合并并不需要维护rank
		if(rank[pRoot] <rank[qRoot]) {
			parents[pRoot] = qRoot;
		}else if(rank[pRoot]>rank[qRoot]) {
			parents[qRoot] = pRoot;
		}else {
			//这时候就会高度+1，比如最开始1，2两个元素合并，就是1<-2，高度为2，如果有1<-2，3<-4合并，就是1<-2，1<-3<-4高度就是3
			parents[pRoot] = qRoot;
			rank[qRoot] +=1;
		}
	}
}
public static class UnionFind5 {
	private int[] parents;
	//rank[i]表示i为根的集合所表示的树的层数，而不是上面的基于元素个数大小
			private int[] rank;
	public UnionFind5(int size) {
		// TODO Auto-generated constructor stub
		parents = new int[size];
		 rank = new int[size];
		for(int i=0;i<parents.length;i++) {parents[i]=i; rank[i]=1;}
	}
	public int size() {
		return parents.length;
	}
	public boolean isConnected(int a, int b) {
		return find(a)== find(b); 
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
	
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		//本身就是一个根结点，说明在同一个集合
		if(qRoot == pRoot) return;
		//根据根结点树的高度来判断合并方向
		//层级矮的树往层级高的树合并并不需要维护rank
		if(rank[pRoot] <rank[qRoot]) {
			parents[pRoot] = qRoot;
		}else if(rank[pRoot]>rank[qRoot]) {
			parents[qRoot] = pRoot;
		}else {
			//这时候就会高度+1，比如最开始1，2两个元素合并，就是1<-2，高度为2，如果有1<-2，3<-4合并，就是1<-2，1<-3<-4高度就是3
			parents[pRoot] = qRoot;
			rank[qRoot] +=1;
		}
	}
}

}
