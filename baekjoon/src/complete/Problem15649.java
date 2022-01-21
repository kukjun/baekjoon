package complete;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem15649 {

  public static int[] arr;
  public static boolean[] visit;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    arr = new int[M];
    visit = new boolean[N];
    dfs(N, M, 0);


  }


  public static void dfs(int N, int M, int depth) {

    // 재귀 깊이가 M과 같아지면 탐색 과정에서 담았던 배열을 출력
    if(depth == M) {
      for(int var : arr) {
        System.out.print(var + " ");
      }
      System.out.println();
      return;
    }

    for(int i=0; i<N; i++) {
      if(!visit[i]) {

        visit[i] = true;
        arr[depth] = i+1;
        dfs(N, M, depth + 1);

        visit[i] = false;
      }
    }
    return;
  }

}
