import java.io.*;
import java.util.Arrays;

public class BOJ_6603 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			arr = new int[N];
			if(N == 0) break;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(str[i+1]);
			}
			
			Arrays.sort(arr);
			dfs(0, 6, "");
			bw.write("\n");
		}
		bw.flush();
	}
	
	private static void dfs(int start, int N, String str) throws Exception {
		if(N == 0) {
			bw.write(str);
			bw.write("\n");
			return;
		}
		if(start == arr.length) return;
		dfs(start + 1, N-1, str+arr[start]+" ");
		dfs(start + 1, N, str);
	}
}
