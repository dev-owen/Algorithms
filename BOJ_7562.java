import java.io.*;
import java.util.*;

public class BOJ_7562 {
	static int len, endRow, endCol;
	static int[][] minReach;
	static boolean[][] visited;
	static int[] dRow = {-2,-1,1,2,2,1,-1,-2};
	static int[] dCol = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T =  Integer.parseInt(st.nextToken());
		while(T-->0) {
			len = Integer.parseInt(br.readLine());
			minReach = new int[len][len];
			visited = new boolean[len][len];
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken()); 
			int startCol = Integer.parseInt(st.nextToken()); 
			st = new StringTokenizer(br.readLine());
			endRow = Integer.parseInt(st.nextToken());
			endCol = Integer.parseInt(st.nextToken());
			PriorityQueue<Knight> pq = new PriorityQueue<>();
			pq.add(new Knight(startRow, startCol, 0));
			while(!pq.isEmpty()) {
				Knight k = pq.poll();
				visited[k.row][k.col] = true;
				if(k.row == endRow && k.col == endCol) {
					minReach[k.row][k.col] = k.cnt;
					break;
				}
				for(int i=0; i<8; i++) {
					int nRow = k.row+dRow[i];
					int nCol = k.col+dCol[i];
					if(nRow>=0 && nRow<len && nCol>=0 && nCol<len) {
						if(!visited[nRow][nCol]) {
							if(minReach[nRow][nCol]==0) {
								minReach[nRow][nCol] = k.cnt+1;
								pq.add(new Knight(nRow, nCol, k.cnt+1));
							} else if(minReach[nRow][nCol] > k.cnt+1) pq.add(new Knight(nRow, nCol, k.cnt+1));
						}
					}
				}
			}
			System.out.println(minReach[endRow][endCol]);
		}
	}
}

class Knight implements Comparable<Knight>{
	int row,col,cnt;
	Knight(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Knight o) {
		if(this.cnt < o.cnt) return -1;
		else if(this.cnt > o.cnt) return 1;
		else return 0;
	}
}

