package complete;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10952 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int A, B;
    int result;
    do {
      String A_B = br.readLine();
      st = new StringTokenizer(A_B, " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      if(A ==0 && B==0) {
        break;
      }
      result = A + B;
      bw.write(String.valueOf(result));
      bw.newLine();
    } while(true);
    bw.flush();
    bw.close();
  }

}
