package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1065 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int count = 0;

    if (N <= 99) {
      count = N;
    } else if (N < 1000) {
      count = 99;
      for (int t = 100; t <= N; t++) {
        int i, j, k;
        i = t % 10;
        j = (t / 10) % 10;
        k = (t / 100) % 10;
        if ((i - j) == (j - k)) {
          count++;
        }
      }
    } else if (N == 1000) {
      count = 144;
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();

  }
}
