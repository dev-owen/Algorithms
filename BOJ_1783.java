import java.util.Scanner;

public class BOJ_1783 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		System.out.println(count(N,M));
	}

	static int count(int n, int m) {
		if(n == 1) {
			return 1;
		} else if(n == 2) {
			return Math.min(4, (m-1)/2+1);
		} else {
			if(m >= 7) {
				return m-2;
			} else {
				if(m == 1) return 1;
				else if(m == 2) return 2;
				else if(m == 3) return 3;
				else return 4;
			}
		}
	}
}
