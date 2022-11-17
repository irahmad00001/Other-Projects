import java.util.ArrayList;

public class Main {
	public static boolean check(MyStack<Integer> input) {
		Object[] arr = input.copyTo().toArray();
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = (i + 1) ; j < (arr.length - 1) ; i++) {
				if(arr[i] == arr[j]) {
					return false;
				}
				if(Math.abs((int)arr[i] - (int)arr[j]) == Math.abs(i - j)) {
					return false;
				}
			}
	}
		return true;
	}
	public static void main(String[] args) {
		MyStack<Integer> stack1 = new MyStack<Integer>(4);
		stack1.push(2);
		stack1.push(0);
		stack1.push(3);
		stack1.push(1);
		System.out.println(check(stack1));
		
		for(int i = 0 ; i < 8; i++) {
			stack.push(i);
			for(int j = 0 ; j < 8 ; j++) {
				if(check()
			}
		}
		}
}