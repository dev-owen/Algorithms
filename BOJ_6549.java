import java.util.*;

public class BOJ_6549 {
	static int arr[], n;
	static long maxSize;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			arr = new int[n];
			maxSize = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			calculate(0,n);
			System.out.println(maxSize);
		}
	}

	static void calculate(int start, int end) {
		int minHeight = arr[start];
		int minHeightIdx = start;
		for(int i = start+1; i < end; i++) {
			if(arr[i] < minHeight) {
				minHeight = arr[i];
				minHeightIdx = i;
			}
		}
		maxSize = Math.max(maxSize, (long)minHeight*(end-start));
		if(minHeightIdx > start) calculate(start, minHeightIdx);
		if(minHeightIdx+1 < end) calculate(minHeightIdx+1, end);
	}
}
