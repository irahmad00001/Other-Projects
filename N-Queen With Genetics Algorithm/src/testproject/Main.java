package testproject;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Genetics G = new Genetics();
		int temp [][] = G.initail_Population(6 , 8);
			temp = G.cross_Over(temp);
			temp = G.mutation(temp, 0.8);
			temp = G.fitness(temp);
			System.out.print(Arrays.deepToString(temp));
		}
	}
