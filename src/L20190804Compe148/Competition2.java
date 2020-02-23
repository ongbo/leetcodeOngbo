package L20190804Compe148;
/*
 * 
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。

 

游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，

「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；

「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。

「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。

 

之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点 未着色 的一个邻节点（即左右子节点、或父节点）进行染色。

如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。

若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。

 

现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
 * */

//算法就是对x节点的子节点
/*
 * 如果对x的左节点进行深度探测，那么就要对x的父节点向上遍历进行父节点探索，和右节点探测，反之一样
 * 如果对x的右节点。。。。。
 * 如果对x的父节点进行深度探测。。。。。。。。
 * *？
 */
public class Competition2 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode numNode = root;
        if(root.val!=x) {
        	TreeNode aNode = parent(root, x);
        	int x1=0;
        	if(aNode.left!=null&&aNode.left.val==x) x1=nodenum(aNode.left);
        	else if(aNode.right!=null&&aNode.right.val==x) x1=nodenum(aNode.right);
        	
        }
    }
    public TreeNode parent(TreeNode root,int x) {
    	TreeNode aNode = null;
    	if(root.left!=null) {
    		if(root.left.val==x) return root;
    		else aNode = parent(root.left, x);
    	}
    	if(aNode!=null) return aNode;
    	if(root.right!=null) {
    		if(root.right.val==x) return root;
    		else aNode = parent(root.right, x);
    	}
    	return aNode;
    }
    public int nodenum(TreeNode node) {
    	int sum1 = 0;
    	int sum2=0;
    	if(node.left!=null) sum1=sum1+nodenum(node.left);
    	if(node.right!=null) sum2=sum2+nodenum(node.right);
    	if(sum1>sum2) return sum1; else return sum2;
    }
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
}
