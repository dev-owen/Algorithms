import java.util.Scanner;

public class BOJ_2448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String[] stars = new String[n];
		stars[0] = "  *  ";
		stars[1] = " * * ";
		stars[2] = "*****";

		for(int i = 1; 3 * (int)Math.pow(2,i) <= n; i++) {
			makeStars(i, stars);
		}

		for(int i = 0; i < n; i++) {
			System.out.println(stars[i]);
		}
	}

	static void makeStars(int i, String stars[]) {
		int length = 3 * (int)Math.pow(2,i); // 한 변의 길이
		for(int j = length/2; j < length; j++) {
			stars[j] = stars[j-length/2]+" "+stars[j-length/2];
		}
		String space = "";
		while (space.length() < length/2) {
			space += " ";
		}
		for (int j = 0; j < length/2; ++j) {
			stars[j] = space + stars[j] + space;
		}
	}
}
