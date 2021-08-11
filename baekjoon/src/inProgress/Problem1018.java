package inProgress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1018 {

  public static int min = 64;
  public static char[][] c2;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    //문자 입력 받기
    st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());


    c2 = new char[N][M];
    for (int i = 0; i < N; i++) {
      c2[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        min = Math.min(min, find(i, j));
      }
    }
    System.out.println(min);
  }

  public static int find(int x, int y) {
    int end_x = x + 8;
    int end_y = y + 8;
    int count = 0;

    if(c2[x][y] == 'W') {
      for (int k = x; k < end_x; k++) {
        for (int l = y; l < end_y; l++) {
          if ( ( (k-x) % 2 == 0 && l % 2 == 0 ) || (k % 2 == 1 && l % 2 == 1)) {
            if (c2[k][l] != 'W') {
              count++;
            }
          } else {
            if (c2[k][l] != 'B') {
              count++;
            }
          }
        }
      }
    }
    else if (c2[x][y] == 'B') {
      for (int k = x; k < end_x; k++) {
        for (int l = y; l < end_y; l++) {
          if ((k % 2 == 0 && l % 2 == 0) || (k % 2 == 1 && l % 2 == 1)) {
            if (c2[k][l] != 'B') {
              count++;
            }
          } else {
            if (c2[k][l] != 'W') {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

}
