package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Problem1012 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] land;
    static int N, M, K, T;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 가로가 M, 세로가 N
            land = new int[M][N];

            for (int i = 0; i < K; i++) {
                int x, y;
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                land[x][y] = 1;

            }

            for (int x = 0; x < land.length; x++) {
                for (int y = 0; y < land[0].length; y++) {
                    if (land[x][y] == 1) {
                        count++;
                        land[x][y] = 0;
                        findCabbage(new Point(x, y));
                    }
                }
            }

            bw.write(count + "\n");
            count = 0;
        }

        bw.flush();
        bw.close();

    }

    // dfs
    static void findCabbage(Point point) {
        // 경우의 수
        Point[] cases = new Point[4];
        cases[0] = new Point(point.x - 1, point.y);
        cases[1] = new Point(point.x + 1, point.y);
        cases[2] = new Point(point.x, point.y-1);
        cases[3] = new Point(point.x, point.y+1);

        for (Point innerPoint : cases) {
            if (innerPoint.x < 0 || innerPoint.x >= M || innerPoint.y < 0 || innerPoint.y >= N) {
                continue;
            }
            if (land[innerPoint.x][innerPoint.y] == 1) {
                land[innerPoint.x][innerPoint.y] = 0;
                findCabbage(innerPoint);
            }
        }
    }
}
