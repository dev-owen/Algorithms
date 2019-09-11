import java.util.*;

public class BOJ_1717 {
	static int[] parentNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parentNum = new int[n+1]; // n+1개의 집합
		for(int i = 0; i <= n; i++) {
			parentNum[i] = i;
		}
		while(m-->0) {
			int flag = sc.nextInt();
			int setA = sc.nextInt();
			int setB = sc.nextInt();
			if(flag == 0) {
				union(setA, setB);
			} else if(flag == 1) {
				System.out.println(sameParent(setA, setB) ? "YES" : "NO");
			}
		}
	}

	static void union(int a, int b) { // a와 b를 연결
		a = findParent(a);
		b = findParent(b);

		if(a > b) {
			parentNum[a] = b;
		} else if(b > a) {
			parentNum[b] = a;
		}
	}

	static int findParent(int x) { // 부모를 반환하는 메소드
		if(x == parentNum[x]) return x;
		else return parentNum[x] = findParent(parentNum[x]);
	}

	static boolean sameParent(int a, int b) {
		if(findParent(a) == findParent(b)) return true;
		else return false;
	}
}
