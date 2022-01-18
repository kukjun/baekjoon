package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem15649_2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 백트래킹 방식으로 이미 있는 경우에 대해서는 사용화하지 않도록 함
    String[] strings = br.readLine().split(" ");

    // 변수 이름 설정 N, M 설정하기
    int N = Integer.parseInt(strings[0]);
    int M = Integer.parseInt(strings[1]);

    // 방문노드를 기억하기 위해 리스트 사용 -> 매번 리스트 생성이 너무 불필요함 -> 새 리스트가 아니라 동일 인덱스 값을 수정하는 방식으로 변경
    // -> 인덱스 대체시 뒤로 미루는 문제로 인해, 배열로 변경
    int[] usedNumbers = new int[M];

    // 현재 반복횟수를 지정하기 위해 count 사용
    int count = 0;

    func(usedNumbers, N, count, M);

  }

  public static void func(int[] usedNumbers, int maxNumber, int count, int maxCount) {

    if (maxCount == count) {
      for (int usedNumber : usedNumbers) {
        System.out.print(usedNumber + " ");
      }
      System.out.println();
      return;
    }

    // 이미 방문한 숫자 확인하기
    boolean[] visit = new boolean[maxNumber + 1];
    for (int i = 1; i < visit.length; i++) {
      for (int usedNumber : usedNumbers) {
        if (i == usedNumber) {
          visit[i] = true;
          break;
        }
      }
    }

    // 방문안한 숫자만 시작하도록 반복
    for (int i = 1; i < visit.length; i++) {
      // 만약 방문한 노드가 아닌 경우
      if (!visit[i]) {
        usedNumbers[count] = i;
        func(usedNumbers, maxNumber, count + 1, maxCount);
        // 다음번에 방문했다고 표시할수도 있으므로, 다시 방문하지 않았다고 표시
        usedNumbers[count] = 0;
      }
    }
  }

}