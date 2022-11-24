package nQueen;

import java.util.Arrays;

public class N_Queen {
	private int number = 8;
	public N_Queen(int n) {
		number = n;
	}
	
	My_Stack<Pair> stack = new My_Stack<Pair>(number); 
	public boolean[][] backTracking(){
		boolean[][] board =  new boolean[number][number];
		
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				board[i][j] = false;
			}
		}
		for(int i = 0 , k = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++ , k++) {
				
				if(isSafe(board, i , j)) {
					k = 0;
					Pair<Integer , Integer> p1 = new Pair<Integer, Integer>(i , j);
					stack.push(p1);
					board[i][j] = true;
					break;					
				}
				if(k == number-1) {
					Pair<Integer , Integer> p2 = stack.pop();
					board[p2.firstValue][p2.secondValue] = false;
					k = p2.secondValue;
					j = p2.secondValue;
					i = p2.firstValue;
					if(j == number-1) {
						Pair<Integer , Integer> p3 = stack.pop();
						board[p3.firstValue][p3.secondValue] = false;
						k = p3.secondValue;
						j = p3.secondValue;
						i = p3.firstValue;
					}
				}
			}
		}
		return board;
	}
	
	public boolean isSafe(boolean board[][] , int _i , int _j) { 
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
		boolean[][] board =  backTracking();
		return Arrays.deepToString(board);
	}
	
	public String toBoard() {
		boolean[][] board =  backTracking();
		String st = "";
		for(int i = 0 ; i < number ; i++) {
			st = st + "___";
		}
		st = st + "\n";
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				if(board[i][j] == true) {
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
