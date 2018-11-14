import java.util.Scanner;

public class BOJ_2193 {
	static long arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new long[91][2];
		arr[1][0]=0;arr[2][1]=0;
		arr[1][1]=1;arr[2][0]=1;
		System.out.println(lee(N));
	}
	
	static long lee(int n) {
		if(n==1 || n==2) {
			return 1;
		} else {
			for(int i=2; i<=n; i++) {
				arr[i][0] = arr[i-1][1]+arr[i-1][0];
				arr[i][1] = arr[i-1][0];
			}
			return arr[n][0]+arr[n][1];
		}
	}
}
