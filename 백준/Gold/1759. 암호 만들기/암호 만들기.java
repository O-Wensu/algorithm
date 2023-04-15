import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static String[] alphabets;
    static String[] code;
    static final String VOWELS = "aeiou"; //모음
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void search(int depth, int start) throws IOException {
        if (depth == n) {
            makeCode();
            return;
        }

        for (int i = start; i < alphabets.length; i++) {
            code[depth] = alphabets[i];
            search(depth + 1, i + 1);
        }
    }

    public static void makeCode() throws IOException {
        int moCount = 0;
        int jaCount = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : code) {
            if (VOWELS.contains(s)) moCount++;
            else jaCount++;
            sb.append(s);
        }

        if (moCount >= 1 && jaCount >= 2){
            bw.write(sb.toString() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        alphabets = new String[m];
        code = new String[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            alphabets[i] = tk.nextToken();
        }
        Arrays.sort(alphabets);
        search(0, 0);
        bw.flush();
        bw.close();
        br.close();
    }
}