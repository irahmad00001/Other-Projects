import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class N_Queen {
	
	private int number;
	
	public N_Queen(int number) {
		this.number = number;
	}
	
	private boolean[][] arr;
	
	private boolean backTracking (int _j) {
		if(_j >= number){
			return true;
		}
		for(int i = 0 ; i < number ; i++) {
			if(isSafe(arr,i ,_j)) {
				arr[i][_j] = true;
				if(backTracking(_j+1)) {
					return true;
				}
				arr[i][_j] = false;
			}
		}
		return false;		
	}
	
	public boolean isSafe(boolean board[][], int _i, int _j) 
	{
	for(int j = 0 ; j < number ; j++) {
		if(board[_i][j] == true) {
			return false;
		}
	}
	
	for(int i = 0 ; i < number ; i++) {
		if(board[i][_j] == true) {
			return false;
		}
	}
	
	for(int i = 0 ; i < number ; i++) {
		for(int j = 0 ; j < number ; j++) {
			if(board[i][j] == true)
			if(Math.abs(j - _j) == Math.abs(i - _i)) {
				return false;
			}
		}
	}
    return true;
}
	public String toString() {
		arr = new boolean[number][number];
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				arr[i][j] = false;
			}
		}
		backTracking(0);
		return Arrays.deepToString(arr);
	}
	
	public String toBoard() {
		arr = new boolean[number][number];
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				arr[i][j] = false;
			}
		}
		backTracking(0);
		String st = "";
		for(int i = 0 ; i < number ; i++) {
			st = st + "___";
		}
		st = st + "\n";
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				if(arr[i][j] == true) {
					st = st + "|W|";
				}
				else {
					st = st + "|_|";
				}
			}
			st = st + "\n";
		}
		return st;
	}
	
	
}
