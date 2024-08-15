import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] heights;
    static int sum = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        heights = new int[9];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        Arrays.sort(heights);
    }

    static boolean isSumHundred(int i, int j) {
        int result = sum - heights[i] - heights[j];
        if (result == 100) return true;
        return false;
    }

    static void pro() {
        boolean isStop = false;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (isSumHundred(i, j)) {
                    for (int k = 0; k < heights.length; k++) {
                        if (k == i || k == j) continue;
                        sb.append(heights[k]).append('\n');
                    }
                    isStop = true;
                    break;
                }
            }
            if (isStop) break;
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}