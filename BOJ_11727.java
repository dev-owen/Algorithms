import java.util.Scanner;

public class BOJ_11727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1; i<N+1; i++) {
			if(i==1) {
				arr[i] = 1;
			} else if(i ==2) { 
				arr[i] = 3;
			} else {
				arr[i] = (2*arr[i-2]+arr[i-1])%10007;				
			}
		}
		System.out.println(arr[N]);	
	}
}