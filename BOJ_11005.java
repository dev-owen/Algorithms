import java.util.*;
public class BOJ_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        String ans = "";
        while (true) {
            int tmp = N/B;
            int extra = N%B;
            if(tmp>0) {
                ans = change(extra)+ans;
                N = tmp;
            } else {
                ans = change(extra)+ans;
                break;
            }
        }
        System.out.println(ans);

    }
    public static String change(int num) {
        if(num <10) return String.valueOf(num);
        else if(num == 10) return "A";
        else if(num == 11) return "B";
        else if(num == 12) return "C";
        else if(num == 13) return "D";
        else if(num == 14) return "E";
        else if(num == 15) return "F";
        else if(num == 16) return "G";
        else if(num == 17) return "H";
        else if(num == 18) return "I";
        else if(num == 19) return "J";
        else if(num == 20) return "K";
        else if(num == 21) return "L";
        else if(num == 22) return "M";
        else if(num == 23) return "N";
        else if(num == 24) return "O";
        else if(num == 25) return "P";
        else if(num == 26) return "Q";
        else if(num == 27) return "R";
        else if(num == 28) return "S";
        else if(num == 29) return "T";
        else if(num == 30) return "U";
        else if(num == 31) return "V";
        else if(num == 32) return "W";
        else if(num == 33) return "X";
        else if(num == 34) return "Y";
        else if(num == 35) return "Z";
        else return "";
    }
}