package _180731;

public class Solution {
	public int solution(int[] arr) {
		int answer = 0;		
			answer = arr[0];
			for(int i=0; i<arr.length; i++) {
				answer *= arr[i]/gcd(answer, arr[i]);
		}	
		return answer;
	}

	public int gcd(int a3, int a4) {
		if(a3 >= a4) {
			if(a3%a4 == 0) return a4;
			else return gcd(a3%a4, a4);
		} else {
			if(a4%a3 == 0) return a3;
			else return gcd(a4%a3, a3); 
		}
	}
	
	public static void main(String[] args) {
		Solution sc = new Solution();
		int arr1[] = {2,6,8,14};
		int arr2[] = {1,2,3};
		System.out.println(sc.solution(arr1));
		System.out.println(sc.solution(arr2));
	}
}
