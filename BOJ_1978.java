import java.util.*;
public class BOJ_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt = 0;
        while(T-->0) {
            int num = sc.nextInt();
            boolean tf = true;
            if(num == 1) tf = false;
            for(int i=2; i*i<=num; i++) {
                if(num%i == 0) {
                    tf = false;
                    break;
                }
            }
            if(tf) cnt++;
        }
        System.out.println(cnt);
    }
}