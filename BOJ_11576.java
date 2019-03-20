import java.util.*;

public class BOJ_11576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int num = 0;
        for(int i=C-1; i>=0; i--) {
            int tmp = sc.nextInt();
            num += tmp*Math.pow(A,i);
        }
        String res = "";
        while(true) {
            if(num >= B) {
                res = num%B+" "+res;
                num /= B;
            } else {
                res = num+" "+res;
                break;
            }
        }
        System.out.println(res);
    }
}