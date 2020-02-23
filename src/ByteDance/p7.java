package ByteDance;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*460
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。

get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。

进阶：
你是否可以在 O(1) 时间复杂度内执行两项操作？

示例：

LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ /*);*/

//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);       // 返回 4
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lfu-cache
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class p7 {
	class Node {
	    int key;
	    int value;
	    int freq = 1;
	    Node preNode;
	    Node postNode;

	    public Node() {}
	    
	    public Node(int key, int value) {
	        this.key = key;
	        this.value = value;
	    }
	}

	//双向链表
//	class LFUCache1 {
//		Map<Integer, Node> cacheMap;//存储缓存的内容
//		 Map<Integer,LinkedHashSet<Node>> freqMap; //存储每个频次对应的双向链表
//		 int size;
//		 int capacity;
//		 int min;//存储最小频次
//		 
//	    LFUCache1(int capacity) {
//	        cacheMap = new HashMap<Integer, p7.Node>(capacity);
//	        freqMap = new HashMap<Integer, LinkedHashSet<Node>>();
//	        this.capacity = capacity;
//	    }
//	    
//	    public int get(int key) {
//	        Node node = cacheMap.get(key);
//	        if(node == null) {
//	        	return -1;
//	        }
//	        freqInc(node);//增加一次频次
//	        return node.value;
//	    }
//	    
//	    public void put(int key, int value) {
//	        if(capacity == 0) {
//	        	return ;
//	        }
//	        Node node = cacheMap.get(key);
//	        if(node != null) {
//	        	//已经存在了就替换掉，且增加一次频次
//	        	node.value = value;
//	        	freqInc(node);
//	        }else {
//	        	if(size == capacity) {
//	        		//容量到达极限，移除
//	        		Node deadNode = removeNode();
//	        		cacheMap.remove(deadNode.key);
//	        		size--;
//	        	}
//	        	Node newnodeNode = new Node(key,value);
//	        	cacheMap.put(key, newnodeNode);
//	        	//没存在过，说明要增加最开始频率为1
//	        	addNode(newnodeNode);
//	        	size++;
//	        }
//	    }
//	    void freqInc(Node node) {
//	    	//从原来对应的链表里面一处，并更新min；
//	    	//获取这个节点的频率
//	    	int freq = node.freq;
//	    	//获得当前节点频率找到对应频率的HashMap里面的LinkedHashSet
//	    	LinkedHashSet<Node> set = freqMap.get(freq);
//	    	//移除掉LinkedHashSet里面的这个元素
//	    	set.remove(node);
//	    	if(freq == min && set.size() == 0) {
//	    		min = freq +1;
//	    	}
//	    	//加入新freq对应的链表
//	    	node.freq++;
//	    	LinkedHashSet<Node> newSet = freqMap.get(freq+1);
//	    	if(newSet == null) {
//	    		newSet = new LinkedHashSet<>();
//	    		freqMap.put(freq+1, newSet);
//	    	}
//	    	newSet.add(node);
//	    }
//	    
//	    void addNode(Node node) {
//	    	LinkedHashSet<Node> set = freqMap.get(1);
//	    	if( set == null) {
//	    		set = new LinkedHashSet<p7.Node>();
//	    		freqMap.put(1, set);
//	    		
//	    	}
//	    	set.add(node);
//	    	min = 1;
//	    }
//	    Node removeNode() {
//	    	LinkedHashSet<Node> set = freqMap.get(min);
//	    	Node deadNode = set.iterator().next();
//	    	set.remove(deadNode);
//	    	return deadNode;
//	    }
//	}
//	
	class LFUCache2 {
		Map<Integer, Node> cacheMap;//存储缓存内容
		Map<Integer,SelfLinkedList> freMap;
		int size;
		int capacity;
		int min; //存储当前最小频次
	    public LFUCache2(int capacity) {
	        cacheMap = new HashMap<> (capacity);
	        freMap = new HashMap<>();
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        Node node = cacheMap.get(key);
	        if(node == null) {
	        	return -1;
	        }
	        freqInc(node);
	        return node.value;
	    }
	    public void put(int key, int value) {
	    	if(capacity == 0) {
	    		return;
	    	}
	    	Node node = cacheMap.get(key);
	    	if(node != null) {
	    		node.value = value;
	    		freqInc(node);
	    	}else {
	    		if(size == capacity) {
	    			SelfLinkedList minFreqLinkedList = freMap.get(min);
	    			cacheMap.remove(minFreqLinkedList.tailNode.preNode.key);
	    			minFreqLinkedList.removeNode(minFreqLinkedList.tailNode.preNode);
	    			size--;
	    		}
	    		Node newNode = new Node(key,value);
	    		cacheMap.put(key, newNode);
	    		SelfLinkedList linkedList = freMap.get(1);
	    		if(linkedList == null) {
	    			linkedList = new SelfLinkedList();
	    			freMap.put(1,linkedList);
	    		}
	    		linkedList.addNode(newNode);
	    		size++;
	    		min = 1;
	    	}
	    }
	    
	    void freqInc(Node node) {
	    	//先从原链表删除，然后加入频次更高的链表里面
	    	int freq = node.freq;
	    	SelfLinkedList linkedList = freMap.get(freq);
	    	linkedList.removeNode(node);
	    	if(freq == min && linkedList.headNode.postNode == linkedList.tailNode) {
	    		min = freq + 1;
	    	}
	    	node.freq++;
	    	linkedList = freMap.get(freq+1);
	    	if(linkedList == null) {
	    		linkedList = new SelfLinkedList();
	    		freMap.put(freq+1, linkedList);
	    	}
	    	linkedList.addNode(node);
	    }
	   
	}
	class SelfLinkedList{
		Node headNode;
		Node tailNode;
		public SelfLinkedList() {
			headNode = new Node();
			tailNode = new Node();
			headNode.postNode = tailNode;
			tailNode.preNode = headNode;
		}
		void removeNode (Node node) {
			node.preNode.postNode = node.postNode;
			node.postNode.preNode = node.preNode;
		}
		void addNode (Node node) {
			node.postNode = headNode.postNode;
			headNode.postNode.preNode = node;
			headNode.postNode = node;
			node.preNode = headNode;
		}
	}
	
//	class LFUCache {
//		node[] table;
//	    public LFUCache(int capacity) {
//	       table = new node[capacity];
//	    }
//	    
//	    public int get(int key) {
//	        
//	    }
//	    
//	    public void put(int key, int value) {
//	        
//	    }
//	}
//	class node{
//		int key;
//		int value;
//		int freq = 1;
//		node next;
//		public node() {}
//		public node(int key,int value) {
//			this.key = key;
//			this.value = value;
//		}
//		public void setKey(int key) {
//			this.key = key;
//		}
//		public void setValue(int value) {
//			this.value = value;
//		}
//		public int getKey() {
//			return key;
//		}
//		public int getValue() {
//			return value;
//		}
//	}

}
