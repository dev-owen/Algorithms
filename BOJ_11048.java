import java.util.Scanner;

public class BOJ_11048 {

	static int[][] arr, dp;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] += Math.max(arr[i][j-1],Math.max(arr[i-1][j], arr[i-1][j-1]));
			}
		}
		System.out.println(arr[N][M]);
	}

}
