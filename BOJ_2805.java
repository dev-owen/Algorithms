import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
	static int N,M,H;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		String[] str = br.readLine().split(" ");
		tree = new int[N];
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(tree);
		bw.write(bs(0, 2000000000)+" ");
		bw.close();
		br.close();
	}
	
	static long bs(long low, long high) {
		while(low<=high) {
			long mid = (low+high)/2;
			if (M > treeLen(mid)) high = mid-1;
			else low = mid+1;
			} 
		return high;
	}
	
	// 절단기의 높이가 height일 때 잘려지는 나무의 길이
	static long treeLen(long height) {
		long sum = 0;
		for(int i=0; i<tree.length; i++) {
			if(tree[i] > height) sum += tree[i]-height;
		}
		return sum;
	}
}
