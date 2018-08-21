import java.io.*;
import java.util.LinkedList;

public class Finding {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int pi[];
	/* str은 첫째 줄 문자열 T
	 * pattern은 둘째 줄 문자열 P
	 */
	private static String str, pattern;
	static {
		try {
			str = br.readLine();
			pattern = br.readLine();
		} catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		// 1. pattern(문자열 P)에 pi 배열값을 initPi() 메소드를 통해 만들어 줌
		initPi(pattern);
		/* 2. KMP() 메소드를 통해 str(문자열 T)에 pattern이 얼마나 있는지
		 * KMP 알고리즘을 이용하여 찾고 그 위치 값을 LinkedList list에 저장함.
		 */
		LinkedList<Integer> list = KMP(pattern);
		// 3. 몇 개의 P가 T에서 찾아졌는지, 그리고 그 위치값을 list에서 출력
		System.out.println(list.size());
		for(int temp : list) {
			System.out.println(temp);
		}	
	}
	
	private static void initPi(String str) {
		/* pi[i]는 문자열 T의 0~i까지 부분 문자열에 대해 
		 * prefix == suffix가 가장 긴 것의 길이로 한다.
		 * ex. T가 ABCDAB인 경우 pi[4] = 1 pi[5] = 2
		*/
		char[] temp = str.toCharArray();
		pi = new int[temp.length];
		int j=0;
		for(int i=1; i<temp.length; i++) {
			while (j > 0 && temp[i] != temp[j]) {
				j = pi[j-1];
			}
			if(temp[i] == temp[j]) {
				pi[i] = ++j;
			}
		}
	}
	
	private static LinkedList<Integer> KMP(String s) {
		LinkedList<Integer> list = new LinkedList<>();
		int j = 0;
		char A[] = str.toCharArray(), B[] = s.toCharArray();
		for(int i=0, length = str.length(); i<length; i++) {
			while (j>0 && A[i] != B[j]) {
				j = pi[j-1];
			}
			if (A[i] == B[j]) {
				if(j == B.length-1) {
					j=pi[j];
					list.add(i-B.length+2);
				} else {
					j++;
				}
			}
		}
		return list;
	}
}
