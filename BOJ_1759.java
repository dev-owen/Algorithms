import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L,C;
	static char[] key;
	static boolean[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		key = new char[C];
		result = new boolean[C];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			key[i] = str[i].charAt(0);
		}
		Arrays.sort(key);
		DFS(0,0,0,0);
	}
	
	static void DFS(int start, int length, int con, int vow) {
		for(int i = start; i<C; i++) {
			result[i] = true; // i번째 문자를 선택함
			DFS(i+1, length+1, con+(isVow(key[i]) ? 0 : 1), vow+(isVow(key[i]) ? 1 : 0));
			result[i] = false; // 초기화 해줌
		}
		
		if( length == L && con >=2 && vow >=1) {
			for(int i = 0; i < C; i++) {
				if(result[i]) System.out.print(key[i]);
			}
			System.out.println("");
		}
	}
	
	static boolean isVow(char  c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		else return false;
	}
}
