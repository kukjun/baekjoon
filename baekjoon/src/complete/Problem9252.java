package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//LCS2
public class Problem9252 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] X = br.readLine().toCharArray();
    char[] Y = br.readLine().toCharArray();

    // 자동 0 초기화
    int[][] Count = new int[X.length+1][Y.length+1];
    // 부분 수열중 가장 큰 수열을 저장해야 함
    String[][] Z = new String[X.length+1][Y.length+1];
    for(int i=0; i<X.length+1; i++) {
      for(int j=0; j<Y.length+1; j++) {
        Z[i][j] = "";
      }
    }


    for(int i=1; i<X.length+1; i++) {
      for (int j = 1; j < Y.length+1; j++) {
        if(X[i-1]==Y[j-1]) {
          Count[i][j] = Count[i-1][j-1] + 1;
          Z[i][j] = Z[i-1][j-1] + X[i-1];
        }
        else {
          if(Z[i-1][j].length()>Z[i][j-1].length()) {
            Z[i][j] = Z[i-1][j];
            Count[i][j] = Count[i-1][j];
          }
          else {
            Z[i][j] = Z[i][j-1];
            Count[i][j] = Count[i][j-1];
          }
        }
      }
    }
    System.out.println(Count[X.length][Y.length]);
    System.out.println(Z[X.length][Y.length]);
  }

}
