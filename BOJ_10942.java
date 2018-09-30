import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[][] ans = new int[M][3]; 
		for(int i=0; i<M; i++) {
			st =new StringTokenizer(br.readLine());
			ans[i][0] = Integer.parseInt(st.nextToken());
			ans[i][1] = Integer.parseInt(st.nextToken());
			
			int first = ans[i][0];
			int last = ans[i][1];
			boolean tf = true;
			while(first <= last) {
				if(seq[first-1] == seq[last-1]) {
					first++;
					last--;
				} else {
					tf = false; // 펠린드롬이 아닌 경우 구분을 해주기 위함
					break;
				}
			}
			if(tf) ans[i][2] = 1;
			else ans[i][2] =0; 
		}
		for(int i=0; i<M; i++) System.out.println(ans[i][2]);
	}
}
