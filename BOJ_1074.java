import java.util.*;

public class BOJ_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(findNum(N,r,c));
	}

	static int findNum(int n, int row, int col) {
		if(n == 1) {
			return row*2+col;
		}
		int blockSize = (int)Math.pow(2, n - 1);
		if(row < blockSize) {
			if(col < blockSize) {
				return findNum( n - 1, row, col);
			} else {
				return (int)Math.pow(2,2*(n - 1)) + findNum(n - 1, row, col - blockSize);
			}
		} else {
			if (col < Math.pow(2, n - 1)) {
				return (int)Math.pow(2,2*(n - 1))*2 + findNum(n - 1, row - blockSize, col);
			} else {
				return (int)Math.pow(2,2*(n - 1))*3 + findNum(n - 1, row - blockSize, col - blockSize);
			}
		}
	}
}
