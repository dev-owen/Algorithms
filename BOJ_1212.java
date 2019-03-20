import java.io.*;
public class BOJ_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputStr = new StringBuilder(br.readLine());
        StringBuilder outputStr = new StringBuilder();
        int len = inputStr.length();
        outputStr.append(Integer.toBinaryString(Character.getNumericValue(inputStr.charAt(0))));
        for(int i=1; i<len; i++) {
            int tmp = Integer.parseInt(inputStr.substring(i,i+1));
            String str = Integer.toBinaryString(tmp);
            if(tmp<=1) str = "00"+str;
            else if(tmp<=3) str = "0"+str;
            outputStr.append(str);
        }
        System.out.println(outputStr);
    }
}