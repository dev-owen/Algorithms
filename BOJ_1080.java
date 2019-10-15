import java.util.Scanner;

public class BOJ_1080 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int[][] first = new int[row][col];
		int[][] second = new int[row][col];
		boolean[][] chkArr = new boolean[row][col]; // 서로 같으면 true, 다르면 false
		for(int i = 0; i < row; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j < col; j++) {
				first[i][j] = Integer.parseInt(str[j]);
			}
		}
		for(int i = 0; i < row; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j < col; j++) {
				second[i][j] = Integer.parseInt(str[j]);
				if(first[i][j] == second[i][j]) chkArr[i][j] = true;
			}
		}
		int cnt = 0;
		// (0,0)부터 (row-3,col-3)까지 탐색
		for(int i = 0; i <= row-3; i++) {
			for(int j = 0; j <= col-3; j++) {
				if(!chkArr[i][j]) {
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {
							chkArr[i+m][j+n] = !chkArr[i+m][j+n];
						}
					}
					cnt++;
				}
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!chkArr[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
	}
}
