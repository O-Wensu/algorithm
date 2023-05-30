import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int index;
        int number;

        public Pos(int index, int number) {
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public int getNumber() {
            return number;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Pos> posList = new ArrayList<>();
        int[] result = new int[size];
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            posList.add(new Pos(i, Integer.parseInt(tk.nextToken())));
        }

        Collections.sort(posList, Comparator.comparing(Pos::getNumber));
        result[posList.get(0).getIndex()] = 0;

        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (posList.get(i).number != posList.get(j).number) {
                    result[posList.get(i).index] = result[posList.get(j).index] + 1;
                    break;
                }
                result[posList.get(i).index] = result[posList.get(j).index];
                break;
            }
        }
        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}