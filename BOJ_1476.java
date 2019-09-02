import java.util.Scanner;

public class BOJ_1476 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt()-1;
        int S = sc.nextInt()-1;
        int M = sc.nextInt()-1;
        for(int i = 0; i < 15*28*19; i++) {
            if(i%15 == E && i%28 == S && i%19 == M) {
                System.out.println(i+1);
                return;
            }
        }
    }
}
