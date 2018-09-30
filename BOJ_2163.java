import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2163 {
	
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N+1][M+1];
			arr[1][1] = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if((i<=j && i!=1)||(j==1 && i>j)) arr[i][j] = arr[i/2][j]+arr[i-(i/2)][j]+1;
					else if((i>j && j!=1)||(i==1 && i<j)) arr[i][j] = arr[i][j/2]+arr[i][j-(j/2)]+1;
					else continue;
				}
			}
			System.out.println(arr[N][M]);
	}
}
