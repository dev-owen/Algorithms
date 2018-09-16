import java.util.Scanner;

public class BOJ_5532 {
	static int L,A,B,C,D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		int korDay = (int) Math.ceil((A/(double)C));
		int mathDay = (int) Math.ceil((B/(double)D));
		System.out.println(L-Math.max(korDay, mathDay));
	}

}
