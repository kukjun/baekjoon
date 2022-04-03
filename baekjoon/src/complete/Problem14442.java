package complete;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 벽 부수고 이동하기
public class Problem14442 {

    public static void main(String[] args) throws IOException {
        class PointXY {
            int x;
            int y;
            int distance;
            int bomb;

            PointXY(int x, int y, int distance, int bomb) {
                this.x = x;
                this.y = y;
                this.distance = distance;
                this.bomb = bomb;
            }
        } // 좌표, 거리, 방문 여부

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<PointXY> queue = new LinkedList<>();

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int bomb = Integer.parseInt(st.nextToken());

        int[][] area = new int[width][height];
//        int[][] visitBomb = new int[width][height]; // 해당 위치의 폭탄 사용 횟수를 저장
        boolean[][][] visit = new boolean[width][height][bomb+1];


        for (int i = 0; i < height; i++) {
            String input = br.readLine();
            for (int j = 0; j < width; j++) {
                area[j][i] = input.charAt(j) - '0';
            }
        } // 경로 정보 입력받기

        queue.add(new PointXY(0, 0, 1, 0));
        visit[0][0][0] = true; // -> 시작 점 방문
        int ans = -1;

        while (!queue.isEmpty()) {
            PointXY check = queue.poll();
            if (check.x == width - 1 && check.y == height - 1) {
                ans = check.distance;
                break;
            }

            for (int force = 0; force < 4; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue; // 범위 초과시 스킵

                if (!visit[nx][ny][check.bomb]) { // 해당 폭탄 개수만큼 사용한 채 방문한 적이 없으면,
                    if (area[nx][ny] == 0) { // 갈 수 있으면
                        visit[nx][ny][check.bomb] = true; // 지나간 표시를 한다.
                        queue.add(new PointXY(nx, ny, check.distance + 1, check.bomb));
                    } else if (area[nx][ny] == 1) { // 벽이 있으면
                        if (check.bomb < bomb) { // 최대 횟수 이전인 경우에만
                            visit[nx][ny][check.bomb] = true; // 벽을 깬다.
                            queue.add(new PointXY(nx, ny, check.distance + 1, check.bomb + 1));
                        }
                    }
                }
            }
        } // bfs

        System.out.println(ans);
        br.close();
    }
}
