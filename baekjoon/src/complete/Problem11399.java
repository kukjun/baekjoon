package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem11399{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 첫째 줄 입력
    int N = Integer.parseInt(br.readLine());

    // 둘째 줄 입력 후, 입력 값 쪼개서 배열에 저장
    String[] stringP = br.readLine().split(" ");
    int[] P = new int[stringP.length];

    // int 배열로 재저장
    for (int i = 0; i < P.length; i++) {
      P[i] = Integer.parseInt(stringP[i]);
    }

    // int 배열 정렬하기 (작은 값이 앞으로 오도록)
    Arrays.sort(P);

    // int 배열 새로 저장
    int[] resultArrays = new int[P.length];
    for (int i = 0; i < P.length; i++) {
      for (int j = i; j < P.length; j++) {
        resultArrays[j] += P[i];
      }
    }

    int result = 0;
    for (int i : resultArrays) {
      result += i;
    }

    bw.write(result+"\n");


    bw.flush();
    bw.close();
  }
}
