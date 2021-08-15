package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem14494 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int[] num = new int[st.length];
    num[0] = Integer.parseInt(st[0]);
    num[1] = Integer.parseInt(st[1]);

    // x 축으로 3, y 축으로 2만큼 이동
    long[][] c = new long[num[1]][num[0]];

    for (int i = 0; i < num[0]; i++) {
      c[0][i] = 1;
    }
    for (int i = 0; i < num[1]; i++) {
      c[i][0] = 1;
    }


    for (int i = 1; i < num[1]; i++) {
      for (int j = 1; j < num[0]; j++) {
        c[i][j] = (c[i - 1][j] + c[i - 1][j - 1] + c[i][j - 1]) % (1000000000 + 7);
      }
    }
    System.out.println(c[num[1] - 1][num[0] - 1]);

  }

}
