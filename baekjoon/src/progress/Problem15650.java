package progress;

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

        bfs(N, 0);
    }

    public static void bfs(int N, int depth) {
        if (depth == M) {
            for (int var : visitList) {
                System.out.print(var + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (depth != 0) {
                if (i < visitList[depth-1]) {
                    continue;
                }
            }

            if (!visit[i]) {
                visitList[depth] = i;
                visit[i] = true;
                bfs(N, depth+1);
                visit[i] = false;
                visitList[depth] = 0;
            }
        }
    }
}
