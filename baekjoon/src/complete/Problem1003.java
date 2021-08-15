package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치 함수
public class Problem1003 {

  // f0, f1을 피보나치가 얼마나 가지는지 계산
  public static class F {

    public int f0;
    public int f1;

  }

  public static void fibonacci(int n) {

    F[] f = new F[n + 1];

    f[0] = new F();
    f[0].f0 = 1;
    if (n > 0) {
      f[1] = new F();
      f[1].f1 = 1;
      if (n > 1) {
        for (int j = 2; j <= n; j++) {
          f[j] = new F();
          f[j].f0 = f[j - 1].f0 + f[j - 2].f0;
          f[j].f1 = f[j - 1].f1 + f[j - 2].f1;
        }
      }
    }

    System.out.println(f[n].f0 + " " + f[n].f1);

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input1 = Integer.parseInt(br.readLine());

    // 시간 없으므로 DP 풀이
    for (int i = 0; i < input1; i++) {
      int input2 = Integer.parseInt(br.readLine());
      fibonacci(input2);
    }

  }

}
