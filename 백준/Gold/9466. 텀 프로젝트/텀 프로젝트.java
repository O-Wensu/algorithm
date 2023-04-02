import javax.swing.text.html.ListView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visited;
    static boolean[] isFinish;
    static int[] arr;
    static int count;
    public static void dfs(int x) {
        if (isFinish[x]) return; //이미 확인이 끝난 학생이면

        if (visited[x]) { //이전에 지목된 학생이면
            isFinish[x] = true;
            count++;
        } else { //이전에 지목된 학생이 아니면, 더 확인
            visited[x] = true;
        }
        int next = arr[x]; //지목된 학생
        if (!isFinish[arr[next]]) { //확인이 안 됐으면
            dfs(arr[next]);
        }
        isFinish[x] = true;
        visited[x] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            isFinish = new boolean[n + 1];
            count = 0;
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!isFinish[j]) { //확인이 끝난 학생이 아니면
                    dfs(j);
                }
            }
            bw.write(n - count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}