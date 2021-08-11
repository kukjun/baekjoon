package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11000 {

  // s, t 배열을 연결

  public static class S_T {

    private int s;
    private int t;

    public S_T(int s, int t) {
      this.s = s;
      this.t = t;
    }
  }

  public static void main(String[] args) throws Exception {

    // queue 의 배열
    ArrayList<S_T> rooms = new ArrayList<>();
    Queue<S_T> s_t = new PriorityQueue<>(new Comparator<S_T>() {
      @Override
      public int compare(S_T o1, S_T o2) {
        return Integer.compare(o1.s, o2.s);
      }
    });

    Queue<Integer> room = new PriorityQueue<>();


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // n 값 저장
    int n = Integer.parseInt(br.readLine());

    // s, t 값 저장
    for (int i = 0; i < n; i++) {
      String[] arrays = br.readLine().split(" ");
      s_t.offer(new S_T(Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1])));
    }

    while (!s_t.isEmpty()) {
      S_T var = s_t.poll();

      if (!room.isEmpty()) {
        if (room.peek() <= var.s) {
          room.poll();
        }
      }
      room.add(var.t);
    }

    System.out.print(room.size());
    br.close();
  }

}