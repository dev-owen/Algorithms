import java.util.*;
public class BOJ_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numArr = new int[N+1];
        int[] sumArr = new int[N+1];
        for(int i=1; i<=N; i++) {
            numArr[i] = sc.nextInt();
        }
        sumArr[1] = numArr[1];
        for(int i=2; i<=N; i++) {
            sumArr[i] = Math.max(numArr[i], sumArr[i-1]+numArr[i]);
        }
        int res = -2100000000;
        for(int i=1; i<=N; i++) {
            res = Math.max(res, sumArr[i]);
        }
        System.out.println(res);
    }
}
