package boj;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
	static int N, M, village[][], ans;
	static ArrayList<Point> house = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	static HashSet<Point> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		village = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					house.add(new Point(i,j));
					village[i][j] = 1;
				}
				else if(tmp==2) chicken.add(new Point(i,j));
			}
		}
		ans = Integer.MAX_VALUE;
		set = new HashSet<>();
		dfs(0,set);
		System.out.println(ans);
	}
	
	static void dfs(int idx, HashSet<Point> set) {
		if(set.size() == M) ans=Math.min(ans,count(set));
		else if(idx >= chicken.size()) return;
		else {
			Point p = chicken.get(idx);
			dfs(idx+1, set);
			set.add(p);
			dfs(idx+1, set);
			set.remove(p);
		}
	}
	static int count(HashSet<Point> set) {
		int ckLen = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(village[i][j]==1) {
					Iterator<Point> iter = set.iterator();
					int minLen = Integer.MAX_VALUE;
					while (iter.hasNext()) {
						Point p = iter.next();
					    int len = Math.abs(i-p.row)+Math.abs(j-p.col);
					    minLen = Math.min(minLen, len);
					}
					ckLen += minLen;
				}
			}
		}
		return ckLen;
	}
}

class Point {
	int row, col;
	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}