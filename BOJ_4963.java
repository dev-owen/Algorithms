import java.io.*;
import java.util.*;

public class BOJ_4963 {
    static boolean[][] landOrSea;
    static boolean[][] checked;
    static int[] dRow = {-1,1,0,0,1,1,-1,-1};
    static int[] dCol = {0,0,-1,1,-1,1,1,-1};
    static int w,h,landCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            landOrSea = new boolean[h+1][w+1];
            for(int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++) {
                    String str = st.nextToken();
                    if(str.equals("1")) landOrSea[i][j] = true;
                    else landOrSea[i][j] = false;
                }
            }
            checked = new boolean[h+1][w+1];
            landCnt = 0;
            for(int i=1; i<=h; i++) {
                for(int j=1; j<=w; j++) {
                    if(!checked[i][j] && landOrSea[i][j]) {
                        bfs(i,j);
                        landCnt++;
                    }
                }
            }
            System.out.println(landCnt);
        }
    }

    static void bfs(int row, int col) {
        checked[row][col] = true;
        for(int i=0; i<8; i++) {
            int nextRow = row+dRow[i];
            int nextCol = col+dCol[i];

            if(nextRow > 0 && nextCol > 0 && nextRow <= h && nextCol <= w && !checked[nextRow][nextCol] && landOrSea[nextRow][nextCol]) {
                bfs(nextRow, nextCol);
            }
        }
    }
}