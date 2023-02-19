import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(tk.nextToken()));
        }

        int min = arr.stream().min(Comparator.comparingInt(Integer::intValue)).get();
        int max = arr.stream().max(Comparator.comparingInt(Integer::intValue)).get();

        System.out.println(min + " " + max);
    }
}