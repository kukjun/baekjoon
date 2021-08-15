package complete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem11866 {

  public static void main(String[] args) {
    Queue<Integer> humanRing = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();

    if ((N >= 1 && N <= 1000) && (K >= 1 && K <= N)) {

      // 사람들 링 생성
      for (int i = 1; i <= N; i++) {
        humanRing.add(i);
      }

      System.out.print("<");
      while (true) {
        for (int i = 1; i < K; i++) {
          humanRing.add(humanRing.poll());
        }
        System.out.print(humanRing.poll());
        if (!humanRing.isEmpty()) {
          System.out.print(", ");
        } else {
          System.out.println(">");
          break;
        }
      }
    }
  }

}
