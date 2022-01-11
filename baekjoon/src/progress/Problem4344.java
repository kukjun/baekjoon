package progress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4344 {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int firstInput;
    double[] results;
    double[] resultRates;
    try {
      // 첫번째 입력
      firstInput = Integer.parseInt(br.readLine());
      results = new double[firstInput];
      resultRates = new double[firstInput];

      for(int i=0; i<firstInput; i++) {
        // 내부 입력
        String secondInput = br.readLine();

        // 평균 구하는 연산
        st = new StringTokenizer(secondInput, " ");

        int N = Integer.parseInt(st.nextToken());
        for(int j=0; j<N;j++) {
          results[i] += Double.parseDouble(st.nextToken());
        }
        results[i] /= N;

        // 학생 비율 구하기
        st = new StringTokenizer(secondInput, " ");
        st.nextToken();
        int count = 0;
        for(int j=0; j<N; j++) {
          if (results[i] < Double.parseDouble(st.nextToken())) {
            count++;
          }
        }
        resultRates[i] = (double)count / N;
      }

      for (double resultRate : resultRates) {
        System.out.printf("%.3f%%\n", resultRate*100);
      }

    } catch(Exception e) {
      e.printStackTrace();
    }

  }

}
