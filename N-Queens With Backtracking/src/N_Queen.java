import java.util.Arrays;

public class N_Queen {
	
	private int number;
	public N_Queen(int number) {
		this.number = number;
	}
	private boolean[][] arr;
	
	public void show_Answer() {
		arr = new boolean[number][number];
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				arr[i][j] = false;
			}
		}
		backTracking(0);
		System.out.println(Arrays.deepToString(arr));
	}
	
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
	
	private boolean isSafe(boolean[][] arr , int _i , int _j) {
		for(int i = 0 ; i < number ; i++) {
			if(arr[_i][i] == true) {
				return false;
			}
		}
		
		for(int j = 0 ; j < number ; j++) {
			if(arr[j][_j] == true) {
				return false;
			}
		}
		
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
					if(arr[i][j] == true) {{
						if(i - _i == j - _j) {
						return false;
						}
					}
				}
			}
		}
		return true;
	}
}
