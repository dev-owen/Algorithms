import java.util.*;
public class BOJ_10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            char[] arr = sc.nextLine().toCharArray();
            int UC = 0, LC = 0, num = 0, blk = 0;
            for(char s : arr) {
                int n = (int) s;
                if(s == ' ') blk++;
                else if(n >= 97) LC++;
                else if(n >= 65) UC++;
                else if(n >= 48) num++;
            }
            System.out.println(LC+" "+UC+" "+num+" "+blk);
        }
    }
}