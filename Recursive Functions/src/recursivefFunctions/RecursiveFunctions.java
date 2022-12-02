package recursivefFunctions;

import java.util.Arrays;

public class RecursiveFunctions {
	public int fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public int factorial(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public int pow(int base, int pow) {
		if(pow == 0) {
			return 1;
		}
		return base * pow(base , pow-1);
	}
	
	public int combination(int n , int r) {
		if(n == r || r == 0) {
			return 1;
		}
		return (n * combination(n - 1 , r - 1))/r;
	}
	
	public float average(float arr[] , int n){
		if(n == 0) {
			return 0; 
		}
		float temp = arr[n-1];
		arr[n-1] = 0;
		return temp+average(arr, n-1); 
	}
	
	public int[] Array_inverter(int arr[], int i) {
		if(i == arr.length/2) {
			return arr;
		}
		int temp = arr[arr.length-1 - i];
		arr[arr.length-1 - i] = arr[i];
		arr[i] = temp;
		return Array_inverter(arr, i+1);
	}
	
	public String intToBinary(int n) {
		if(n / 2 == 0) {
			return Integer.toString(n%2);
		}
		return intToBinary(n/2) + Integer.toString(n%2) ;
	}
	
	public int findMax(int[] arr , int max , int i) {
		if(i == arr.length) {
			return max;
		}
		if(max < arr[i]) {
			max = arr[i];
		}
		return findMax(arr, max, i+1);
	}
	
	public int findGCD(int a , int b) {
		if(b>a) {
			return findGCD(b, a);
		}
		if(a%b == 0) {
			return b;
		}
		int temp = b;
		b = a % b;
		a = temp;
		return findGCD(a, b);
	}
	
	public 
	public static void main(String args[]) {
		RecursiveFunctions rf = new RecursiveFunctions();
		System.out.println(rf.fibonacci(7));
		System.out.println(rf.factorial(4));
		System.out.println(rf.pow(2,3));
		System.out.println(rf.combination(52, 5));
		float example0[] = {(float)2 , (float)2 , (float)2 , (float)2 , (float)2};
		System.out.println(rf.average(example0, 5)/5);
		int example1[] = {1,2,4,6,8,9};
		System.out.println(Arrays.toString(rf.Array_inverter(example1, 0)));
		System.out.println(rf.intToBinary(12));
		System.out.println(rf.findMax(example1, 0, 0));
		System.out.println(rf.findGCD(287 , 91));
	}
	

}
