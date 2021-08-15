package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2884 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int hour = Integer.parseInt(input[0]);
    int minute = Integer.parseInt(input[1]);

    // 경우 설정
    if(minute>=45) { // 만약 minute 가 45 이상이면 시간을 바꾸지 않고 minute 에서 그냥 빼면 됨
      minute -= 45;
    } else { // 만약 45 미만이면 시간도 바꾸어 주어야 함.
      minute += 15;
      hour--;
      if(hour==-1) {
        hour += 24;
      }
    }
    System.out.println(hour + " " + minute);
  }

}
