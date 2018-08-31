import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9372 {
	static int T, C, P, A, B;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		ans = new int[T];
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			for(int j=0; j<P; j++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
			}
			ans[i] = C-1;
		}
		for(int a : ans) System.out.println(a);
	}
}
