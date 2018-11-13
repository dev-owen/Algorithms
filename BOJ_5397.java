import java.io.*;
import java.util.*;

public class BOJ_5397 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			char[] charArr = br.readLine().toCharArray();
			String pwd = "";
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();
			for(char c : charArr) {
				if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) leftStack.push(c);
				if(c == '<' && !leftStack.isEmpty()) rightStack.push(leftStack.pop());
				if(c == '>' && !rightStack.isEmpty()) leftStack.push(rightStack.pop());
				if(c == '-' && !leftStack.isEmpty()) leftStack.pop();
			}
			while(!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			StringBuilder sb = new StringBuilder();
			while(!rightStack.isEmpty()) {
				sb.append(String.valueOf(rightStack.pop()));
			}
			System.out.println(sb.toString());
		}
	}
}
