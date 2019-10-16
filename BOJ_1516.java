import java.util.*;

public class BOJ_1516 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		int[] value = new int[N + 1];
		int[] result = new int[N + 1];
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			value[i] = sc.nextInt();
			temp = sc.nextInt();
			while (temp != -1) {
				//indegree를 temp가 아닌 i 값으로 받아야한다.
				indegree[i]++;
				//리스트에 저장 될 temp 와 i 값도 바껴야 한다.
				list[temp].add(i);
				temp = sc.nextInt();
			}
		}

		//-----------입력 칸---------------------


		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				result[i] = value[i];

			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				//자신의 건물을 짓기전 이전에 가장 오랜 시간 걸린 값을 찾아야 한다. 그래야 자신의 건물을 올리지
				result[next] = Math.max(result[next], result[current] + value[next]);

				if (indegree[next] == 0) {
					queue.add(next);
				}
			}

		}
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}
