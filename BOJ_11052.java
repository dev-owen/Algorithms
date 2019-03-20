import java.util.Scanner;

public class BOJ_11052 {
    static int[] p, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        p = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            p[i] = sc.nextInt();
        }
        dp[1] = p[1];
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                int tmp = Math.max(p[i], dp[i-j]+p[j]);
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        System.out.println(dp[N]);
    }
}
