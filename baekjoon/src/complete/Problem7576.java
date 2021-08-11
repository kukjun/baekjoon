package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576 {

  public static class SaveIJ {

    int i;
    int j;

    SaveIJ(int i, int j) {
      this.i = i;
      this.j = j;
    }

  }


  public static int[][] box;
  public static boolean[][] visit;

  // BFS 사용시 queue 필요
  //i,j 를 저장
  public static Queue<SaveIJ> queue;

  //배열을 탐색하며 익은 토마토의 인접 토마토 익히기
  public static boolean dayBFS() {

    // 큐에 있는 모든 토마토가 익었을 경우, 예외 처리
    boolean ripeAll = true;

    //큐에 있는 다음 익을 토마토 꺼내기
    SaveIJ[] nextTomato = new SaveIJ[queue.size()];
    for (int i = 0; i < nextTomato.length; i++) {
      nextTomato[i] = queue.poll();
    }

    // 토마토
    for (SaveIJ tomato : nextTomato) {
      // 토마토가 안 익은 경우
      if (box[tomato.i][tomato.j] == 0) {
        ripeAll = false;
        // 토마토를 익게 함
        box[tomato.i][tomato.j] = 1;
        // 익은 토마토 주변 토마토를 큐에 넣음
        inputQueue(tomato.i, tomato.j);
      }
    }
    return ripeAll;
  }

  public static void inputQueue(int i, int j) {

    SaveIJ[] diffusionTomato = new SaveIJ[4];
    diffusionTomato[0] = new SaveIJ(i - 1, j);
    diffusionTomato[1] = new SaveIJ(i + 1, j);
    diffusionTomato[2] = new SaveIJ(i, j + 1);
    diffusionTomato[3] = new SaveIJ(i, j - 1);


    for (int k = 0; k < 4; k++) {

      // 초과하는 경우 제외
      if ((diffusionTomato[k].i >= 0 && diffusionTomato[k].i < box.length) && (diffusionTomato[k].j >= 0 && diffusionTomato[k].j < box[0].length)) {
        if (box[diffusionTomato[k].i][diffusionTomato[k].j] == 0 && !visit[diffusionTomato[k].i][diffusionTomato[k].j]) {
          queue.add(diffusionTomato[k]);
          visit[diffusionTomato[k].i][diffusionTomato[k].j] = true;
        }
      }

    }

  }

  // 토마토 상자 크기 입력 main

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    queue = new ArrayDeque<>();

    //입력 받기
    String input = br.readLine();
    st = new StringTokenizer(input, " ");

    //변수 두개 저장
    int row = Integer.parseInt(st.nextToken());
    int column = Integer.parseInt(st.nextToken());

    // box 만들기
    box = new int[column][row];
    visit = new boolean[column][row];


    // row, column 입력 받기
    for (int i = 0; i < column; i++) {
      input = br.readLine();
      st = new StringTokenizer(input, " ");
      for (int j = 0; j < row; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 모든 토마토가 익은 경우

    boolean noTomato = true;


    // 처음에 익은 토마토 찾기
    for (int i = 0; i < column; i++) {
      for (int j = 0; j < row; j++) {
        if (box[i][j] == 0) {
          noTomato = false;
        }
        if (box[i][j] == 1) {
          inputQueue(i, j);
        }
      }
    }

    // 안익은 토마토가 없다면 0 출력
    if (noTomato) {
      System.out.println(0);

    } else {


      int count = 0;
      while (!queue.isEmpty()) {
        if (!dayBFS()) {
          count++;
        }
      }

      boolean all = true;

      for (int i = 0; i < column; i++) {
        for (int j = 0; j < row; j++) {
          if (box[i][j] == 0) {
            all = false;
            break;
          }
        }
      }

      if (all) {
        System.out.println(count);
      } else {
        System.out.println(-1);
      }
    }
  }

  // 예상 시간초과 목록
  // 1. 큐에 너무많은 입력 들어감
  // 2. 이중 for 문에 반복이 한번 더 들어감 1000*1000*1000?

}
