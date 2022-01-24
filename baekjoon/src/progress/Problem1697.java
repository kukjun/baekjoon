package progress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1697 {

  static boolean findK = false;
  static boolean[] visit = new boolean[100001];

  // BFS 사용
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Queue<Integer> locationN = new LinkedList<>();
    int count = 0;

    String[] inputString = br.readLine().split(" ");

    int N = Integer.parseInt(inputString[0]);
    int K = Integer.parseInt(inputString[1]);

    locationN.add(N);

    while (!findK) {
      count++;
      secondJob(locationN, K);
    }

    System.out.println(count);

  }

  // BFS
  public static void secondJob(Queue<Integer> locationNs, int K) {

    // 큐의 값을 모두 int 형 배열에 삽입
    int[] locationIntNs = new int[locationNs.size()];
    {
      int i = 0;
      while (!locationNs.isEmpty()) {
        locationIntNs[i++] = locationNs.poll();
      }
    }

    // 배열에 넣은 값에서 다음 큐에 넣을 배열 확인
    for (int locationIntN : locationIntNs) {

      int minusN = locationIntN - 1;
      int plusN = locationIntN + 1;
      int doubleN = locationIntN * 2;

      // 배열에 저장되어 있는 경우에만 저장

      // 값 들이 허용 범위 안인 경우에만 연산 실행
      if (minusN > 0) {
        if (!visit[minusN]) {
          locationNs.add(minusN);
        }
      }
      if (plusN < 100000) {
        if (!visit[plusN]) {
          locationNs.add(plusN);
        }
      }
      if (doubleN > 100000) {
        if (!visit[doubleN]) {
          locationNs.add(doubleN);
        }
      }

      // 만약 배열 안에 있는 값들 중 K가 있으면
      if (minusN == K || plusN == K || doubleN == K) {
        findK = true;
        return;
      } else {
        // 예외 N이 0이면?
        if (locationIntN == 0) {
          locationNs.add(plusN);
        } else {
          // 만약 N의 값이 K보다 작으면
          if (locationIntN < K) {
            locationNs.add(minusN);
            locationNs.add(plusN);
            locationNs.add(doubleN);
          } else if (locationIntN > K) {
            locationNs.add(minusN);
          }
        }
      }
    }

  }

}