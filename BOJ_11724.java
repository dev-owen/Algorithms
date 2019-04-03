import java.io.*;
import java.util.*;

public class BOJ_11724{
    static int N;
    static boolean[] checked;
    static boolean[][] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        path = new boolean[N+1][N+1];
        while(M-->0) {
            String[] arr2 = br.readLine().split(" ");
            int a = Integer.parseInt(arr2[0]);
            int b = Integer.parseInt(arr2[1]);
            path[a][b] = true;
            path[b][a] = true;
        }
        checked = new boolean[N+1];
        int res = 0;
        int start = 1;
        while(true) {
            if(!checked[start]) {
                res++;
                bfs(start);
                boolean tmp = false;
                for(int j=1; j<=N; j++) {
                    if(!checked[j]) {
                        start = j;
                        tmp = true;
                        break;
                    }
                }
                if(!tmp) break;
            }
        }
        System.out.println(res);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i=1; i<=N; i++) {
                if(!checked[i] && path[num][i]) {
                    q.add(i);
                    checked[i] = true;
                }
            }
        }
    }
}