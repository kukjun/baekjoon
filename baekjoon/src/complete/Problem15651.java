package complete;

import java.io.*;

// N과 M(3)
public class Problem15651 {
    static int N;
    static int M;
    public static int[] visitList;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] N_M = br.readLine().split(" ");

        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
        visitList = new int[M];

        dfs(N, 0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int N, int depth) throws IOException {
        if (depth == M) {
            for (int var : visitList) {
                bw.write(var + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {

            visitList[depth] = i;
            dfs(N, depth + 1);
            visitList[depth] = 0;
        }
    }
}
