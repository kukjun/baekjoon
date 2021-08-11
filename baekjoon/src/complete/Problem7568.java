package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem7568 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    int[][] n2 = new int[n1][2];

    for(int i=0; i<n1; i++) {
      String[] st = br.readLine().split(" ");
      n2[i][0] = Integer.parseInt(st[0]);
      n2[i][1] = Integer.parseInt(st[1]);
    }

    for(int i=0; i<n1; i++) {
      int count = 1;
      for(int j=0; j<n1; j++) {
        if(i == j ) {
          continue;
        }
        if(n2[i][0]<n2[j][0]) {
          if(n2[i][1]<n2[j][1]) {
            count++;
          }
        }
      }
      System.out.print(count + " ");
    }


  }

}
