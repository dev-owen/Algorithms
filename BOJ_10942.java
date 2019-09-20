import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[][] ans = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			ans[i][0] = Integer.parseInt(st.nextToken());
			ans[i][1] = Integer.parseInt(st.nextToken());
		}

		boolean[][] pal = new boolean[N+1][N+1]; // pal[1][3] = true -> 1부터 3까지 팰린드롬
		for(int i = 1; i <= N; i++) {
			pal[i][i] = true;
		}
		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i+1]) pal[i][i+1] = true;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N-i; j++) {
				if(arr[j] == arr[j+i] && pal[j+1][j+i-1]) pal[j][j+i] = true;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < M; i++) {
			bw.write(pal[Math.min(ans[i][0],ans[i][1])][Math.max(ans[i][0],ans[i][1])] ? 1+"\n" : 0+"\n");
		}
		bw.flush();
		bw.close();

	}
}
