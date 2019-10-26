import java.util.Scanner;

public class BOJ_1992 {

	static boolean[][] imageArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		imageArr = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String[] tmp = sc.next().split("");
			for(int j = 0; j < N; j++) {
				imageArr[i][j] = tmp[j].equals("1") ? true : false;
			}
		}
		System.out.println(divide(N, 0, 0));
	}

	static String divide(int n, int rowIdx, int colIdx) {
		if(check(n, rowIdx, colIdx)) {
			return imageArr[rowIdx][colIdx] ? "1" : "0";
		} else {
			String str = "(";
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					str += divide(n/2, rowIdx+(n/2)*i, colIdx+(n/2)*j);
				}
			}
			str += ")";
			return str;
		}
	}

	static boolean check(int n, int rowIdx, int colIdx) {
		if(n == 1) return true;
		else {
			boolean criteria = imageArr[rowIdx][colIdx];
			for(int i = rowIdx; i < rowIdx+n; i++) {
				for(int j = colIdx; j < colIdx+n; j++) {
					if(imageArr[i][j] != criteria) return false;
				}
			}
			return true;
		}
	}

}
