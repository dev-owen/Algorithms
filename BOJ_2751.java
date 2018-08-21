import java.util.Scanner;

public class QuickSort {
	
	public static int partition(int arr[], int left, int right) {
		int pivot=arr[(left+right)/2];
		
		while(left<right) {
			while((arr[left]<pivot) && (left<right))
				left++;
			while((arr[right]>pivot) && (left < right))
				right--;
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		return left;
	}
	
	public static void quickSort(int arr[], int left, int right) {
		if(left < right) {
			int pivotNewIndex = partition(arr, left, right);
			
			quickSort(arr, left, pivotNewIndex-1);
			quickSort(arr, pivotNewIndex+1, right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(arr[0]);
		for(int i=1; i<num; i++) {
			if(arr[i] == arr[i-1]) {}
			else System.out.println(arr[i]);
		}
	}
}
