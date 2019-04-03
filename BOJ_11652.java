import java.util.*;

public class BOJ_11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Long> list = new LinkedList<>();
        int N = sc.nextInt();
        for(int i=0; i<N; i++) {
            long tmp = sc.nextLong();
            list.add(tmp);
        }
        Collections.sort(list);
        int maxCnt = 0;
        int cnt = 0;
        long ans = 0;
        long before = list.get(0);
        for(long l : list) {
            if(l == before) {
                cnt++;
                if(cnt > maxCnt) {
                    maxCnt = cnt;
                    ans = l;
                }
            } else {
                cnt = 1;
            }
            before = l;
        }
        System.out.println(ans);
    }
}