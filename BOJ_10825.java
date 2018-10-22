import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10825 {
	static int N;
	static PriorityQueue<Student> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		while(N-->0) {
			String[] str = br.readLine().split(" ");
			Student std = new Student(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			pq.add(std);
		}
		
		while(!pq.isEmpty()) {
			Student tmp = pq.poll();
			System.out.println(tmp.name);
		}
	}
}

class Student implements Comparable<Student>{
	String name;
	int kor, eng, math;
	Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.kor < o.kor) return 1;
		else if(this.kor > o.kor) return -1;
		else if(this.eng > o.eng) return 1;
		else if(this.eng < o.eng) return -1;
		else if(this.math < o.math) return 1;
		else if(this.math > o.math) return -1;
		else return this.name.compareTo(o.name);
	}
}
