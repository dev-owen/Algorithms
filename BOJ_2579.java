import java.util.*;
public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stairs = new int[N+1];
        stairs[0] = 0;
        int[] sumArr = new int[N+1];
        sumArr[0] = 0;
        for(int i=1; i<=N; i++) {
            stairs[i] = sc.nextInt();
        }
        sumArr[1] = stairs[1];
        if(N>=2) sumArr[2] = stairs[1]+stairs[2];
        for(int i=3; i<=N; i++) {
            sumArr[i] = Math.max(sumArr[i-2]+stairs[i],sumArr[i-3]+stairs[i-1]+stairs[i]);
        }
        System.out.println(sumArr[N]);
    }
}