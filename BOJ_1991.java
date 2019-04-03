import java.util.*;

public class BOJ_1991 {
    static int[][] alpha;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        alpha = new int[27][2]; // A: 1, B: 2, .. Z: 26
        for(int i=1; i<=N; i++) {
            int root = (sc.next()).charAt(0)-'A'+1;
            String lf = sc.next();
            String rg = sc.next();
            if(!lf.equals(".")) {
                int left = lf.charAt(0)-'A'+1;
                alpha[root][0] = left;
            }
            if(!rg.equals(".")) {
                int right = rg.charAt(0)-'A'+1;
                alpha[root][1] = right;
            }
        }
        System.out.println(preOrd(1,""));
        System.out.println(inOrd(1,""));
        System.out.println(postOrd(1,""));

    }

    static String preOrd(int start, String ans) {
        ans += (char)(start+'A'-1);
        if(alpha[start][0] != 0) {
            ans = preOrd(alpha[start][0], ans);
        }
        if(alpha[start][1] != 0) {
            ans = preOrd(alpha[start][1], ans);
        }
        return ans;
    }

    static String inOrd(int start, String ans) {
        if(alpha[start][0] != 0) {
            ans = inOrd(alpha[start][0], ans);
        }
        ans += (char)(start+'A'-1);
        if(alpha[start][1] != 0) {
            ans = inOrd(alpha[start][1], ans);
        }
        return ans;
    }

    static String postOrd(int start, String ans) {
        if(alpha[start][0] != 0) {
            ans = postOrd(alpha[start][0], ans);
        }
        if(alpha[start][1] != 0) {
            ans = postOrd(alpha[start][1], ans);
        }
        ans += (char)(start+'A'-1);
        return ans;
    }
}