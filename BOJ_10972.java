import java.util.*;

public class BOJ_10972 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numArr[] = new int[N]; // [1,2,3,5,4]
        boolean updown[] = new boolean[N-1]; // [true, true, true, false]
        numArr[0] = sc.nextInt();
        for(int i = 1; i < N; i++) {
            numArr[i] = sc.nextInt();
            if(numArr[i-1] < numArr[i]) {
                updown[i - 1] = true;
            } else {
                updown[i - 1] = false;
            }
        }
        boolean fin = false;
        if(N == 1) fin = true;
        else {
            for(int i = N-2; i >= 0; i--) {
                if(!updown[i]) {
                    if(i == 0) fin = true;
                    continue;
                } else {
                    int incNum = numArr[i]; // N = 5, i = 2, IncNum = 3
                    int nextIdx = 0;
                    int next = 2100000000;
                    for(int j = i+1; j < N; j++) {
                        if(numArr[i] < numArr[j]) {
                            if(numArr[j] < next) {
                                nextIdx = j;
                                next = numArr[j];
                            }
                        }
                    }
                    numArr[i] = next;
                    numArr[nextIdx] = incNum;
                    ArrayList<Integer> tmpAry = new ArrayList<>();
                    for(int j = i+1; j < N; j++) {
                        tmpAry.add(numArr[j]); //tmpAry = [5,3];
                    }
                    Collections.sort(tmpAry);
                    for(int j = i+1; j < N; j++) {
                        numArr[j] = tmpAry.get(j-(i+1));
                    }
                    break;
                }
            }
        }
        if(fin) System.out.println(-1);
        else {
            String ans = "";
            for(int i : numArr) {
                ans += i+" ";
            }
            System.out.println(ans);
        }
    }
}
