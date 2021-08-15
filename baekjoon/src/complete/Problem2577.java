package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2577 {

  public static void main(String[] args) {
    try {
      int[] input = new int[3];
      int result = 1;
      int[] numbers = new int[10];

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < input.length; i++) {
        input[i] = Integer.parseInt(br.readLine());
        result *= input[i];
      }

      while(result!=0) {
        numbers[result%10]++;
        result/=10;
      }
      for(int number : numbers) {
        System.out.println(number);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
