import java.util.*;
public class BOJ_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[100001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i=2; i*i<=N; i++) {
            arr[i*i] = 1;
        }
        for(int i=5; i<=N; i++) {
            if(arr[i] == 0) arr[i] = 2100000000;
            for(int j=0; j<=i/2; j++) {
                arr[i] = Math.min(arr[i-j]+arr[j],arr[i]);
            }
        }
        System.out.println(arr[N]);
    }
}