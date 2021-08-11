package complete;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10951 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int A, B;
    int result;
    String A_B;
    while ((A_B = br.readLine()) != null){
      st = new StringTokenizer(A_B);
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      result = A + B;
      bw.write(String.valueOf(result));
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }

}