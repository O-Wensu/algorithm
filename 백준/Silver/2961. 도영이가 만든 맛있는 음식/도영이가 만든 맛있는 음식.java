import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int len;
    static int[][] material;
    static boolean[] isUsed;
    static int[][] selects;
    static int min = Integer.MAX_VALUE;
    static void search(int depth) {
        if (depth == len) {
            int sour = 1;
            int bitter = 0;
            for (int[] select : selects) {
                sour *= select[0];
                bitter += select[1];
            }
            int diff = Math.abs(sour - bitter);
            min = Math.min(min, diff);
            return;
        }

        for (int i = 0; i < material.length; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                selects[depth] = material[i];
                search(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        material = new int[n][2];
        isUsed = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            material[i][0] = Integer.parseInt(tk.nextToken());
            material[i][1] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < n; i++) {
            len = i + 1;
            selects = new int[i + 1][2];
            search(0);
        }
        System.out.println(min);
    }
}