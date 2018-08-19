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
            // 0 ~ node1, node1 ~ node2, node2 ~ 1 ���� 3���� ������ ū ���� �⺻ ������ ������ ����
            // �� ª�� ��ΰ� ������ ��ü�� �� �ֵ���
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
           // �� a�� b ������ �Ÿ��� c���� 2���� �迭 W�� ����
        }

        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());
        
       // 1 -- N �ִ� �Ÿ� ���ͽ�Ʈ��
        dijkstra(1, 0);
        // node1 -- N �ִ� �Ÿ� ���ͽ�Ʈ��
        dijkstra(node1, 1);
        // node2 -- N �ִ� �Ÿ� ���ͽ�Ʈ��
        dijkstra(node2, 2);

        int minCost = Math.min(dist[0][node1] + dist[1][node2] + dist[2][N], dist[0][node2] + dist[2][node1] + dist[1][N]);

        System.out.println(minCost >= INF ? -1 : minCost);
    }

    static void dijkstra(int src, int idx) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // Node(node,cost) ��ü�� �⺻������ src��(���۰�)�� cost=0���� ����
        pq.add(new Node(src, 0));
        dist[idx][src] = 0;

        while (!pq.isEmpty()) {

            Node u = pq.poll();

            // �ߺ� ����
            if (dist[idx][u.node] < u.cost) continue;

            for (int i = 1; i <= N; i++) {

                if (W[u.node][i] != 0) {

                    if (dist[idx][i] > dist[idx][u.node] + W[u.node][i]) {
                    	// idx -- i ���� �Ÿ��� �ּڰ��� ã���� �� ���� ����
                        dist[idx][i] = dist[idx][u.node] + W[u.node][i];
                        // idx -- i �� �ִ� �Ÿ�, �� �켱������ ���� ���� ���� PriorityQueue�� ����
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
