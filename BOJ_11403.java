import java.util.Scanner;
 
public class BOJ_11403 {
	// N개의 줄, 입력값 행렬 adMatrix, 출력값 행렬 result
	static int N;
	static int[][] adMatrix;
	static int[][] result;
   
	/*
	 *  x번째 점에서 1~N번째 모든 점을 갈 수 있는지 없는지 체크하는 메서드 DFS
	 *  1번 입력 예제 기준 설명하면 입력 값이 1->2, 2->3, 3->1 의 경로가 존재한다고 하였으므로
	 *  DFS(1,visit,true) 에서 1->2 경로를 통해 DFS(2,visit,false) 재귀호출, 그리고 여기에서도
	 *  2->3 경로가 존재한다고 하였으므로 DFS(3,visit,false) 재귀호출.
	 */
	static void DFS(int x, int[] visit, boolean isFirst) {
		if(!isFirst) { //isFirst가 false일 경우
			visit[x]=1;
		}
		for(int i=1; i<=N; i++) {
			/*
			 * x번째 점에서 i번째 점까지 갈 수 있는 길이 있고
			 * 아직 해당 경로를 result 배열에 1을 입력 하지 못했으면
			 * isFirst 값을 false로 줌으로서 재귀를 통해 result[x][i]=1 값을 저장
			 */
			if(adMatrix[x][i]==1 && visit[i]==0) {
				DFS(i, visit, false);
			}
		}
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/* 
		 * N 값 입력, 및 행렬 크기 설정
		 * 혼란 방지 위해 첫째 행, 첫째 열은 adMatrix[1][1]
		 * 따라서 adMatrix[N][N]까지 존재하며
		 * 배열의 크기를 각각 N+1으로 주었음
		 * result 배열의 경우 모든 항은 0으로 자동으로 초기화 되어 있음.
		 */
		N = sc.nextInt();
		adMatrix = new int[N+1][N+1];
		result = new int[N+1][N+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				adMatrix[i][j] = sc.nextInt();
			}
		}
	
		for(int i=1; i<=N; i++) {
			/* 
			 * visit 배열의 경우 하나의 행에서 1번째 점부터 N번째 점까지
			 * 갈 수 있는지 없는지를 0,1 값으로 담은 배열
			 * 예를 들어 i=3 일 때 visit[6]=1 이면
			 * 3번 점에서 6번 점으로 갈 수 있는 경로가 있다는 의미
			 */
			int[] visit = new int[N+1];
			DFS(i, visit, true);
			result[i] = visit;
		}
		//결과값 출력
		for(int i=1; i<result.length; i++) {
			for(int j=1; j<result.length; j++) {
				System.out.print(result[i][j]+" ");
			}
			if(i != result.length-1) {
				System.out.println();
			}
		}
	}   
}