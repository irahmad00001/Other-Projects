package nQueen;

import java.util.ArrayList;

public class My_Stack<T> {
	private ArrayList<T> Array_List = new ArrayList<T>();
	private int max = 0;
	private int N = 0;
	public My_Stack(int number) {
		max = number;
	}
	public void push(T input) {
		if(N < max) {
			Array_List.add(input);
			N++;
		}else {
			System.out.println("ERROR >> StackOverflow");
		}
	}
	public int stack_Size() {
		return N;
	}
	public T pop() {
		if(N != 0) {
		T temp = Array_List.get(N-1);
		Array_List.remove(N-1);
		N--;
		return temp;
		}
		else {
			System.out.println("Error >> StackUnderflow");
			return null;
		}
	}
	
	public T peek() {
		if(N != 0) {
			T temp = Array_List.get(N-1);
			return temp;
			}
			else {
				System.out.println("Error >> StackUnderflow");
				return null;
			}
	}
}
	