package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1904 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 점화식 f(n) = f(n-1) + f(n-2)
    // n => 3, f(1) = 1, f(2) = 2

    if (N <= 2) {
      // f(1), f(2)를 구하는 경우 그냥 추출
      System.out.println(N);
    } else {
      // 그렇지 않은 경우, 초기값을 정해준 후 추출
      Long[] dp = new Long[N];
      dp[0] = 1L;
      dp[1] = 2L;

      for (int i = 2; i < dp.length; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2])%15746;
      }

      System.out.println(dp[N - 1]);

    }




  }
}
