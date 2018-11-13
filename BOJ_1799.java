import java.io.*;
import java.util.*;

public class BOJ_1799 {
	final static int BLACK = 1;
	final static int WHITE = 0;
	static int N, colors[][], bsPos[][], ans[];
	static int[] dRow = {-1,-1,1,1};
	static int[] dCol = {-1,1,1,-1};
	static boolean[] isVisited = new boolean[100];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		colors = new int[N][N]; // 1은 검정색, 0은 흰색으로 체스판 색깔 구분
		bsPos = new int[N][N]; // 비숍이 위치할 수 있는 칸
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				bsPos[i][j] = Integer.parseInt(st.nextToken());
				if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) colors[i][j] = BLACK; // 검정색 체크
			}
		}
		ans = new int[2];
		dfs(-1,0,BLACK); // 검정색 끼리만 간다.
		dfs(-1,0,WHITE); // 흰색 끼리만 간다.
		System.out.println(ans[0]+ans[1]);
	}
	
	static void dfs(int v, int cnt, int color) {
		if(ans[color]<cnt) ans[color]=cnt; // cnt의 최댓값을 찾기 위한 과정
		
		for(int i=v+1; i<N*N; i++) {
			int r = i/N; 
			int c = i%N;
			
			if(colors[r][c] != color) continue;
			
			if(bsPos[r][c]==1 && check(r,c)) {
				isVisited[i] = true;
				dfs(i, cnt+1, color);
			}
		}
		if(v == -1) return;
		isVisited[v] = false;
	}
	
	static boolean check(int row, int col) {
		for(int i=0; i<4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			int v = nextRow*N+nextCol;
			
			for(int j=0; j<N; j++) {
				if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<N) {
					if(isVisited[v]) return false; // 대각선에 이미 비숍이 존재하므로 해당 row,col에서는 비숍이 위치할 수 없다.
				} else break;
				nextRow += dRow[i];
				nextCol += dCol[i];
				v = nextRow*N+nextCol;
			}
		}
		return true;
	}
}
