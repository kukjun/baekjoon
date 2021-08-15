package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Problem3052 {

  public static void main(String[] args) {
    int[] input = new int[10];
    List<Integer> result = new LinkedList<>();
    int count = 0;
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ) {
      for (int i = 0; i < input.length; i++) {
        input[i] = Integer.parseInt(br.readLine());
        input[i] %= 42;
        if(!result.contains(input[i])) {
          result.add(input[i]);
        }
      }

      System.out.println(result.size());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
