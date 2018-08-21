*
*
*
*
// 백준 10815 
import java.util.*;
import java.io.*;
 
public class BS {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        BitSet bitSet = new BitSet();
        for (int i = 0; i < N; i++) bitSet.set(Integer.parseInt(st.nextToken()) + 10000000);
 
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) bw.write((bitSet.get(Integer.parseInt(st.nextToken()) + 10000000) ? "1 " : "0 "));
        bw.flush();
    }
}
