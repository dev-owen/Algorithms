import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int N,M, startPosVer, startPosHor, startDir, count;
	static int[][] area;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		st = new StringTokenizer(br.readLine());
		startPosVer = Integer.parseInt(st.nextToken());
		startPosHor = Integer.parseInt(st.nextToken());
		startDir = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				area[i][j] = Integer.parseInt(str[j]);
			}
		}
		count = 0;
		go(startPosVer, startPosHor, startDir);
	}
	
	static void go(int posVer, int posHor, int dir) {
		boolean[] checked = new boolean[4];
		if(area[posVer][posHor] == 0) {
			area[posVer][posHor] = 2; // 0 : 청소 X, 1 : 벽, 2: 청소 : O
			count++;			
		}
		int checkDir =dir;
		while(true) {
			if(checkDir == 0) {
				if(!checked[3] && area[posVer][posHor-1] == 0) {
					go(posVer,posHor-1,3);
					return;
				} else {
					checked[3] = true;
					checkDir = 3;
				}
			}
			if(checkDir == 3) {
				if(!checked[2] && area[posVer+1][posHor] == 0) {
					go(posVer+1,posHor,2);
					return;
				} else {
					checked[2] = true;
					checkDir = 2;
				}
			}
			if(checkDir == 2) {
				 if(!checked[1] && area[posVer][posHor+1] == 0) {
					 go(posVer,posHor+1,1);
					 return;
				 } else {
					 checked[1] = true;
					 checkDir = 1;
				 }
			}
			if(checkDir == 1) {
				if(!checked[0]&& area[posVer-1][posHor] == 0) {
					go(posVer-1,posHor,0);
					return;
				} else {
					checked[0] = true;
					checkDir = 0;
				}
			}
			if(checked[0]&&checked[1]&&checked[2]&&checked[3]) break;
		}
		if(dir == 0 && area[posVer+1][posHor] != 1) {
			go(posVer+1,posHor,0);
			return;
		}
		if(dir == 3 && area[posVer][posHor+1] != 1) {
			go(posVer,posHor+1,3);
			return;
		}
		if(dir == 2 && area[posVer-1][posHor] != 1) {
			go(posVer-1,posHor,2);
			return;
		}
		if(dir == 1 && area[posVer][posHor-1] != 1) {
			go(posVer,posHor-1,1);
			return;
		}
		System.out.println(count);
	}
}