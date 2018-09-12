import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R,C;
	static char[][] board;
	static int passing;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R+2][C+2];
		for(int i=1; i<=R; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=1; j<=C; j++) {
				board[i][j] = chars[j-1];
			}
		}			
		passing = 1;
		DFS(1,1,1, visited);
		System.out.println(passing);
	}
	static void DFS(int x, int y, int pass, boolean[] visited) {
		visited[(int)(board[x][y]-'A')] = true;
		for(int i=0; i<4; i++) {
			int nX = x+dx[i];
			int nY = y+dy[i];
			if(nX>= 1 && nX <= R && nY >= 1 && nY <= C && !visited[(int)(board[nX][nY]-'A')]) { 
				passing = Math.max(pass+1, passing);
				DFS(nX, nY, pass+1, visited);
			} 
		}
        visited[(int)(board[x][y]-'A')] = false;
	}
}