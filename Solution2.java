package _180731;

public class sol {
	
	static long dp[] = new long[60000];
	public static int solution(int n) {
	    dp[0]=1;
	    dp[1]=2; 
	    for(int i=2; i<n; i++) {
	    	dp[i] = dp[i-2]+dp[i-1];
	    	if(dp[i]>=1000000007) dp[i] %= 1000000007;
	    }
	      
	      return (int) dp[n-1];
	  }
	
	public static void main(String[] args) {
		
		System.out.println("solution(4) : "+solution(4));
		System.out.println("solution(10) : "+solution(10));
		System.out.println("solution(20) : "+solution(20));
		System.out.println("solution(30) : "+solution(30));

	}

}
