*
*  
*
*
import java.util.Scanner;

public class DRAWRECT {
	
	public static String drawRect(String x1, String x2, String x3, String y1, String y2, String y3) {
		if(x1.equals(x2)) {
			if(y1.equals(y3)) {
				return (x3+" "+y2);
			} else {
				return (x3+" "+y1);
			}
		} else if(x1.equals(x3)) {
			if(y1.equals(y2)) {
				return (x2+" "+y3);
			} else {
				return (x2+" "+y1);
			}
		} else if(x2.equals(x3)) {
			if(y2.equals(y1)) {
				return (x1+" "+y3);
			} else {
				return (x1+" "+y2);
			}
		} else {
			return null;
		}	
	}

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int T = sc1.nextInt();
		String[][][] Array = new String[T][3][2];
		
		Scanner sc2 = new Scanner(System.in);
		for(int i=0; i<T; i++) {
			for(int j=0; j<3; j++) {
				String str;
				str = sc2.nextLine();
				Array[i][j][0] = str.split(" ")[0];
				Array[i][j][1] = str.split(" ")[1];
			}
		}
		 for(int i=0; i<T; i++) System.out.println(drawRect(Array[i][0][0], Array[i][1][0], Array[i][2][0], Array[i][0][1], Array[i][1][1], Array[i][2][1]));
	}
}
