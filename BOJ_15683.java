import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int N, M, size, result, count;
	static ArrayList<Pos> list;
	static int[] output;
	static int[][] inputs, temps;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new int[N+1][M+1]; 
		temps = new int[N+1][M+1]; // 초기화를 위한 배열
		list = new ArrayList<>();
		count = 0;
		result = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				inputs[i][j] = Integer.parseInt(st.nextToken());
				temps[i][j] = inputs[i][j];
				if(inputs[i][j] != 6 && inputs[i][j] != 0) {
					list.add(new Pos(i,j));
				}
			}
		}
		size = list.size();
		output = new int[size]; // 가능한 모든 조합을 만들어 줌
		
		
		if(size == 0) {
			check();
			result = count;
		}
		else {
			for(int i=0; i<4; i++) {
				output[0] = i+1;
				allCase(i,0);
			}
		}
		System.out.println(result);
	}
	
	// allCase 메서드는 cctv가 감시하는 모든 경우의 수를 만들기 위해서 사용
	public static void allCase(int start, int depth) {
		if(depth == size-1) {
			for(int i=0; i<size; i++) {
				Pos p = list.get(i);
				watch(p, inputs[p.row][p.col], output[i]);
			}
			check();
			result = Math.min(result, count); // 사각지대가 최소일 때 저장
			reset();
			return;
		}
		
		for(int i=0; i<4; i++) {
			output[depth+1] = i+1;
			allCase(i, depth+1);
		}
	}
	
	// watch 메서드는 cctv의 종류와 방향을 따라 감시하는 위치를 정해줌
	public static void watch(Pos p, int num, int dir) {
		if(num == 1) {
			if(dir == 1) move(p,1);
			else if(dir == 2) move(p,2);
			else if(dir == 3) move(p,3);
			else if(dir == 4) move(p,4);
		} else if(num == 2) {
			if(dir == 1 || dir == 3) {
				move(p,1); move(p,3);
			}else if(dir == 2 || dir == 4) {
				move(p,2); move(p,4);
			}
		} else if(num == 3) {
			if(dir == 1) {
				move(p,1);move(p,2);
			}else if(dir == 2) {
				move(p,2);move(p,3);
			}else if(dir == 3) {
				move(p,3);move(p,4);
			}else if(dir == 4) {
				move(p,4);move(p,1);
			}
		} else if(num == 4) {
			if(dir == 1) {
				move(p,1);move(p,2);move(p,3);
			}else if(dir == 2) {
				move(p,2);move(p,3);move(p,4);
			}else if(dir == 3) {
				move(p,3);move(p,4);move(p,1);
			}else if(dir == 4) {
				move(p,4);move(p,1);move(p,2);
			}
		} else if(num == 5) {
			move(p,1);move(p,2);move(p,3);move(p,4);
		}
	}
	
	// move 메서드는 DFS를 통해 한 방향을 감시
	public static void move(Pos p, int dir) {
		int curRow = p.row;
		int curCol = p.col;
		int nextRow = curRow;
		int nextCol = curCol;
		
		if(dir == 1) nextRow = curRow-1;
		else if(dir == 2) nextCol = curCol+1;
		else if(dir == 3) nextRow = curRow+1;
		else if(dir == 4) nextCol = curCol-1;
		
		if(nextRow <= 0 || nextCol <= 0 || nextRow > N || nextCol > M) return;
		if(inputs[nextRow][nextCol] == 6) return;
		if(inputs[nextRow][nextCol] == 0) inputs[nextRow][nextCol] = 1;
		move(new Pos(nextRow, nextCol), dir);
	}
	// 사각지대가 얼마나 있는지 체크
	public static void check() {
		count = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(inputs[i][j] == 0) count++;
			}
		}
	}
	// 2차원 배열 초기화
	public static void reset() {
		count = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				inputs[i][j] = temps[i][j];
			}
		}
	}
}

class Pos {
	int row;
	int col;
	Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}