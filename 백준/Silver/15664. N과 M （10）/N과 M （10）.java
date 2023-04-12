import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int n, m;
    public static boolean[] isUsed;
    public static int[] numbers;
    public static int[] arr;
    public static List<String> answer = new ArrayList<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int depth, int start) throws IOException{
        if (depth == m) {
            String str = "";
            for (int i : arr) {
                str += i + " ";
            }
            answer.add(str);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            arr[depth] = numbers[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        isUsed = new boolean[n];
        numbers = new int[n];
        arr = new int[m];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(numbers);
        dfs(0, 0);

        List<String> distinctList = answer.stream().distinct().collect(Collectors.toList());
        for (String s : distinctList) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}