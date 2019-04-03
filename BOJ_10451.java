import java.util.*;

public class BOJ_10451 {
    static int arr[];
    static boolean checked[];
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int N = sc.nextInt();
            arr = new int[N+1];
            checked = new boolean[N+1];
            for(int i=1; i<=N; i++) {
                arr[i] = sc.nextInt();
            }
            cnt = 0;
            for(int i=1; i<=N; i++) {
                if(!checked[i]) dfs(i);
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int start) {
        if(checked[start]) {
            cnt++;
            return;
        } else {
            checked[start] = true;
            dfs(arr[start]);
        }
    }
}