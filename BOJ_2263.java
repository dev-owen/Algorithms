import java.util.Scanner;

public class BOJ_2263 {

	static int[] inOrder = new int[100000];
	static int[] postOrder = new int[100000];
	static int[] inOrdPos = new int[100001]; // inOrder에서 몇 번 Node가 몇 번째 배열에 있는지 알려주는 정보
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			inOrder[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			postOrder[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			inOrdPos[inOrder[i]] = i;
		}

		solve(0, n-1, 0, n-1);
	}

	static void solve(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) return;
		int root = postOrder[post_end];
		System.out.print(root+" ");
		int in_root = inOrdPos[root];
		int left = in_root-in_start;
		solve(in_start,in_root-1, post_start, post_start+left-1);
		solve(in_root+1, in_end, post_start+left, post_end-1);
	}
}
