import java.util.*;

public class BOJ_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long arr[][] = new long[K+1][N+1];
        for(int i=0; i<=K;i++) {
            for(int j=0; j<=N; j++) {
                if(i==0) arr[i][j] = 0;
                if(i==1) arr[i][j] = 1;
                if(i>=2) {
                    for(int k=0; k<=j; k++) {
                        arr[i][j] += arr[i-1][k];
                        arr[i][j] %= 1000000000L;
                    }
                }
            }
        }
        System.out.println(arr[K][N]);
    }
}