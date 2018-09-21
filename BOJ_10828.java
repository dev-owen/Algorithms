import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class BOJ_10828 {
	static int T;
	static Stack<Integer> stack = new Stack<>();
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		arr = new String[T];
		for(int i=0; i<T; i++) arr[i] = br.readLine().trim();
		
		for(int i=0; i<T; i++) {
			String[] str = arr[i].split(" ");
			if(str.length == 2) stack.push(Integer.parseInt(str[1]));
			else {
				if(str[0].equals("top")) {
					if(!stack.isEmpty()) System.out.println(stack.peek());
					else System.out.println(-1);
				} else if(str[0].equals("size")) System.out.println(stack.size());
				else if(str[0].equals("empty")) {
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
				} else if(str[0].equals("pop")) {
					if(!stack.isEmpty()) System.out.println(stack.pop());
					else System.out.println(-1);
				}
			}
		}
	}
}
