import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int n, m;
    public static int[] numbers;
    public static int[] arr;
    public static boolean[] isUsed;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static List<String> result = new ArrayList<>();

    public static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = numbers[i];
                dfs(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        numbers = new int[n];
        arr = new int[m];
        isUsed = new boolean[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(numbers);
        dfs(0);

        result = result.stream().distinct().collect(Collectors.toList());
        for (String str : result) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}