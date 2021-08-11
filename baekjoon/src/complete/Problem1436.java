package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//영화감독 숌 브루트포스
public class Problem1436 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count=0;
    int result=666;
    String resultChange;

    while(count != N) {
      resultChange = String.valueOf(result);
      if (resultChange.contains("666")) {
        count++;
      }
      result++;
    }
    System.out.println(result-1);
  }

}
