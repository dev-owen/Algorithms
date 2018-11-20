package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
	static int N, K, ans;
	static String[] wordArray = new String[51];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken())-5;// anta tica에서 최소한 5개의 알파벳을 필요로 하기 때문
		if(K<0) { 
			System.out.println(0);
			return;
		}
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			str = str.replaceAll("a", "");
			str = str.replaceAll("c", "");
			str = str.replaceAll("i", "");
			str = str.replaceAll("n", "");
			str = str.replaceAll("t", "");
			wordArray[i] = str;
		}
		ans = 0;
		study(0,0,0);
		System.out.println(ans);
	}
	// cnt -> 지금까지 배운 알파벳 수, learn -> 현재까지 배운 알파벳들, index -> 알파벳 인덱스화(a = 0, z = 25)
	static void study(int cnt, int learn, int index) {
		if(index > 26) return;
		if(cnt == K) {
			int total = 0;
			for(int i=0; i<N; i++) {
				boolean isOk = true; // 내가 배운 알파벳들로 이 단어를 읽을 수 있는가
				String str = wordArray[i];
				for(int j=0; j<str.length(); j++) {
					int num = str.charAt(j)-'a'; // 알파벳을 인덱스화
					if((learn&(1<<num))>0) continue; // 만약 num이 배운 알파벳이면 true, 안 배웠으면 이 단어는 읽을 수 없으므로 false, break
					isOk = false;
					break;
				}
				if(isOk) ++total; // 읽을 수 있는 단어인 경우 total에 1 추가
			}
			ans = Math.max(total, ans); // ans의 최댓값을 구하기 위한 작업
			return;
		}
		
		if(index=='a'-'a' || index=='c'-'a' || index=='i'-'a' || index=='n'-'a' || index=='t'-'a') {
			study(cnt, learn, index+1);
		} else if(index!='a'-'a' && index!='c'-'a' && index!='i'-'a' && index!='n'-'a' && index!='t'-'a'){
			if(cnt < K) study(cnt+1,(learn|(1<<index)),index+1); // 알파벳을 K개 까지 배울 수 있으므로 cnt에 1추가, learn에도 bitMask를 이용하여 해당 값 추가 
			study(cnt, learn, index+1); 
		}
	}
}
