import java.util.Scanner;

public class BOJ_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(count(N));
	}
	
	public static int count(int n) {
		String arr[] = String.valueOf(n).split("");
		int cnt[] = new int[10];
		for(int i=0; i<arr.length; i++) cnt[Integer.parseInt(arr[i])]++;
		cnt[6] = (int)Math.ceil((cnt[6]+cnt[9])/2.0);
		int max = 0;
		for(int i=0; i<9; i++) max = Math.max(max,cnt[i]);
		return max;
		}
}
