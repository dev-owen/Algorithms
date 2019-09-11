import java.util.Scanner;

public class BOJ_1890 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] board = new int[N+1][N+1];
		long[][] dp = new long[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		dp[1][1] = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int step = board[i][j];
				if(dp[i][j] == 0 || step == 0) continue;
				if(i+step <= N) dp[i+step][j] += dp[i][j];
				if(j+step <= N) dp[i][j+step] += dp[i][j];
			}
		}

		System.out.println(dp[N][N]);
	}


}
