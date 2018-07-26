// 미완료

import java.util.InputMismatchException;
import java.util.Scanner;

public class ENDIANS {
	
	public static int endians(int number){
		try {
		String s="";
		String[] s2 = new String[4];
		for(int i=0; i<Integer.numberOfLeadingZeros(number); i++) s+= "0";
		s += Integer.toBinaryString(number);
		for(int i=0;i<32; i+=8) s2[i/8] = s.substring(i, i+8);
		String str = s2[0];
		s2[0] = s2[3];
		s2[3] = str;
		String str2 = s2[1];
		s2[1] = s2[2];
		s2[2] = str2;
		String str3=s2[0]+s2[1]+s2[2]+s2[3];
		return Integer.parseInt(str3,2);
		} catch(NumberFormatException e) {
			return number;
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int array[] = new int[num];
		if(num<=10000 && num>=1) {
			for(int i=0; i<num; i++) {
				try {
					array[i] = sc.nextInt();
				} catch (InputMismatchException e) {
					// 여기를 어떻게 해야 하는지...
				}
				array[i] = endians(array[i]);
			}
			for(int i=0; i<num; i++)
				System.out.println(array[i]);
		}
		
	}
}
