import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1722 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = sc.nextInt();
		if(num == 1) {
			long k = sc.nextLong()-1;
			LinkedList<Integer> list = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			long tmp, f, sum = 0;
			int i, j;
			for(i = 1; i <= N; i++) {
				list.add(i);
			}

			for(i = 1 ; i < N; i++) {
				for(f = factorial(N-i), j = 0;;j++) {
					if((tmp = sum + j*f) >= k) { // i번째 자리에 (j-1)가 들어갈 수 있는 경우
						if(tmp > k) {
							tmp -= f; j--;
						}
						sb.append(list.remove(j)+" "); // 앞자리부터 한 글자씩 채워준다.
						sum = tmp;
						break;
					}
				}
			}
			while(!list.isEmpty()) {
				sb.append(list.poll()+" ");
			}

			System.out.println(sb.toString().trim());
			return;

		} else if(num == 2) {
			int i,j;
			long f, sum = 0;
			int[] arr = new int[N];
			for(i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			LinkedList<Integer> list = new LinkedList<>();
			for(i = 1; i <= N; i++) list.add(i);

			for(i = 0; i < N; i++) {
				f = factorial(N-i-1);
				j = list.indexOf(arr[i]);
				list.remove(j);
				sum += j*f;
			}

			System.out.println((sum+1)+"");

		}
	}

	static long factorial(int n) {
		if(n <= 1) return 1;
		else return n*factorial(n-1);
	}
}
