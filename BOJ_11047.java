import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int i = N-1;
		while(i>=0) {
			if(K>=coins[i]) {
				K -= coins[i];
				cnt++;
			} else {
				i--;
			}
		}
		System.out.println(cnt);
	}
}