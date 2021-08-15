package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2231 {

  public static void main(String[] args) throws Exception {
    int m;
    boolean success = false;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    m = Integer.parseInt(br.readLine());

    for (int i = 1; i < m; i++) {
      int number = i;
      int sum = number;
      // 나눈 값이 0이 아니면 반복 -> 나머지 가져오기
      while (number / 10 != 0) {
        sum += number % 10;
        number /= 10;
      }
      sum += number;
      if(sum == m) {
        success = true;
        System.out.println(i);
        return;
      }
    }
    System.out.println(0);
  }

}
