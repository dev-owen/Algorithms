import java.util.*;
public class BOJ_1463_2 {
    public static int[] arr;
    public static int dp(int x) {
        if(x == 1) return 0;
        if(arr[x] > 0) return arr[x];
        arr[x] = dp(x-1)+1;
        if(x%3 == 0) arr[x] = Math.min(dp(x/3)+1, arr[x]);
        if(x%2 == 0) arr[x] = Math.min(dp(x/2)+1, arr[x]);
        return arr[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        arr = new int[X+1];
        System.out.println(dp(X));
    }
}
