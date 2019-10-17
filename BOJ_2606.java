import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int connectNum = sc.nextInt();
		boolean connected[][] = new boolean[N+1][N+1];
		boolean visited[] = new boolean[N+1];

		while(connectNum-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			connected[a][b] = connected[b][a] = true;
		}
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int num = q.poll();
			visited[num] = true;
			for(int i = 1; i <= N; i++) {
				if(connected[num][i] && !visited[i]) {
					q.add(i);
				}
			}
		}
		int cnt = 0;
		for(boolean b : visited) {
			if(b) cnt++;
		}
		System.out.println(cnt-1);
	}

}
