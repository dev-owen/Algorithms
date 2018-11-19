import java.util.Scanner;

public class BOJ_11057 {
	static int arr[][];
	static int arr2[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[1001][10];
		arr2 = new int[1001];
		dp(N);
		System.out.println(arr2[N]);
	}
	static void dp(int n) {
		for(int j=0; j<10; j++) {
			arr[1][j] = 1;
		}
		arr2[1] = 10;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<=j; k++) {
					arr[i][j] += arr[i-1][k];
				}
				arr[i][j] = arr[i][j]%10007;
				arr2[i] += arr[i][j]; 
			}
			arr2[i] = arr2[i]%10007;
		}
	}
}
