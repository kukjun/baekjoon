package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1110 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int result = N;
    int count = 0;

    do {
      int front;
      int back;
      front = result / 10;
      back = result % 10;
      result = (back * 10) + ((front + back) % 10);
      count++;

    } while (result != N);
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }


}
