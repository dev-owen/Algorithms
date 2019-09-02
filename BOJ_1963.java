import java.util.*;

public class BOJ_1963 {

	static Queue<Integer> q;
	static int change[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int firstPrime = sc.nextInt();
			int secondPrime = sc.nextInt();
			q = new LinkedList<>();
			change = new int[10000];
			int ans = changeTimes(firstPrime, secondPrime);
			System.out.println(ans == -1 ? "Impossible" : ans-1);
		}
	}

	static int changeTimes(int first, int second) {
		q.add(first);
		change[first] = 1;
		while(!q.isEmpty()) {
			int num = q.poll();
			if(num == second) return change[num];
			String str = String.valueOf(num); // "1234"
			for(int i = 0; i <= 3; i++) {
				for(int j = 0; j <= 9; j++) {
					String tmp = str.substring(0, i) + j + str.substring(i+1, 4);
					int newNum = Integer.parseInt(tmp);
					if(isPrime(newNum) && change[newNum] == 0 && newNum >= 1000) {
						q.add(newNum);
						change[newNum] = change[num]+1;
					}
				}
			}
		}
		return -1;
	}

	static boolean isPrime(int num) {
		for(int i = 2; i*i <= num; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
