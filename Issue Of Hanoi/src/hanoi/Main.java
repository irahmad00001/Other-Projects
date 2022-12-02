package hanoi;

public class Main {
	public static void main(String args[]) {
		HanoiProblem hp = new HanoiProblem(3);
		hp.fixProblem(3, hp.st1, hp.st2, hp.st3);
		System.out.println(hp.st1);
		System.out.println(hp.st2);
		System.out.println(hp.st3);
	}

}
