public class N_Queen {
	private static int number;
	public N_Queen(int number) {
		this.number = number;
	}
	private boolean[][] arr;
	public void zero() {
		arr = new boolean[number][number];
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++)
			arr[i][j] = false;
		}
	}
	public boolean[][] getArr() {
		return arr;
	}
	public void setArr(boolean[][] arr) {
		this.arr = arr;
	}
	
	public boolean backTracking(int  _j) {
		if(_j >= number) {
			return true;
		}
		for(int i = 0; i < number ; i++) {
			if(isSafe(arr,i,_j)) {
				arr[i][_j] = true;
				if(backTracking(_j + 1))
					return true;
				arr[i][_j] = false;
			}
		}
		return false;
	}
	
	
	public static boolean isSafe(boolean board[][] , int _i , int _j) {
		
		for(int i = 0 ; i < number ; i++) {
			if(board[_i][i] == true) {
				return false;
			}
		}
		
		for(int j = 0 ; j < number ; j++) {
			if(board[j][_j] == true) {
				return false;
			}
		}
		
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
					if(board[i][j] == true) {{
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
