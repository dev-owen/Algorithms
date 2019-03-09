import java.util.*;
public class BOJ_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
        int i=0;
        while(!queue.isEmpty()) {
            int j = queue.poll();
            i++;
            if(i == M) {
                i = 0;
                sb.append(j+", ");
            } else {
                queue.add(j);
            }
        }
        String str = sb.substring(0, sb.length()-2);
        str += ">";
        System.out.println(str);
    }
}
