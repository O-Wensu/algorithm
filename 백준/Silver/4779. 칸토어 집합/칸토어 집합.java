import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int n = scanner.nextInt();
            int count = (int) Math.pow(3,n);
            char[] line = "-".repeat(count).toCharArray();
            recursive(n, line, 0, count);
            print(line);
            if (!scanner.hasNextInt()) break;
        }
    }
    static void recursive(int n, char[] line, int left, int right) {
        if (Math.abs(right - left) <= 1 || left >= right) {
            return;
        }
        int mid = (right - left) / 3;
        for (int i = left + mid; i < right - mid; i++) {
            line[i] = ' ';
        }

        recursive(n, line, left, left + mid);
        recursive(n, line, right - mid, right);
    }

    static void print(char[] line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}