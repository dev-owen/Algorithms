import java.util.Scanner;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("");
        Stack<String> stack = new Stack<>();
        int count = 0;
        stack.push("(");
        for(int i=1; i<arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.push(arr[i]);
            } else {
                if(arr[i-1].equals(")")) {
                    stack.pop();
                    count++;
                } else {
                    stack.pop();
                    count += stack.size();
                }
            }
        }
        System.out.println(count);
    }
}
