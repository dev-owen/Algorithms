import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
	static int N, res;
	static int[][] forest, lives;
	final static int[] dRow = {0,1,0,-1};
	final static int[] dCol = {1,0,-1,0};	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		forest = new int[N+2][N+2];
		lives = new int[N+2][N+2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				res = Math.max(DFS(i,j), res);
			}
		}
		System.out.println(res);
	}
	
	static int DFS(int i, int j) {
		if(lives[i][j] != 0) return lives[i][j];		
		int day = 1;
		for(int k=0; k<4; k++) {
			int nextRow = i + dRow[k];
			int nextCol = j + dCol[k];
			
			if((nextRow>0 && nextRow<=N)&&(nextCol>0 && nextCol<=N)) {
				if(forest[nextRow][nextCol]>forest[i][j]) {
					day = Math.max(day, DFS(nextRow,nextCol)+1);
					lives[i][j] = day;
				}
			}
		}
		return day;
	}
}
