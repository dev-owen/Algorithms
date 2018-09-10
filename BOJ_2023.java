import java.util.*;
public class BOJ_2023 {
    static int n;
    static boolean prime(int num){
        for(int i=2; i<=(int)Math.sqrt(num); i++)
            if(num%i==0) return false;
        return true;
    }
    static void go(int cnt, int num){
        if(cnt==n){
            if(prime(num)) System.out.println(num);
            return;
        }
        for(int i=1; i<10; i+=2){
            if(prime(num*10+i)) go(cnt+1, num*10+i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        go(1,2);
        go(1,3);
        go(1,5);
        go(1,7);
        sc.close();
    }
}
