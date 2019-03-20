import java.util.*;
public class BOJ_9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    q.add(gcd(arr[i],arr[j]));
                }
            }
            long sum=0;
            for(int a : q) {
                sum += a;
            }
            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {
        if(a>b) {
            if(a%b == 0) return b;
            else return gcd(b,a-b);
        } else if(b>a) {
            if(b%a == 0) return a;
            return gcd(a,b-a);
        } else {
            return a;
        }
    }
}