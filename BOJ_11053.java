import java.util.*;
public class BOJ_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numArr[] = new int[N+1];
        for(int i=1; i<=N; i++) {
            numArr[i] = sc.nextInt();
        }
        int cntArr[] = new int[N+1];
        cntArr[1] = 1;
        for(int i=2; i<=N; i++) {
            int max = 1;
            for(int j=1; j<i; j++) {
                if(numArr[j] < numArr[i]) {
                    max = Math.max(max, cntArr[j]+1);
                }
            }
            cntArr[i] = max;
        }
        int ans = 0;
        for(int a: cntArr) {
            ans = Math.max(ans, a);
        }
        System.out.println(ans);
    }
}
