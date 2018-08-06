*
*
*
*
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] befArr = br.readLine().split(" ");
		// 숫자 N을 받아서 N개의 정수 입력
		int[] arr1 = new int[n];
		for(int i=0; i<befArr.length; i++) arr1[i] = Integer.parseInt(befArr[i]);
		// 입력한 정수를 int형 배열 arr1으로 파싱함
		Arrays.sort(arr1);
		// arr1 배열 오름차순 정렬
		int m = Integer.parseInt(br.readLine());
		String[] aftArr = br.readLine().split(" ");
		// 숫자 M을 받아서 M개의 정수 입력
		int[] arr2 = new int[m];
		for(int i=0; i<aftArr.length; i++) arr2[i] = Integer.parseInt(aftArr[i]);
		// 입력한 정수를 int형 배열 arr2로 파싱함
		
		for(int i=0; i<arr2.length; i++) {
			int tf = 0;
			
			int maxIdx = n;
			int minIdx = -1;
			// 배열에서 n번째 숫자는 실제로는 arr[n-1] 으로 표시하기 때문에 min값은 -1
			int midIdx;
			
			while(maxIdx - minIdx >1) {
				midIdx = (maxIdx + minIdx)/2;
				
				if(arr2[i] == arr1[midIdx]) {
					tf = 1;
					break;
				}
				if(arr2[i] > arr1[midIdx]) minIdx = midIdx;
				else if(arr2[i] < arr1[midIdx]) maxIdx = midIdx;
			}
			// 이분 탐색을 이용해서 arr1에 해당 숫자가 있으면 1, 없으면 0을 출력
			System.out.print(tf+" ");		
		}
	}
}
