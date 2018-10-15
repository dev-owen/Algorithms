import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
	static int N,L,count;
	static int[][] heights;
	static boolean[][] occupiedRow;
	static boolean[][] occupiedCol;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		heights = new int[N+1][N+1]; // i번째 row, j번째 column의 높이는 heights[i][j]
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		occupiedRow = new boolean[N+1][N+1];
		occupiedCol = new boolean[N+1][N+1];
		for(int i=1; i<=N; i++) {
			row(i); // i번 row로 이루어진 길이 지나갈 수 있으면 count++
			col(i); // i번 col로 이루어진 길이 지나갈 수 있으면 count++
		}
		System.out.println(count); 
	}
	
	static void row(int i) {
		for(int j=1; j<N; j++) {
			if(heights[i][j] < heights[i][j+1]) {
				if(j<L) return;
				for(int k=1; k<=L; k++) {
					if(heights[i][j-L+1] != heights[i][j-L+k] || occupiedRow[i][j-L+k]) return;
				}
				if(heights[i][j-L+1]+1 != heights[i][j+1]) return;
				for(int k=1; k<=L; k++) {
					occupiedRow[i][j-L+k] = true;
				}
			} else if(heights[i][j] > heights[i][j+1]) {
				if(j>N-L) return;
				for(int k=1; k<=L; k++) {
					if(heights[i][j+1] != heights[i][j+k] || occupiedRow[i][j+k]) return;
				}
				if(heights[i][j]-1 != heights[i][j+L]) return;
				for(int k=1; k<=L; k++) {
					occupiedRow[i][j+k] = true;
				}
			}
		}
		++count;
	}
	
	static void col(int i) {
		for(int j=1; j<N; j++) {
			if(heights[j][i] < heights[j+1][i]) {
				if(j<L) return;
				for(int k=1; k<=L; k++) {
					if(heights[j-L+1][i] != heights[j-L+k][i] || occupiedCol[j-L+k][i]) return;
				}
				if(heights[j-L+1][i]+1 != heights[j+1][i]) return;
				for(int k=1; k<=L; k++) {
					occupiedCol[j-L+k][i] = true;
				}
			} else if(heights[j][i] > heights[j+1][i]) {
				if(j>N-L) return;
				for(int k=1; k<=L; k++) {
					if(heights[j+1][i] != heights[j+k][i] || occupiedCol[j+k][i]) return;
				}
				if(heights[j][i]-1 != heights[j+L][i]) return;
				for(int k=1; k<=L; k++) {
					occupiedCol[j+k][i] = true;
				}
			}
		}
		++count;
	}
}
