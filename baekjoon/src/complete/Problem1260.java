package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Problem1260 {
    static int N;
    static int M;
    static int V;
    static Queue<Integer> queue;
    static boolean[] visit;
    static boolean[][] line;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        line = new boolean[N][N];
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            line[num1-1][num2-1] = true;
            line[num2-1][num1-1] = true;
        }

        // output
        dfs(V-1);
        System.out.println();

        // 초기화
        for (int i = 0; i < N; i++) {
            visit[i] = false;
        }
        queue.add(V-1);
        bfs();
    }

    static void dfs(int v) {
        System.out.print(v+1 + " ");
        visit[v] = true;
        for (int i = 0; i < N; i++) {
            if (line[v][i] && !visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if(!visit[num]) {
                System.out.print(num + 1 + " ");
                visit[num] = true;
            }

            for (int i = 0; i < N; i++) {
                if (line[num][i] && !visit[i]) {
                    queue.add(i);
                }
            }
        }
    }
}