import java.util.*;

public class BOJ_2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();
        ArrayList<Integer> aryLst = new ArrayList<>();
        aryLst.add(A);
        int idx = 0;
        while(true) {
            int tmp = aryLst.get(idx);
            tmp = calc(tmp,P);
            if(!aryLst.contains(tmp)) {
                aryLst.add(tmp);
                idx++;
            } else {
                System.out.println(aryLst.indexOf(tmp));
                break;
            }
        }
    }

    static int calc(int num, int p) {
        int res = 0;
        while(true) {
            if(num/10 > 0) {
                res += Math.pow(num%10,p);
                num /= 10;
            } else {
                res += Math.pow(num,p);
                break;
            }
        }
        return res;
    }
}