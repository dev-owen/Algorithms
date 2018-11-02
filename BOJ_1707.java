package boj;

import java.io.*;
import java.util.*;

public class BOJ_1707 {
	
	//BFS
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int colors[] = new int[V+1];
			// 각각의 정점에 인접한 정점(Integer)을 ArrayList로 나타냄
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i=0; i<=V; i++) {
				graph.add(new ArrayList<Integer>());
			}
			while(E-->0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			boolean ckBi = true;
			Queue<Integer> q = new LinkedList<>();
			for(int i=1; i<=V; i++) {
				if(colors[i] == 0) {
					q.offer(i);
					colors[i] = 1; // RED = 1, BLUE = -1
				}
				while(!q.isEmpty()&&ckBi) {
					int node = q.poll();
					for(int adj: graph.get(node)) {
						if(colors[adj] == 0) {
							q.offer(adj);
							colors[adj] = colors[node]*-1;
						} else if(colors[node]+colors[adj] != 0) {
							ckBi = false;
							break;
						}
					}
				}
			}
			System.out.println(ckBi?"YES":"NO");
		}
	}
}
