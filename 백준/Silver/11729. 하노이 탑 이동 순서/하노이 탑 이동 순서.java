import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        bw.write((int) Math.pow(2, size) - 1 + "\n");

        hanoi(size, 1, 2, 3);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void hanoi(int count, int start, int mid, int to) throws IOException {
        if (count == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }
        hanoi(count - 1, start, to, mid);
        bw.write(start + " " + to + "\n");
        hanoi(count - 1, mid, start, to);
    }
}