package L20190811;

public class SolutionSqrt {
	public static void main(String[] args) {
		SolutionSqrt qSolutionSqrt = new SolutionSqrt();
		System.out.println(qSolutionSqrt.mySqrt(8));
	}
	public int mySqrt(int x) {
        for(int i=1;i<x;i++) {
        	if(i*i>x) return i-1;
        }
        return 1;
    }
}
