package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//LCS
public class Problem9251 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] X = br.readLine().toCharArray();
    char[] Y = br.readLine().toCharArray();

    // 자동 0 초기화
    // 배열의 크기는 사이즈보다 하나씩 크게 해주어야 한다.
    int[][] Z = new int[X.length+1][Y.length+1];


    for(int i=1; i<X.length+1; i++) {
      for (int j = 1; j < Y.length+1; j++) {
        if(X[i-1]==Y[j-1]) {
          Z[i][j] = Z[i-1][j-1]+1;
        }
        else {
          Z[i][j] = Math.max(Z[i-1][j], Z[i][j-1]);
        }
      }
    }
    System.out.println(Z[X.length][Y.length]);
  }

}
