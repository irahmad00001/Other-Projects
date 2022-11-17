package testproject;

import java.util.Arrays;

public class Genetics {
	
	public int[][] initail_Population (int p_s , int n) {
		int [][] temp2;
		if(p_s % 2 != 0) {
			temp2 = new int[p_s + 1][(n+1)];
			for(int j = 0; j < n ; j++) {
				temp2[p_s][j] = 0;
			}
		}else {
			temp2 = new int[p_s][(n+1)];
		}
		for(int  i = 0 ; i < p_s ; i++) {
			for(int j = 0; j < n ; j++) {
				temp2[i][j] = (int) ((n)* Math.random());
			}
			temp2[i][n] = 0;
		}
		return temp2;
	}
	
	public int[][] cross_Over (int[][] p_l){
		int[][] temp = new int [2*(p_l.length)][(p_l[0].length)];
		for(int i = 0 ; i < p_l.length ; i++ ) {
			for(int j = 0 ; j< p_l[0].length ; j++) {
				temp[i][j] = p_l [i][j];
			}
		}
		for(int i = 0 ; i < p_l.length ; i += 2) {
			int [] temp2 = new int [p_l[0].length];
			int [] temp3 = new int [p_l[0].length];
			int count1 = (p_l[0].length)/ 2; 
			for(int j = 0 ; j < count1  ; j++) {
				temp2[j] = p_l[i][j];
				temp3[j] = p_l[i+1][j];
			}
			
			for(int j = count1 ; j < p_l[0].length ; j++) {
				temp2[j] = p_l[i+1][j];
				temp3[j] = p_l[i][j];
			}
			temp2[p_l[0].length - 1] = 0;
			temp3[p_l[0].length - 1] = 0;
			temp[(p_l.length + i)] = temp2;
			temp[(p_l.length + i + 1)] = temp3;
		}
		return temp;
	}
	
	public int[][] mutation(int[][] p_l , double intensity){
		int chosen_ones[][] = new int [p_l.length/2][p_l[0].length];
		for(int i = 0 ;  i < chosen_ones.length ; i++) {
			chosen_ones[i] = p_l[((p_l.length/2) + i)];
		}
		for(int i = 0 ;  i < chosen_ones.length ; i++) {
			int rand = (int)((Math.random() * chosen_ones.length) -1);
			int [] temp = chosen_ones[0];
			chosen_ones[0] = chosen_ones[rand];
			chosen_ones[rand] = temp;
		}
		int temp1 = (int)(chosen_ones.length * intensity);
		{
			int [][] chosen_ones_new = new int[temp1][chosen_ones[0].length];
			for(int i = 0 ; i < temp1 ; i++) {
				chosen_ones_new[i] = chosen_ones[i];
			}
			chosen_ones = new int[temp1][chosen_ones[0].length];
			chosen_ones = chosen_ones_new;
		}
		for(int i = 0 ;  i < chosen_ones.length ; i++) {
			int temp = (int)((Math.random()* chosen_ones[0].length )-1);
			chosen_ones[i][temp] = (int)(Math.random()* (chosen_ones[0].length -1));
		}
		{
			int temp[][] = new int [temp1 + (p_l.length/2)][p_l[0].length];
			for(int i = 0 ; i < (p_l.length / 2); i++) {
				temp[i] = p_l[i];
			}
			for(int i = p_l.length/2 ; i < (temp1 + p_l.length/2) ; i ++) {
				temp[i] = chosen_ones[(i - p_l.length/2)];
			}
			p_l = temp;
		}
		return p_l;
	}
	
	public int[][] fitness(int[][] p_l){
		int conflict = 0;
		for(int i = 0 ; i < p_l.length ; i++ ) {
			for(int j = 0 ; j < p_l[0].length ; j++) {
				for(int k = (j + 1) ; k < (p_l[0].length - 1) ; k++) {
					if(p_l[i][j] == p_l[i][k]) {
						conflict++;
					}
					if(Math.abs(p_l[i][j]-p_l[i][k]) == Math.abs(j-k)) {
						conflict++;
					}
				}
			}
			p_l[i][p_l[0].length - 1] = conflict;
			conflict = 0;
		}
		for(int i = p_l.length - 2 ; i >= 0 ; i--) {
			for(int j = 0 ; j <= i ; j++) {
				if(p_l[j][p_l[0].length -1] > p_l[j+1][p_l[0].length -1]) {
					int[] temp = new int [p_l[0].length -1];
					temp = p_l[j];
					p_l[j] = p_l[j+1];
					p_l[j+1] = temp;
				}
			}
		}
		return p_l;
	}
}
