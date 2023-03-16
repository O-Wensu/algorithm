import java.util.*;
import java.io.*;

public class Main {

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            positions.add(new Position(x, y));
        }
        positions.sort(Comparator.comparing(Position::getY).thenComparing(Position::getX));
        for (Position position : positions) {
            bw.write(position.getX() + " " + position.getY() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}