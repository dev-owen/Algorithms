import java.util.Scanner;

public class BOJ_9663 {
	static int N, resNum;
	static int cols[]; // i행에 들어가있는 Queen의 열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cols = new int[N+1];
		resNum = 0;
		for(int i=1; i<=N; i++) {
			cols[1] = i;
			DFS(1);
		}
		System.out.println(resNum);
	}
	
	static void DFS(int row) {
		if(row == N) {
			++resNum;
			return;
		} else {
			for(int i=1; i<=N; i++) {
				cols[row+1] = i;
				if(isPossible(row+1)) DFS(row+1);
				else cols[row+1] =0;
			}			
		}
	}
	
	static boolean isPossible(int row) {
		for(int i=1; i< row; i++) {
			if(cols[row] == cols[i]) return false; // 가로 세로 퀸이 있는지
			if(Math.abs(cols[row]-cols[i])==Math.abs(row-i)) return false; // 대각선에 퀸이 있는지
		}
		return true;
	}
}