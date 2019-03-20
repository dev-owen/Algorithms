import java.io.*;
import java.util.*;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> list = new LinkedList<>();
        while(N-->0) {
            String[] arr = br.readLine().split(" ");
            list.add(new Point(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
        }
        Collections.sort(list);
        for(Point p: list) {
            System.out.println(p.toString());
        }
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x+" "+y;
    }

    @Override
    public int compareTo(Point p) {
        if(p.x > this.x) {
            return -1;
        } else if(p.x < this.x) {
            return 1;
        } else {
            if(p.y >= this.y) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}