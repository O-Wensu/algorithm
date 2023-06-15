import java.util.*;
import java.io.*;

public class Main {

    static String word;
    static int n;
    static boolean[] isUsed;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        n = word.length();
        isUsed = new boolean[n];

        search(0, n - 1);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void search(int start, int end) throws IOException {
        if (start > end) return;

        int min = start;

        //범위 내의 가장 작은 알파벳의 인덱스 구하기
        for (int i = start; i <= end; i++) {
            if (!isUsed[i]) {
                min = word.charAt(min) > word.charAt(i) ? i : min;
            }
        }

        //초기 min 설정을 했으므로, 사용 여부를 확인해야 함
        if (isUsed[min]) return;

        isUsed[min] = true;

        print();
        search(min + 1, end);
        search(start, min - 1);
    }

    private static void print() throws IOException {
        for (int i = 0; i < n; i++) {
            if (isUsed[i]) {
                bw.write(word.charAt(i) + "");
            }
        }
        bw.write("\n");
    }
}