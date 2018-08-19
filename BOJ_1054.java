import java.io.*;
import java.util.*;

public class BOJ_1054 {

    static final int INF = 100000000;

    static int N, E;
    static int[][] W = new int[801][801];
    static int[][] dist = new int[3][801];

    static {

        for (int i = 0; i < 3; i++) {

            Arrays.fill(dist[i], INF);
            // 0 ~ node1, node1 ~ node2, node2 ~ 1 까지 3개의 구간에 큰 값을 기본 값으로 설정해 놓음
            // 더 짧은 경로가 나오면 대체할 수 있도록
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            W[a][b] = c;
            W[b][a] = c;
           // 점 a와 b 사이의 거리가 c임을 2차원 배열 W에 삽입
        }

        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());
        
       // 1 -- N 최단 거리 다익스트라
        dijkstra(1, 0);
        // node1 -- N 최단 거리 다익스트라
        dijkstra(node1, 1);
        // node2 -- N 최단 거리 다익스트라
        dijkstra(node2, 2);

        int minCost = Math.min(dist[0][node1] + dist[1][node2] + dist[2][N], dist[0][node2] + dist[2][node1] + dist[1][N]);

        System.out.println(minCost >= INF ? -1 : minCost);
    }

    static void dijkstra(int src, int idx) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Node(node,cost) 객체에 기본적으로 src값(시작값)은 cost=0으로 설정
        pq.add(new Node(src, 0));
        dist[idx][src] = 0;

        while (!pq.isEmpty()) {

            Node u = pq.poll();

            // 중복 제거
            if (dist[idx][u.node] < u.cost) continue;

            for (int i = 1; i <= N; i++) {

                if (W[u.node][i] != 0) {

                    if (dist[idx][i] > dist[idx][u.node] + W[u.node][i]) {
                    	// idx -- i 사이 거리의 최솟값을 찾으면 그 값을 삽입
                        dist[idx][i] = dist[idx][u.node] + W[u.node][i];
                        // idx -- i 의 최단 거리, 즉 우선순위가 가장 높은 값을 PriorityQueue에 삽입
                        pq.add(new Node(i, dist[idx][i]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int node;
    int cost;

    Node(int node, int cost) {

        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {

        return this.cost < o.cost ? -1 : 1;
    }
}
