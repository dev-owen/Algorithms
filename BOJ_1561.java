import java.util.Scanner;

public class BOJ_1561 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] amusePark = new int[M+1];
		for(int i=1; i<=M; i++) {
			amusePark[i] = sc.nextInt(); // amusePark[1] = 3 => 1번 놀이기구는 한 번 타는데 3
		}

		if(N <= M) {
			System.out.println(N);
			return;
		}
		long start = 0;
		long end = 60000000000L;
		long time = 0;
		long cnt = 0;
		while(start <= end) {
			long mid = (start+end)/2;
			cnt = M;
			for(int i = 1; i <= M; i++) {
				cnt += mid/amusePark[i];
			}

			if(cnt >= N) {
				time = mid; // time(분)에 N번째 학생이 탔음을 알 수 있다.
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		cnt = M;
		for(int i = 1; i <= M; i++) { // time-1(분)까지 탔던 사람 숫자를 먼저 계산
			cnt += (time-1)/amusePark[i];
		}

		for(int i = 1; i <= M; i++) {
			if(time%amusePark[i] == 0) cnt++;
			if(cnt == N) {
				System.out.println(i);
				return;
			}
		}

	}
}
