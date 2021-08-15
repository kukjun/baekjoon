package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2439 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N-i; j++) {
        bw.write(" ");
      }
      for(int j=N-i+1; j<=N; j++) {
        bw.write("*");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }

}
