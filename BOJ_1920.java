*
*
*
*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		String[] befArr = br.readLine().split(" ");
		int[] arr1 = new int[num1];
		
		for(int i=0; i<befArr.length; i++) arr1[i] = Integer.parseInt(befArr[i]);
		
		Arrays.sort(arr1);
		
		int num2 = Integer.parseInt(br.readLine());
		String[] aftArr = br.readLine().split(" ");
		int[] arr2 = new int[num2];

		for(int i=0; i<aftArr.length; i++) arr2[i] = Integer.parseInt(aftArr[i]);
			
		for(int i=0; i<arr2.length; i++) {
			int flag = 0;
			
			int maxIdx = num1;
			int minIdx = -1;
			int midIdx;
			
			while(maxIdx - minIdx >1) {
				midIdx = (maxIdx+minIdx)/2;
				
				if(arr2[i] == arr1[midIdx]) {
					flag = 1;
					break;
				}
				if(arr2[i] > arr1[midIdx]) {
					minIdx = midIdx;
				} else if(arr2[i] < arr1[midIdx]) {
					maxIdx = midIdx;
				}
			}
			
			System.out.println(flag);
		}
	}
}
