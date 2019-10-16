import java.io.*;
import java.util.*;

public class BOJ_2056 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] accumTime = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int spend = Integer.parseInt(st.nextToken());
			int startTime = 0;
			ArrayList<Integer> aryLst = new ArrayList<>();
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				aryLst.add(Integer.parseInt(st.nextToken()));
			}
			for(int k : aryLst) {
				startTime = Math.max(startTime, accumTime[k]);
			}
			accumTime[i] = startTime + spend;
		}
		int res = 0;
		for(int i : accumTime) {
			res = Math.max(res, i);
		}
		System.out.println(res);
	}
}
