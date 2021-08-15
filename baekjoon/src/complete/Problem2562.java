package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//최댓값
public class Problem2562 {

  public static void main(String[] args) {

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] array = new int[9];
      for (int i = 0; i < 9; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }
      int max = 0;
      int maxNumber = 0;
      for (int i = 0; i < 9; i++) {
        if (max < array[i]) {
          max = array[i];
          maxNumber = i+1;
        }
      }
      System.out.println(max);
      System.out.println(maxNumber);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
