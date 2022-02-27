package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 벽 부수고 이동하기
public class Problem2206 {

    // 몇번째인지, 벽을 부순적이 있는지 확인하는 변수 사용
    static class WallAttacker {
        int x, y;
        boolean wallAttack;

        WallAttacker(int x, int y, boolean wallAttacker) {
            this.x = x;
            this.y = y;
            this.wallAttack = wallAttacker;
        }
    }

    static Queue<WallAttacker> queue;
    static boolean[][] wall;
    static boolean[][] visit;
    static boolean[][] wallAttackerVisit;
    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wall = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] wallCheckStrings = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(wallCheckStrings[j]) == 1) {
                    wall[i][j] = true;
                }
            }
        }

        visit = new boolean[N][M];
        wallAttackerVisit = new boolean[N][M];

        queue = new LinkedList<>();
        count = 1;
        queue.add(new WallAttacker(0, 0, false));
        visit[0][0] = true;

        bfs();

        System.out.println(count);

        bw.flush();
        bw.close();
    }

    static void bfs() {

        if (queue.isEmpty()) {
            count = -1;
            return;
        }

        // 벽과 visi t을 고려해서 갈 수 있는 경우에만 추가
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            WallAttacker wallAttacker = queue.poll();


            // 혹시 내가 원하는 값이 나왔다면?
            if (wallAttacker.x == M - 1 && wallAttacker.y == N - 1) {
                return;
            }

            WallAttacker[] cases = new WallAttacker[4];
            cases[0] = new WallAttacker(wallAttacker.x - 1, wallAttacker.y, wallAttacker.wallAttack);
            cases[1] = new WallAttacker(wallAttacker.x + 1, wallAttacker.y, wallAttacker.wallAttack);
            cases[2] = new WallAttacker(wallAttacker.x, wallAttacker.y - 1, wallAttacker.wallAttack);
            cases[3] = new WallAttacker(wallAttacker.x, wallAttacker.y + 1, wallAttacker.wallAttack);


            for (WallAttacker inCase : cases) {
                // 값을 초과하는 범위를 만났을 때
                if (inCase.x < 0 || inCase.x >= M || inCase.y < 0 || inCase.y >= N) {
                    continue;
                }

                // 방문한 경우일 때
                else if (visit[inCase.y][inCase.x]) {
                    continue;
                }

                // 벽을 뚫고 방문한 경우가 있고, 현재 벽을 뚫은 적이 있을 때,
                else if (wallAttackerVisit[inCase.y][inCase.x] && inCase.wallAttack) {
                    continue;
                }


                // 벽을 만났을 때
                else if (wall[inCase.y][inCase.x]) {
                    // 벽 때려봤으면
                    if (inCase.wallAttack) {
                        continue;
                    }
                    // 안 때려 봤으면
                    else {
                        inCase.wallAttack = true;
                    }
                }

                if (!inCase.wallAttack) {
                    visit[inCase.y][inCase.x] = true;
                } else {
                    wallAttackerVisit[inCase.y][inCase.x] = true;
                }
                queue.add(inCase);


            }

        }
        count++;

        bfs();

    }

}
