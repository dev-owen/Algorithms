import java.util.Scanner;

public class BOJ_10953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            String str = sc.next();
            int a = Integer.parseInt(str.split(",")[0]);
            int b = Integer.parseInt(str.split(",")[1]);
            System.out.println(a+b);
        }
    }
}
