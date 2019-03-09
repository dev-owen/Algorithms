import java.util.*;
import java.io.*;
public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for(int i=0; i<word.length; i++) {
            stack.push(word[i]);
        }
        while(T-->0) {
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("L")) {
                if(!stack.isEmpty()) {
                    String tmp = stack.pop();
                    stack2.push(tmp);
                }
            } else if(arr[0].equals("D")) {
                if(!stack2.isEmpty()) {
                    String tmp = stack2.pop();
                    stack.push(tmp);
                }
            } else if(arr[0].equals("B")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(arr[0].equals("P")) {
                stack.push(arr[1]);
            }
        }
        while(!stack.isEmpty()) {
            String tmp = stack.pop();
            stack2.push(tmp);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }
        System.out.println(sb);
    }
}
