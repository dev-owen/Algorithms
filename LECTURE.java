// RTE (nonzero return code)

import java.util.Scanner;

public class LECTURE {
	
	public static String sorting(String str) {
		String ans = "";
		String[] arr = new String[str.length()/2];
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.substring(2*i, 2*i+2);
		}
		
		boolean swapped = true;
		int j = 0;
		String tmp;
		while(swapped) {
			swapped = false;
			j++;
			for(int i=0; i<arr.length-j;i++) {
				if(arr[i].compareTo(arr[i+1]) >0) {
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					swapped = true;
				}
			}
		}
		for(int i=0; i<arr.length-1;i++) {
			ans += arr[i];
		}
		ans += arr[arr.length-1];
		return ans;
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Scanner sc2 = new Scanner(System.in);
		String[] lec = new String[T];
		
		for(int i=0; i<T; i++) {
			String str = sc2.nextLine();
			lec[i] = sorting(str);
		}
		for(int i=0; i<T; i++) {
			System.out.println(lec[i]);
		}
	
	}

}
