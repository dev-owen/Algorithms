import java.util.*;
public class BOJ_2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] wine = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            wine[i] = sc.nextInt();
        }
        dp[1] = wine[1];
        if(N>=2) dp[2] = wine[1]+wine[2];
        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(Math.max(dp[i-1],dp[i-2]+wine[i]),dp[i-3]+wine[i-1]+wine[i]);
        }
        System.out.println(dp[N]);
    }

}