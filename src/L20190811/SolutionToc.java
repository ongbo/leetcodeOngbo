package L20190811;

import java.util.ArrayList;
import java.util.List;

/*
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。

我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。

如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。


示例 1：
6 6 2
6 5 3
6 4 4
5 5 4

2 6 6
1+2+3+4++5
输入：d = 1, f = 6, target = 3
输出：1
 * */
public class SolutionToc {
	public int numRollsToTarget(int d, int f, int target) {
       //有几个骰子就有集中重复情况
		int retuin = 0;
		if(target<=d*f) {
			List<Integer> ar = new ArrayList<Integer>();
			while(target>d) {ar.add(d); target=target-d;}
			
		}
		return retuin;
    }
}
