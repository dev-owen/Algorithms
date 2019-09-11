import java.io.*;
import java.util.*;

public class BOJ_1780 {
	static int ans[] = new int[3];
	static int[][] paperArr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		paperArr = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				paperArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count(1,1,N,N);

		for(int i : ans) {
			System.out.println(i);
		}
	}

	static void count(int startRow, int startCol, int endRow, int endCol) {
		if(startRow == endRow) { // 자른 영역이 1X1 크기
			ans[paperArr[startRow][startCol]+1] += 1;
			return;
		}
		int writeNum = paperArr[startRow][startCol];
		boolean split = false;

		loop:
		for(int i = startRow; i <= endRow; i++) {
			for(int j = startCol; j <= endCol; j++) {
				if(writeNum != paperArr[i][j]) {
					split = true;
					break loop;
				}
			}
		}

		if(split) {
			int n = (endRow-startRow+1)/3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					count(startRow+i*n, startCol+j*n, startRow+(i+1)*n-1, startCol+(j+1)*n-1);
				}
			}
		} else {
			ans[writeNum+1] += 1;
		}
		return;
	}
}
