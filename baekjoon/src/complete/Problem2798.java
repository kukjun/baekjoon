package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2798 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input1 = br.readLine().split(" ");
    int n = Integer.parseInt(input1[0]);
    int m = Integer.parseInt(input1[1]);

    String[] input2 = br.readLine().split(" ");
    int[] number = new int[input2.length];
    for(int i=0; i<number.length; i++) {
      number[i] = Integer.parseInt(input2[i]);
    }
    // 브루트 포스 알고리즘
    int max = 0;
    for(int i=0; i<number.length; i++) {
      for(int j=i+1; j< number.length; j++) {
        for(int k=j+1; k< number.length; k++) {
          int sum = number[i] + number[j] + number[k];
          if(sum <= m){
            if(sum > max) {
              max = sum;
            }
          }
        }
      }
    }
    System.out.println(max);

  }
}
