import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9933 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N]; 
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		for(int i =0; i<N; i++) {
			for(int j=i; j<N; j++) {
				if(arr[i].length() == arr[j].length()) {
					boolean isOk = true;
					for(int k=0; k<arr[i].length()/2 +1; k++) {
						if(arr[i].charAt(k) != arr[j].charAt(arr[j].length()-k-1)) {
							isOk =false; 
							break;
						}
					}
					if(isOk) {
						System.out.println(arr[i].length()+" "+arr[i].charAt(arr[i].length()/2));
						return;
					}
				}
			}
		}
	}
}
