import java.util.*;

public class BOJ_1201 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		String ans = "";
		// 1. 최대 증가 부분 수열과 최대 부분 감소 수열은 하나의 요소만 공유하기 때문에 N은 (M + K - 1) 이상이여하고
		// 비둘기집 원리에 의해 숫자가 (M * K + 1)개일 때는 최대 증가 부분 수열의 길이는 M + 1, 최대 감소 부분 수열의 길이는 K + 1이 되기 때문에 N은 M * K 이하여야합니다.
		if(N < M+K-1 || N > M*K) {
			System.out.println(-1);
			return;
		} else if(N == K) { // 이 경우 M = 1 은 무조건 성립
			for(int i = K; i > 0; i--) {
				ans += i+" ";
			}
			System.out.println(ans);
			return;
		} else { // N = 7, M = 3, K = 3 -> 3 2 1 / 6 5 4 / 7
			int[] eachGroup = new int[M];
			eachGroup[0] = K;
			int quotient = (N-K)/(M-1); // 몫
			int remainer = (N-K)%(M-1); // 나머지
			for(int i = 1; i < M; i++) {
				if(i <= remainer) eachGroup[i] = quotient+1;
				else eachGroup[i] = quotient;
			}
			int idx = 0, cri = 0;
			for(int i = 0; i < M; i++) {
				cri += eachGroup[i];
				idx = cri;
				ans += idx+" ";
				for(int j = 1; j < eachGroup[i]; j++) {
					ans += (idx-j)+" ";
				}
			}
			System.out.println(ans);
			return;
		}

	}
}
