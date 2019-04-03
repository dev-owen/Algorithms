import java.io.*;
import java.util.*;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> aryLst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(N-->0) {
            aryLst.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(aryLst);
        System.out.println(aryLst.get(K-1));
    }
}