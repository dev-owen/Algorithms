import java.io.*;
import java.util.*;

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            String[] arr = br.readLine().split(" ");
            list.add(new Member(Integer.parseInt(arr[0]), arr[1], i));
        }

        Collections.sort(list);
        for(Member m : list) {
            System.out.println(m.toString());
        }
    }
}

class Member implements Comparable<Member> {
    int age;
    String name;
    int cnt;

    Member(int age, String name, int cnt) {
        this.age = age;
        this.name = name;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return age+" "+name;
    }

    @Override
    public int compareTo(Member m) {
        if(m.age > this.age) {
            return -1;
        } else if(m.age < this.age) {
            return 1;
        } else {
            if(m.cnt > this.cnt) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}