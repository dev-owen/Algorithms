import java.util.*;
public class BOJ_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[31];
        arr[0] = 1;
        arr[2] = 3;
        if(N%2 == 0) {
            for(int i=4; i<=N; i+=2) {
                arr[i] = 3*arr[i-2];
                for(int j=4; j<=i; j+=2) {
                    arr[i] += 2*arr[i-j];
                }
            }
        }
        System.out.println(arr[N]);
    }
}