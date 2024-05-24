import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 201;
    static StringBuilder sb = new StringBuilder();
    static int[] Limit = new int[3];
    static boolean[] possible;
    static boolean[][][] visit;
    static class State {
        int[] X;
        State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        State move(int from, int to, int[] Limit) {
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] <= Limit[to]){  
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }else{  
                nX[from] -= Limit[to] - nX[to];
                nX[to] = Limit[to];
            }
            return new State(nX);
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) Limit[i] = Integer.parseInt(tk.nextToken());
        visit = new boolean[SIZE][SIZE][SIZE];
        possible = new boolean[SIZE];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1, x2, x3}));

        while(!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State next = st.move(from, to, Limit);
                    if (!visit[next.X[0]][next.X[1]][next.X[2]]) {
                        visit[next.X[0]][next.X[1]][next.X[2]] = true;
                        Q.add(next);
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);
        for (int i = 0; i <= Limit[2]; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}