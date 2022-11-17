import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> Array_List = new ArrayList<T>();
	private int max = 0;
	private int N = 0;
	public MyStack(int number) {
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
	
	public void clear() {
		N = 0;
		Array_List.clear();
	}
	
	public boolean contains(T input) {
		if(N != 0) {
			boolean temp = Array_List.contains(input);
			return temp;
			}
			else {
				System.out.println("Error >> StackUnderflow");
				return false;
			}
	}
	
	public ArrayList<T> copyTo(){
		return Array_List;
	}
	
	public boolean stackEmpty() {
		return Array_List.isEmpty();
	}
	public MyStack<T> call_Me(){
		MyStack<T> temp = new MyStack<T>(N);
		for(int i = 0 ; i < Array_List.size() ; i++) {
			temp.push(Array_List.get(i));
		}
		return temp;
	}
	
	}
