package progress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem9461 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 변수 설정
    int T;
    int N;

    // 100을 넣는 경우 int 자료형을 초과함
    ArrayList<Long> P = new ArrayList<>();
    // 초기 값 5개를 insert
    P.add(1L);
    P.add(1L);
    P.add(1L);
    P.add(2L);
    P.add(2L);


    try {
      // input T
      T = Integer.parseInt(br.readLine());

      for (int i = 0; i < T; i++) {
        // input N
        N = Integer.parseInt(br.readLine());

        // output f(N)
        System.out.println(findTriangleSizeLength(N, P));

      }

    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  static int inputTestCase() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(br.readLine());
  }

  static int inputNumber() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(br.readLine());
  }

  static Long findTriangleSizeLength(int N, ArrayList<Long> P) {
    // 만약 아직 진행하지 않은 연산이면 ArrayList 에 넣어주기
    if (N > P.size()) {
      for (int j = P.size(); j <= N-1; j++) {
        P.add(P.get(j-1) + P.get(j-5));
      }
    }
    // 초기값 이거나, 이미 진행한 연산이면 패스하고 리턴
    return P.get(N-1);
  }

}
