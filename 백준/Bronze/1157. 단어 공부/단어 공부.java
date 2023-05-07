import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            int num = 1;
            if (map.containsKey(c)) num = map.get(c) + 1;
            map.put(c, num);
        }

        String key = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey().toString().toUpperCase();
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max && !key.equals(entry.getKey().toString().toUpperCase())) {
                key = "?";
                break;
            }
        }
        System.out.println(key);
    }
}