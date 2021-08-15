package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1546 {

  public static void main(String[] args) {
    try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
      // 정보입력
      int[] N = new int[Integer.parseInt(br.readLine())];
      int max = 0;
      String[] testString = br.readLine().split(" ");
      List<Double> testInt = new ArrayList<>();
      for (String s : testString) {
        testInt.add(Double.parseDouble(s));
        max = Math.max(max, Integer.parseInt(s));
      }

      // 정보 가공
      for (int i=0; i<testInt.size(); i++) {
        testInt.set(i, testInt.get(i) / max * 100);
      }

      // 평균 구하기
      double sum = 0;
      for(double inTestScore : testInt) {
        sum += inTestScore;
      }

      double avg = sum / testInt.size();

      System.out.println(avg);

    } catch (IOException e){
      e.printStackTrace();
    }
  }

}
