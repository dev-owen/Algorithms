import java.util.*;
public class BOJ_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numArr[] = new int[N+1];
        int incArr[] = new int[N+1];
        int decArr[] = new int[N+1];
        for(int i=1; i<=N; i++) {
            numArr[i] = sc.nextInt();
        }
        incArr[1] = decArr[N] = 1;
        for(int i=2; i<=N; i++) {
            int IncCnt = 1; int DecCnt = 1;
            for(int j=1; j<i; j++) {
                if(numArr[j] < numArr[i]) {
                    IncCnt = Math.max(IncCnt, incArr[j]+1);
                }
                if(numArr[N+1-j]<numArr[N+1-i]) {
                    DecCnt = Math.max(DecCnt, decArr[N+1-j]+1);
                }
            }
            incArr[i] = IncCnt;
            decArr[N+1-i] = DecCnt;
        }

        int res = 1;
        for(int i=1; i<=N; i++) {
            res = Math.max(res, incArr[i]+decArr[i]-1);
        }
        System.out.println(res);
    }
}