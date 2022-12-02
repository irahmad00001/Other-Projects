package hanoi;
import java.util.Stack;

public class HanoiProblem {
	
	private int number;
	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();
	Stack<Integer> st3 = new Stack<Integer>();
	
	public HanoiProblem(int number) {
	this.number = number;
	for(int i = number ; i > 0 ; i--) {
		st1.push(i);
	}
	}
	public void fixProblem(int n ,Stack<Integer> st1 ,Stack<Integer> st2 , Stack<Integer> st3) {
		if(n == 1) {
			st2.push(st1.pop());
			return;
		}
		fixProblem(n-1, st1, st3, st2);
		st3.push(st1.pop());
		fixProblem(n, st3, st2, st1);
	}
}
