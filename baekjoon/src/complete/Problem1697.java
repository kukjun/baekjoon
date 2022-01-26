package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1697 {
  static boolean[] visit = new boolean[100001];
  static Queue<Integer> locationNs = new LinkedList<>();
  static int count = 0;
  static int N, K;

  // BFS 사용
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputString = br.readLine().split(" ");

    N = Integer.parseInt(inputString[0]);
    K = Integer.parseInt(inputString[1]);

    locationNs.add(N);

    secondJob();

    System.out.println(count);

  }

  // BFS
  public static void secondJob() {

    // 먼저 queue 비어있는지 확인
    if (locationNs.isEmpty()) {
      return;
    }

    if (locationNs.contains(K)) {
      return;
    }

    // 큐에서 사이즈만큼 꺼낸다.
    int queueSize = locationNs.size();

    for (int i = 0; i < queueSize; i++) {
      int var = locationNs.poll();

      int[] cases = new int[3];
      cases[0] = var - 1;
      cases[1] = var + 1;
      cases[2] = var * 2;

      for (int casesVar : cases) {
        if (casesVar < 0 || casesVar > 100000) {
          continue;
        }
        if (visit[casesVar]) {
          continue;
        }
        locationNs.add(casesVar);
        visit[casesVar] = true;
      }

    }
    ++count;
    secondJob();

  }

}