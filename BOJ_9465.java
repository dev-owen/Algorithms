import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
	static int T;
	static int[][] arr,dp;
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		result = new int[T];
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[2][N+1];
			dp = new int[2][N+1];
			for(int j=0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=1; k<=N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			/* dp 배열은 가장 왼쪽 열 dp[][1] 부터 차례대로 그 열까지 가질 수 있는 스티커 점수 합의 최대를 입력
			*  					dp[][0]	dp[][1]	dp[][2]	dp[][3] ...
			*	dp[0][]	0					50				30+10		100+100	
			*	dp[1][]	0					30				50+50		50+70
			*/
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for(int j = 2; j <= N; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+arr[1][j];
			}
			result[i] = Math.max(dp[0][N], dp[1][N]);
		}
		for(int res : result) System.out.println(res);
	}
}
