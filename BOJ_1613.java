import java.io.*;
import java.util.*;

public class BOJ_1613 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			map[first][next] = -1;
			map[next][first] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int row=1; row<=n; row++) {
				for(int col=1; col<=n; col++) {
					if(map[row][i] !=0 && map[row][i] == map[i][col]) {
						map[row][col] = map[row][i];
					}
				}
			}
		}
		int s = Integer.parseInt(br.readLine());
		while(s-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(map[a][b]);
		}
	}
}

