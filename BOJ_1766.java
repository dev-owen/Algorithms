import java.io.*;
import java.util.*;

public class BOJ_1766 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());      
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
        	st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken()); // x를 풀고 나서 y를 풀어야 한다(조건2)
            list[x].add(y);    //리스트 안의 리스트에 값을 넣어준다.
            indegree[y]++;    //자신을 가르키고 있는 화살표의 갯수
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i=1; i<=N; i++){
            //indegree가 0인 값들 모두 큐에 넣어준다.
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            //indgree가 0인 값을 큐에서 뽑는다.(조건3)
            int current = q.poll();
            System.out.print(current+" ");
            //뽑힌 곳에서 갈 수 있는 곳들을 검색하여 indegree를 -1한다.(자신을 가르키는 화살표가 하나 사라졌기 때문에)
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                indegree[next]--;
                //indegree가 0이라면 큐에 넣는다.
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
    }
}
