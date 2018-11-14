import java.util.Scanner;

public class BOJ_9461 {
	static int ans[];
	static long edges[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ans = new int[T];
		edges = new long[101];
		int max = 0;
		for(int i=0; i<T; i++) {
			ans[i] = sc.nextInt();
			max = Math.max(ans[i], max);
		}
		triangle(max);
		for(int n: ans) {
			System.out.println(edges[n]);
		}
	}
	
	static void triangle(int num) {
		edges[1]=1;edges[2]=1;edges[3]=1;
		edges[4]=2;edges[5]=2;
		if(num>=6) {
			for(int i=6; i<=num; i++) {
				edges[i] = edges[i-1]+edges[i-5];
			}
		}
	}
}
