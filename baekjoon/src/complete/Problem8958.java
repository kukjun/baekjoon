package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem8958 {

  public static void main(String[] args) {
    String str;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      // 첫 번째 입력
      int firstInput = Integer.parseInt(br.readLine());

      // 입력만큼 결과를 저장할 배열 생성
      int[] results = new int[firstInput];

      // 첫 번째 입력만큼 반복
      for(int i=0; i<firstInput; i++) {
        // 입력을 문자열로 저장
        str = br.readLine();
        char[] chars = str.toCharArray();
        // 'O'인 경우 1늘리고, 'X'인 경우 0으로 초기화 할 변수 생성
        int count = 0;

        for(char c : chars) {
          if(c=='O') {
            count++;
          } else {
            count = 0;
          }
          results[i] += count;
        }
      }

      for (int result : results) {
        System.out.println(result);
      }



    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
