package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10818 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int loopVariable = Integer.parseInt(br.readLine());
    int[] arrays = new int[loopVariable];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < loopVariable; i++) {
      int var = Integer.parseInt(st.nextToken());
      arrays[i] = var;
    }
    System.out.println(Arrays.stream(arrays).min().getAsInt() + " " + Arrays.stream(arrays).max().getAsInt());

  }

}
