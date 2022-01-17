package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem14713 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      int T = Integer.parseInt(br.readLine());

      // 총 큐의 개수
      Queue<String>[] queues = new Queue[T + 1];
      // 각 큐 초기화
      for (int i = 0; i < queues.length; i++) {
        queues[i] = new LinkedList<>();
      }

      // 단어 입력받고 큐에 저장
      for (int i = 0; i < queues.length; i++) {
        String[] strs = br.readLine().split(" ");
        for (int j = 0; j < strs.length; j++) {
          queues[i].add(strs[j]);
        }
      }

      // 마지막에 입력받은 결과 큐와 앵무새 큐를 확인하는 부분
      while (!queues[T].isEmpty()) {
        boolean findInside = false;
        for (int i = 0; i < T; i++) {
          if (queues[i].isEmpty()) {
          } else {
            if (queues[i].peek().equals(queues[T].peek())) {
              findInside = true;
              queues[i].poll();
              queues[T].poll();
            }
          }
        }
        // 예외 1. 만약 결과 큐에 값을 앵무새 큐에서 찾을 수 없으면
        if (!findInside) {
          System.out.println("Impossible");
          return;
        }
      }

      // 예외 2. 만약 결과 큐가 비었는데 앵무새 큐가 남아 있으면
      for (int i = 0; i < T; i++) {
        if (!queues[i].isEmpty()) {
          System.out.println("Impossible");
          return;
        }
      }

      // 만약 모두 정상적으로 끝나면
      System.out.println("Possible");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
