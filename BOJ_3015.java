import java.util.*;

public class BOJ_3015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<SameHeight> stack = new Stack<>();
		stack.push(new SameHeight(sc.nextInt(),1));
		long cnt = 0;
		for(int i = 1; i < N; i++) {
			int num = sc.nextInt();
			// i번째 입력값을 받음
			int keepHeight = 0;
			int keepNum = 1;
			while(!stack.isEmpty()) {
				SameHeight sh = stack.pop();
				int peekHeight = sh.height;
				int peekNum = sh.peopleNum;
				// num과 peekHeight를 비교
				if(peekHeight > num) {
					cnt += 1;
					stack.push(new SameHeight(peekHeight, peekNum));
					stack.push(new SameHeight(num, keepNum));
					break;
				} else if(peekHeight == num) { // while 다시 돌려야
					keepHeight = peekHeight;
					keepNum = peekNum+1;
					cnt += peekNum;
					if(stack.isEmpty()) {
						stack.push(new SameHeight(keepHeight, keepNum));
						keepHeight = 0;
						keepNum = 1;
						break;
					}
				} else { // peekHeight < num ... 얘도 while 다시 돌려야
					cnt += peekNum;
					if(stack.isEmpty()) {
						stack.push(new SameHeight(num, keepNum));
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}

class SameHeight {
	int height;
	int peopleNum;
	SameHeight(int height, int peopleNum) {
		this.height = height;
		this.peopleNum = peopleNum;
	}
}
