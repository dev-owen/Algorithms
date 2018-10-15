import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042 {
	static int N,Query;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Query = Integer.parseInt(st.nextToken());
		Query += Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		SegTree segTree = new SegTree(arr,N);
		
		while(Query-->0) {
			st = new StringTokenizer(br.readLine());
			int queryType = Integer.parseInt(st.nextToken());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			if(queryType == 1) segTree.update(idx1-1,idx2,1,0,N-1);
			else if(queryType == 2) System.out.print(segTree.query(idx1-1,idx2-1,1,0,N-1)+" ");
		}
	}
}

class SegTree {
	long[] segArr;
	
	SegTree(int[] arr, int n) {
		int x = (int) Math.ceil(Math.log(n)/Math.log(2));
		int segSize = (int) Math.pow(2, x)*2;
		segArr = new long[segSize];
		init(arr, 0, n-1, 1);
	}
	// 트리 초기화
	long init(int[] arr, int left, int right, int node) {
		if(left == right) return segArr[node] = arr[left];
		int mid = (left+right)/2;
		return segArr[node] = init(arr, left, mid, node*2)+init(arr, mid+1, right, node*2+1);
	}
	// 구간 합
	long query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(left > nodeRight || right < nodeLeft) return 0;
		if(left <= nodeLeft && right >= nodeRight) return segArr[node];
		
		int mid = (nodeLeft+nodeRight)/2;
		return query(left, right, node*2, nodeLeft, mid)+query(left, right, (node*2)+1, mid+1, nodeRight);
	}
	// 값 갱신
	long update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
		if(index < nodeLeft || index > nodeRight) return segArr[node];
		if(nodeLeft == nodeRight) return segArr[node] = newValue;
		int mid = (nodeLeft+nodeRight)/2;
		return segArr[node] = update(index, newValue, node*2, nodeLeft, mid)+update(index, newValue, (node*2)+1, mid+1, nodeRight);
	}	
}
