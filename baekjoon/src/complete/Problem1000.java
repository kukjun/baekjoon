package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1000 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int[] num = new int[st.length];

    for (int i=0; i<num.length; i++) {
      num[i] = Integer.parseInt(st[i]);
    }

    int result = num[0] + num[1];

    System.out.println(result);
  }

}
