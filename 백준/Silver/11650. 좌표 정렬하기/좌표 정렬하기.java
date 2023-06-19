import java.util.*;
import java.io.*;

public class Main {

    static class Pos {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pos> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            posList.add(new Pos(x, y));
        }

        Collections.sort(posList, Comparator.comparing(Pos::getX).thenComparing(Pos::getY));

        StringBuilder sb = new StringBuilder();
        for (Pos pos : posList) {
            sb.append(pos).append("\n");
        }
        System.out.println(sb);
    }
}