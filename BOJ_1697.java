import java.util.*;

public class BOJ_1697 {

	static int N,K,minTime[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		minTime = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		minTime[N] = 1;
		q.add(N);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n == K) {
				System.out.println(minTime[n]-1);
				break;
			}
			// n-1을 처리
			if(n-1 >= 0) {
				if(minTime[n-1] == 0) {
					minTime[n-1] = minTime[n]+1;
					q.add(n-1);
				}
			}
			if(n+1 <= 100000) {
				if(minTime[n+1] == 0) {
					minTime[n+1] = minTime[n]+1;
					q.add(n+1);
				}
			}
			if(2*n <= 100000) {
				if(minTime[2*n] == 0) {
					minTime[2*n] = minTime[n]+1;
					q.add(2*n);
				}
			}
		}
	}
}
