import java.util.Scanner;

public class BOJ_10971 {

	static int n, minValue;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		minValue = 2100000000; // 순회에 들어가는 최소 비용
		for(int i = 0; i < n; i++) {
			dfs(i,i,0,0); // 각각의 점에서 시
		}

		System.out.println(minValue);
	}

	static void dfs(int start, int state, int sum, int cnt) { // start에서 시작, 현재 위치 state, 지금까지 비용 합 sum, 지금까지 방문한 도시 개수 cnt
		if(start == state && cnt == n) {
			minValue = Math.min(minValue, sum);
			return;
		}

		for(int i = 0; i < n; i++) {
			if(arr[state][i] == 0) continue;

			if(!visited[state] && arr[state][i] > 0) { // state를 방문하지 않았고, state -> i 가 비용이 있는 경우
				visited[state] = true;
				sum += arr[state][i];

				if(sum <= minValue) { // sum이 minValue보다 작은 경우만 탐색을 계속
					dfs(start, i, sum, cnt+1);
				}
				visited[state] = false; // 초기화
				sum -= arr[state][i];
			}
		}
	}
}
