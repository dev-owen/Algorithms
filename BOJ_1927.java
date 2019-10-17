import java.util.*;

public class BOJ_1927 {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		//우선순위큐를 이용하면 가장 높은 우선순위(가장 작은 수) 순서대로 출력 가능하다.
		PriorityQueue<Integer> q= new PriorityQueue<>();
		int n=sc.nextInt();
		while(n-- > 0){
			int x=sc.nextInt();
			if(x==0){
				if(q.isEmpty())
					System.out.println(0);
				else    //가장 앞의 값 출력
					System.out.println(q.poll());
			}
			else
				q.offer(x);
		}
	}
}
