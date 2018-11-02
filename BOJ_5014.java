import java.io.*;
import java.util.*;

public class BOJ_5014 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		q.add(S);
		boolean checked[] = new boolean[F+1];
		while(!q.isEmpty()) {
			int floor = q.poll();
			checked[floor] = true;
			if(floor == G) {
				System.out.println(cnt);
				return;
			} else if(floor < G) {
				if(floor+U <= G) {
					if(!checked[floor+U]) {
						q.add(floor+U);
						cnt++;						
					} else break;
				} else {
					if((G-floor)%(Math.abs(U-D))==0 || (Math.abs(U-D))%(G-floor)==0) {
						if(floor-D >0 && !checked[floor-D]) {
							q.add(floor-D);
							cnt++;							
						} else break;
					} else break;
				}
			} else {
				if(floor-D >= G && floor-D <= F) {
					if(!checked[floor-D]) {
						q.add(floor-D);
						cnt++;						
					} else break;
				} else {
					if((floor-G)%(Math.abs(U-D))==0 || (Math.abs(U-D))%(floor-G)==0) {
						if(floor+U <=F && !checked[floor+U]) {
							q.add(floor+U);
							cnt++;							
						} else break;
					} else break;
				}
			}
		}
		System.out.println("use the stairs");
	}
}
