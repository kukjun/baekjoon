package complete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2164 {

  public static void main(String[] args) {
    Queue<Integer> cards = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
//    if (input >= 1 && input <= 500000) {

      // 카드 덱 생성
      for (int i = 1; i <= input; i++) {
        cards.add(i);
      }

      while (cards.size() != 1) {
        System.out.println(cards);
        cards.poll();
        cards.add(cards.poll());
      }

      System.out.println(cards.poll());

    }
//  }

}
