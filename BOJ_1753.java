import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	static int V, E, start;
	static int[] shortest; // start로부터 해당 정점까지 최단거리
	static boolean[] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		shortest = new int[V+1];
		isVisited = new boolean[V+1];
		Arrays.fill(shortest, Integer.MAX_VALUE);
		// index by index의 경우 메모리 초과
		ArrayList<Edge>[] list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v,w));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);
		shortest[start] = 0;
		while(!pq.isEmpty()) {
			// 다음에 방문할 정점을 설정
			int cur = pq.poll();
			// 한 번 방문했으므로 true
			isVisited[cur] = true;
			
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i).end; // 다음 정점
				int weight = list[cur].get(i).weight; // 현재 -> 다음 가중치값
				
				if(shortest[next] > shortest[cur]+weight) {
					shortest[next] = shortest[cur]+weight;
					pq.add(next);
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(isVisited[i]) {
				System.out.println(shortest[i]);
			} else {
				System.out.println("INF");
			}
		}
	}
}

class Edge {
	int end;
	int weight;
	Edge(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}
