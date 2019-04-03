import java.util.*;

public class BOJ_2667 {
    static boolean[][] houses;
    static boolean[][] checked;
    static int N, danji, eachApt;
    static int[] dRow = {1,-1,0,0};
    static int[] dCol = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        houses = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            char[] chArr = sc.next().toCharArray();
            for(int j=1; j<=N; j++) {
                if(chArr[j-1] == '1') houses[i][j] = true;
                else houses[i][j] = false;
            }
        }
        checked = new boolean[N+1][N+1];
        danji = 0;
        ArrayList<Integer> aryLst = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(!checked[i][j] && houses[i][j]) {
                    eachApt = 0;
                    bfs(i,j);
                    aryLst.add(eachApt);
                    danji++;
                }
            }
        }
        Collections.sort(aryLst);
        System.out.println(danji);
        for(int a : aryLst) {
            System.out.println(a);
        }
    }

    static void bfs(int row, int col) {
        eachApt++;
        checked[row][col] = true;
        for(int i=0; i<4; i++) {
            int nextRow = row+dRow[i];
            int nextCol = col+dCol[i];
            if(nextRow>0 && nextRow<=N && nextCol>0 && nextCol<=N && !checked[nextRow][nextCol] && houses[nextRow][nextCol]) {
                bfs(nextRow, nextCol);
            }
        }
        return;
    }
}