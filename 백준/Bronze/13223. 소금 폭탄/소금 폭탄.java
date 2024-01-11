import java.io.*;
import java.time.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        String pour = br.readLine();
        if (now.equals(pour)) {
            System.out.println("24:00:00");
            return;
        }
        LocalTime nowTime = LocalTime.parse(now);
        LocalTime pourTime = LocalTime.parse(pour);
        LocalTime minusSecondTime = pourTime.minusSeconds(nowTime.getSecond());
        LocalTime minusMinuteTime = minusSecondTime.minusMinutes(nowTime.getMinute());
        LocalTime minusHourTime = minusMinuteTime.minusHours(nowTime.getHour());
        String answer = String.valueOf(minusHourTime);
        answer = minusHourTime.getSecond() == 0 ? answer + ":00" : answer;
        System.out.println(answer);
    }
}