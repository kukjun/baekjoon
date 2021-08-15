package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10871 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    String N_X = br.readLine();
    st = new StringTokenizer(N_X, " ");
    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    String A = br.readLine();
    st = new StringTokenizer(A, " ");
    for(int i=0; i<N; i++) {
      int AElement = Integer.parseInt(st.nextToken());
      if(X>AElement) {
        bw.write(String.valueOf(AElement) + " ");
      }
    }
    bw.flush();
    bw.close();
  }

}
