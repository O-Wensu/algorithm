import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        recursive(n);
        System.out.println(sb.toString());
    }

    public static void recursive(int count) {
        if (count == 0) return;
        String empty = " ".repeat(n - count);
        String star = "*".repeat(count);
        sb.append(empty + star + "\n");
        recursive(count - 1);
    }
}