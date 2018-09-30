import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1965 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = 0;
		int cnt = 1;
		int theMax = 0;
		for(int i=1; i<N; i++) {
			int max = -1;
			for(int j=i-1; j>=0; j--) {
				if(dp[j] > max && arr[j]<arr[i]) max = dp[j];
			}
			dp[i] = max+1;
			if(dp[i] > theMax) {
				theMax = dp[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
