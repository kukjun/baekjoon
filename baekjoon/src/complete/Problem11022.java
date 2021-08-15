package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11022 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for(int i=1; i<=T; i++) {
      String A_B = br.readLine();
      st = new StringTokenizer(A_B, " ");
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int result = A+B;
      bw.write("Case #" + String.valueOf(i) + ": " + String.valueOf(A) + " + " + String.valueOf(B) + " = " + String.valueOf(result));
      bw.newLine();
    }
    bw.flush();
    bw.close();

  }
}
