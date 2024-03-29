import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> logs = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            String name = tk.nextToken();
            String type = tk.nextToken();
            if (type.equals("enter")) {
                logs.put(name, type);
            } else {
                if (logs.containsKey(name)) {
                    logs.remove(name);
                }
            }
        }
        for (String key : logs.keySet()) {
            bw.write(key + "\n");
        }
        bw.flush();
        bw.close();
    }
}