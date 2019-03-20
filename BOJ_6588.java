import java.io.*;
import java.util.*;
public class BOJ_6588 {
    public static void main(String[] args) throws IOException {
        boolean sosu[] = new boolean[1000001];
        for(int i=3; i<=1000000;i++) {
            boolean tf = true;
            for(int j=2; j*j<=i; j++) {
                if(i%j == 0) {
                    tf = false;
                    break;
                }
            }
            if(tf) sosu[i] = true;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) return;
            boolean tf = false;
            for(int i=N-3; i>=N/2; i--) {
                if(sosu[i] && sosu[N-i]) {
                    tf = true;
                    System.out.println(N+" = "+(N-i)+" + "+i);
                    break;
                }
            }
            if(!tf) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}