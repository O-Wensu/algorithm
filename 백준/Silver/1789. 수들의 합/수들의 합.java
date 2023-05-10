import java.io.*;

public class Main {
    static long s;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        search(0, 1);
        System.out.println(count);
    }

    public static void search(long prevSum, long num) {
        long pairNum = s - num - prevSum;
        if (pairNum <= num) {
            count += 1;
            return;
        }
        count += 1;
        search(num + prevSum,num + 1);
    }
}