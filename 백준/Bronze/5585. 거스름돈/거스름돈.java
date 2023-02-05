import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {500, 100, 50, 10, 5, 1};
        int remain = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        for (Integer i: arr) {
            if (remain / i != 0) {
                count += remain / i;
                remain %= i;
            }
        }
        System.out.println(count);
    }
}
