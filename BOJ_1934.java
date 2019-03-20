import java.util.*;
public class BOJ_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(lcm(n,m));
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

    public static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
}