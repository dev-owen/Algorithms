import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9996 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] ans = new boolean[N];
		String[] ptn = br.readLine().split("\\*");
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			if(tmp.startsWith(ptn[0])) {
				tmp = tmp.substring(ptn[0].length(), tmp.length());
				if(tmp.endsWith(ptn[1])) ans[i] = true;
			}
		}
		for(boolean b: ans) System.out.println(b?"DA":"NE");
	}
}
