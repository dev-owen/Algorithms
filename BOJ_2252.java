import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BOJ_2252 {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // N은 학생 수, M은 키를 비교한 횟수
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        /*
         *  예를 들어 둘째 줄 이후 입력값 중 3 7 을 입력받았다면
         *  3->7 이라는 개념으로 위상정렬 그래프에서 생각할 수 있고
         *  indegree[7]++ 가 실행된다.
         *  즉, indegree[i]는 i번째 학생이 받은 화살표의 갯수이며
         *  화살표를 하나도 안 받았다면 in degree[i] = 0 이다.
         */
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }
        
        //Topological Sorting
        Queue<Integer> queue = new LinkedList<Integer>();
        /*
         * indegree가 0인 i값은 전부 queue에 넣는다.
         * 순서 어디에 넣어도 상관없기 때문에 결과값에서 가장 먼저 출력해준다.
         */
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            int current = queue.poll();
            
            /*
            *자신이 가리키고 있는 좌표들을 방문하여 indegree값을 -1 해주고 만약 0이라면 큐에 넣어준다.
            *indegree 값이 하나씩 줄어든다는 것은 depth가 하나씩 얕아진다는 뜻(dfs)
            */
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                indegree[next]--;
                if(indegree[next]==0){
                    queue.add(next);
                }
            }
        }
        
    }
 
}