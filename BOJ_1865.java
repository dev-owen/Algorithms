package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Edge{

    int start;
    int end;
    int cost;
    Edge(){
        this.start=0;
        this.end=0;
        this.cost=0;
    }
    Edge(int s, int e, int c){
        this.start = s;
        this.end = e;
        this.cost = c;
    }
}

public class BOJ_1865 {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int inf = Integer.MAX_VALUE;

        for(int k=0; k<T; k++){
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            ArrayList<Edge> a = new ArrayList<>();

            for(int i=0; i<m; i++){
            	st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                a.add(new Edge(s,e,t));
                a.add(new Edge(e,s,t));
            }

            for(int i=0; i<w; i++){
            	st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                a.add(new Edge(s,e,-t)); 
            }

            int[] dist = new int[n+1];
            for(int i=1; i<=n; i++) {
                dist[i] = inf;
            }

            dist[1]=0;

            boolean cycle = false;

            for(int i=1; i<=n; i++){
                for(Edge e : a){
                    int x = e.start;
                    int y = e.end;
                    int z = e.cost;
                    if(dist[x]!=inf&&dist[y]>dist[x]+z){
                        dist[y] = dist[x]+z;
                        if(i==n){ // 이 말은 웜홀에 의해 최단거리보다 시간이 줄어들었다는 의미
                            cycle=true;
                        }
                    }
                }
            }
            System.out.println(cycle ? "YES" : "NO");
        }
    }

}