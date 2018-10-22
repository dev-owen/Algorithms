import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1764 {
	static int N,M;
	static HashSet<String> hs = new HashSet<>();
	static PriorityQueue<String> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while(N-->0) {
			hs.add(br.readLine().trim());
		}
		while(M-->0) {
			String tmp = br.readLine().trim();
			if(hs.contains(tmp)) pq.add(tmp);
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			String ans = pq.poll();
			System.out.println(ans);		
		}
	}
}
