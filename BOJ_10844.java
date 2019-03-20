import java.util.Scanner;

public class BOJ_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[][] = new int[N+1][10];
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j>=1) dp[i][j] += dp[i-1][j-1];
                if(j<=8) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= 1000000000;
            }
        }
        int res = 0;
        for(int i: dp[N]) {
            res = res + i;
            res = res % 1000000000;
        }
        System.out.println(res);
    }
}
