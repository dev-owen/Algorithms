package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1371 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] freq = new int[26];
		int max = 0; 
		String str;
		while((str = br.readLine()) != null) {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != ' ') {
					freq[(int)(str.charAt(i)-'a')]++; 
					if(max < freq[(int)(str.charAt(i)-'a')]) max = freq[(int)(str.charAt(i)-'a')];				
				}
			}
		}
		for(int i=0; i<26; i++) {
			if(freq[i]==max) System.out.print((char)(i+'a'));
		}
	}
}
