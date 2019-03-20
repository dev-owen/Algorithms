import java.io.*;
import java.util.*;

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> q = new LinkedList<>();
        while(N-->0) {
            q.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(q);
        for(int i: q) {
            System.out.println(i);
        }
    }
}