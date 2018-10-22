import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1946 {
	static int T,N,result;
	static int[] array;
	static boolean[] pass;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T= Integer.parseInt(st.nextToken());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			array = new int[N+1];
			pass = new boolean[N+1];
			while(N-->0) {
				st = new StringTokenizer(br.readLine());
				int seo = Integer.parseInt(st.nextToken());
				int meon = Integer.parseInt(st.nextToken());
				array[seo] = meon;
			}
			for(int i=1; i<=array.length-1; i++) {
				if(i==1) pass[i] = true;
				else {
					int tmp = array[i];
					pass[i] = true;
					for(int j=1; j<i; j++) {
						if(array[j] < array[i] && pass[j]) {
							pass[i] = false;
							break;
						}
					}
				}
			}
			result = 0;
			for(boolean a:pass) {
				if(a) ++result;
			}
			System.out.println(result);
		}
	}
}

