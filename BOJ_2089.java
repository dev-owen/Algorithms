import java.util.*;
import java.io.*;
public class BOJ_2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String ans = "";
        while(true) {
            if(N == 0) {
                ans = "0" + ans;
                break;
            } else if(N == 1) {
                ans = "1" + ans;
                break;
            } else if(N > 0) {
                if(N%2 == 0) {
                    ans = "0" + ans;
                } else {
                    ans = "1" + ans;
                }
                N /= 2;
                N *= (-1);
            } else {
                N *= (-1);
                if(N%2 == 0) {
                    ans = "0" + ans;
                    N /= 2;
                } else {
                    ans = "1" + ans;
                    N = N/2 + 1;
                }
            }
        }
        System.out.println(ans);
    }
}