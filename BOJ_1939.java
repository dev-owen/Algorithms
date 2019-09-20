import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1939 {

	static boolean check(List<Weight>[] a, int limit, int start, int end, boolean [] b) {
		if(b[start])
			return false;
		b[start] = true;
		if(start == end)
			return true;
		for(Weight v : a[start]) {
			if(v.g >= limit) {  //입력받은 중량으로 이동할 수 있는지 체크
				//return check(a, limit, v.v, end, b)
				//이렇게 하면 check가 false 한번이라도 되면 for문이 끝나버린다.
				if(check(a, limit, v.v, end, b)){ //if문으로 해야 for문이 끝나지 않고 계속 돈다.
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Weight> [] a = (List<Weight> []) new ArrayList[n+1];

		for(int i=1; i<=n; i++)
			a[i] = new ArrayList<>();

		int max = 0;
		for(int i=0; i<m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int g = sc.nextInt();
			a[v1].add(new Weight(v2, g)); // a 리스트의 각각의 인덱스에서 뻗을 수 있는 다리들을 모두 Weight 클래스를 이용해서 집어넣음
			a[v2].add(new Weight(v1, g));
			max = Math.max(g, max);
		}
		int tx = sc.nextInt(); // tx에서 출발, ty에서 도착
		int ty = sc.nextInt();



		int start = 1;
		int end = max;
		int ans = 0;
		while(start<=end) {
			boolean []b = new boolean[n+1];
			int mid = (start+end)/2;
			if(check(a, mid, tx, ty, b)) {
				start = mid+1;
				ans = Math.max(ans, mid);
			}
			else
				end = mid-1;
		}
		System.out.println(ans);
	}

}
class Weight{ // v와 연결된 다리의 중량제한 g
	int v;
	int g;

	public Weight(int v, int g) {
		this.v = v;
		this.g = g;
	}
}