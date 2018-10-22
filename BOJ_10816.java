import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[20000001];
		st = new StringTokenizer(br.readLine());
		while(M-->0) {
			// -10000000~10000000의 숫자가 입력될 수 있기 때문에 
			// 입력값에 10000000을 더해주면 0~20000000 사이의 값으로 배열 index를 설정해 줄 수 있음.
			++array[Integer.parseInt(st.nextToken())+10000000];
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(N-->0) {
			System.out.print(array[Integer.parseInt(st.nextToken())+10000000]+" ");
		}
	}

}
