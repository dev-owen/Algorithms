import java.util.*;
public class BOJ_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numArr[] = new int[N+1];
        for(int i=1; i<=N; i++) {
            numArr[i] = sc.nextInt();
        }
        int sumArr[] = new int[N+1];
        sumArr[1] = numArr[1];
        for(int i=2; i<=N; i++) {
            int max = 0;
            for(int j=1; j<i; j++) {
                if(numArr[j] < numArr[i]) {
                    max = Math.max(max, sumArr[j]);
                }
            }
            sumArr[i] = numArr[i]+max;
        }

        int res = 0;
        for(int a: sumArr) {
            res = Math.max(a, res);
        }
        System.out.println(res);
    }
}