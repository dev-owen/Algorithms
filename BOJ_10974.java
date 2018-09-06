import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10974 {
	static int N;
	static int[] arr;
	static String res;
	static ArrayList<String> rst = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) arr[i] =i+1;
		
		perm(arr,0,"");
		Collections.sort(rst);
		for(String a: rst) System.out.println(a);
	}
	
	public static void perm(int[] arr, int depth, String res) {
		String tempRst = res;
		if(depth == N) {
			rst.add(res.trim());
		}
		for(int i=depth; i<N; i++) {
			swap(arr, depth, i);
			tempRst = res + " " +String.valueOf(arr[depth]);
			perm(arr, depth+1, tempRst);
			swap(arr, depth, i);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
