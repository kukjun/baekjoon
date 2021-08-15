package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2502 {

  public static class AB {

    int a;
    int b;

  }

  public static void mochi(int data, int day) {
    AB[] days = new AB[day];
    days[0] = new AB();
    days[1] = new AB();
    days[0].a = 1;
    days[1].b = 1;
    for (int i = 2; i < day; i++) {
      days[i] = new AB();
      days[i].a = days[i - 1].a + days[i - 2].a;
      days[i].b = days[i - 1].b + days[i - 2].b;
    }

    AB lastDay = days[day-1];

    for (int i = 1; i <= (data - lastDay.b) / lastDay.a; i++) {
      for (int j = 1; j <= (data - lastDay.a)/lastDay.b; j++) {
        if(data == (lastDay.a * i) + (lastDay.b * j)) {
          if(i>j) {
            return;
          }
          System.out.println(i);
          System.out.println(j);
          return;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String input = br.readLine();

    st = new StringTokenizer(input, " ");
    int day = Integer.parseInt(st.nextToken());
    int data = Integer.parseInt(st.nextToken());

    mochi(data, day);


  }

}
