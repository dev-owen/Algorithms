import java.util.*;
public class BOJ_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for(int i=M; i<=N; i++) {
            boolean tf = true;
            if(i == 1) tf = false;
            for(int j=2; j*j <=i; j++) {
                if(i%j == 0) {
                    tf = false;
                    break;
                }
            }
            if(tf) System.out.println(i);
        }
    }
}