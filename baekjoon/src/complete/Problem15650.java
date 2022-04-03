package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// N과 M(2)
public class Problem15650 {
    static int N;
    static int M;
    public static int[] visitList;
    public static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        String[] N_M = br.readLine().split(" ");

        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
        visit = new boolean[N+1];
        visitList = new int[M];

        dfs(N, 0);
    }

    public static void dfs(int N, int depth) {
        if (depth == M) {
            for (int var : visitList) {
                System.out.print(var + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 첫번째 깊이가 아닌 경우 중에서 만약에 이전에 입력했던 배열의 값보다 작은 경우에는 제외
            if (depth != 0) {
                if (i < visitList[depth-1]) {
                    continue;
                }
            }

            // 방문하지 않은 경우 절차 실행
            if (!visit[i]) {
                visitList[depth] = i;
                visit[i] = true;
                dfs(N, depth+1);
                visit[i] = false;
                visitList[depth] = 0;
            }
        }
    }
}
