package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {
	static int N, K, L; 
	static boolean apple[][], board[][];
	static int[] dRow = {0,-1,0,1};
	static int[] dCol = {1,0,-1,0};
	static Queue<DirChange> q = new LinkedList<>();
	static Queue<Point> snakeBody = new LinkedList<>();
	static DirChange nextChange;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apple = new boolean[N+1][N+1]; // 사과가 있는 좌표 => true
		board = new boolean[N+1][N+1]; // 현재 뱀이 있는 좌표는 전부 => true
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int appRow = Integer.parseInt(st.nextToken());
			int appCol = Integer.parseInt(st.nextToken());
			apple[appRow][appCol] = true;
		}
		L = Integer.parseInt(br.readLine());
		while(L-- > 0) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			q.add(new DirChange(second, dir));
		}
		if(!q.isEmpty()) nextChange = q.poll();
		snakeBody.add(new Point(1,1));
		board[1][1] = true;
		System.out.println(snakeMove(0,1,1,0));
	}
	
	static int snakeMove(int cnt, int row, int col, int dirNum) {
		if(cnt == nextChange.second) { // 뱀이 방향전환을 하는 경우
			if(nextChange.dir.equals("L")) dirNum = (dirNum+1)%4;
			else dirNum = (dirNum+3)%4;
			if(!q.isEmpty())nextChange = q.poll();
		}
		int nextRow = row+dRow[dirNum];
		int nextCol = col+dCol[dirNum];
		Point tmp = new Point(nextRow, nextCol);
		if(nextRow<1 || nextRow>N || nextCol<1 || nextCol>N) return cnt+1; // 벽에 부딪히는 경우
		else {
			snakeBody.add(new Point(nextRow,nextCol)); // 뱀이 머리를 다음 칸에 위치시킴
			if(board[nextRow][nextCol]) return cnt+1; // 뱀이 자기 몸에 부딪히는 경우
			board[nextRow][nextCol] = true;
		}
		if(apple[nextRow][nextCol]) {
			apple[nextRow][nextCol] = false;
		} else {
			Point erase = snakeBody.remove(); // 뱀이 사과를 안 먹었을 경우 꼬리 칸을 비워줌
			board[erase.row][erase.col] = false; 
		}
		cnt++;
		return snakeMove(cnt, nextRow, nextCol, dirNum);
	}
}

class DirChange {
	int second;
	String dir;
	DirChange(int second, String dir) {
		this.second = second;
		this.dir = dir;
	}
}

class Point {
	int row;
	int col;
	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}