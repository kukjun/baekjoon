package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10950 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i=0; i<T; i++) {
      String[] test = br.readLine().split(" ");
      int A = Integer.parseInt(test[0]);
      int B = Integer.parseInt(test[1]);
      System.out.println(A+B);
    }
  }

}
