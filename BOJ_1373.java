import java.io.*;
public class BOJ_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputStr = new StringBuilder(br.readLine());
        int length = inputStr.length();
        if(length%3==1) inputStr.insert(0,"00");
        else if(length%3==2) inputStr.insert(0,"0");
        length = inputStr.length();
        StringBuilder outputStr = new StringBuilder();
        for(int i=length; i>=3; i-=3) {
            int tmp = Integer.parseInt(inputStr.substring(i-3,i),2);
            outputStr.append(Integer.toOctalString(tmp));
        }
        System.out.println(outputStr.reverse());
    }
}