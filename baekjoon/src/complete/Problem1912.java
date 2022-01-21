package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1912 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 개수입력
    int N = Integer.parseInt(br.readLine());

    // 정수 저장할 배열 생성
    int[] integers = new int[N];

    // 정수입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int i = 0;
    while (st.hasMoreTokens()) {
      integers[i++] = Integer.parseInt(st.nextToken());
    }

    // 연속되는 값들 중 큰 값을 저장하는 dp 배열 생성
    int[] dp = new int[N];
    dp[0] = integers[0];
    for (int j = 1; j < dp.length; j++) {
      dp[j] = Math.max(dp[j - 1] + integers[j], integers[j]);
    }

    Arrays.sort(dp);
    System.out.println(dp[N - 1]);
  }


}
