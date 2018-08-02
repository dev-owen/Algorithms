import java.util.Scanner;

public class CountingSort {
	
	public static void sort(int arr[])
	{
		int n = arr.length;

		// 결과 배열 output, 배열 길이는 arr과 같음
		int output[] = new int[n];

		// arr 배열의 원소를 숫자별로 세어줄 count 배열
		int count[] = new int[10000];
		for (int i=0; i<10000; ++i) count[i] = 0;

		// 각각의 arr 원소 숫자를 카운트 배열에 넣음
		for (int i=0; i<n; ++i) ++count[arr[i]];

		// count[i]가 output 배열의 실제 숫자 위치를 가지게 하기 위해 배열 변화
		for (int i=1; i<=9999; ++i) count[i] += count[i-1];

		// output 배열을 설계
		for (int i = 0; i<n; ++i)
		{
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}

		for (int i = 0; i<n; ++i)
			arr[i] = output[i];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) arr[i] = sc.nextInt();	
		sort(arr);
		for(int i=0; i<num; i++) System.out.println(arr[i]);
	}
}
