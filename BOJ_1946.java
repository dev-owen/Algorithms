import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] document = new int[N+1]; // document[1] = 3 => 서류 심사 순위 1등은 면접 3등이라는 의미
			while(N-->0) {
				String[] tmp = br.readLine().split(" ");
				int doc = Integer.parseInt(tmp[0]);
				int itv = Integer.parseInt(tmp[1]);
				document[doc] = itv;
			}
			int cnt = 1;
			int criteria = document[1];
			for(int i = 2; i < document.length; i++) {
				if(document[i] < criteria) {
					cnt++;
					criteria = document[i];
				}
			}
			System.out.println(cnt);
		}
	}
}
