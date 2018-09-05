import java.util.Scanner;

public class BOJ_1065 {
	static int N, a, b, c, ANS;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N<100) System.out.println(N);
		else {
			ANS = N;
			for(int i=100;i<=N;i++) {
				a = i/100;
				b = (i%100)/10;
				c = (i%10);
				if(a+c !=2*b) ANS--;
			}
			System.out.println(ANS);
		}
	}
}
