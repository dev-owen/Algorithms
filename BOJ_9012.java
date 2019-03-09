import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            String[] str = sc.next().split("");
            boolean vps = true;
            Stack<String> stack = new Stack<>();
            for(int i=0; i<str.length; i++) {
                if(str[i].equals("(")) {
                    stack.push(str[i]);
                } else {
                    if(stack.isEmpty()) {
                        vps = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            System.out.println(stack.isEmpty()&&vps ? "YES" : "NO");
        }
    }
}
