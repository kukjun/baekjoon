package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 나이트의 이동
public class Problem7562 {

    public static int[][] visit;
    public static Queue<Integer> queue = new LinkedList<>();
    public static int[] nightLocation = new int[2];
    public static int[] requireLocation = new int[2];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount;
        int sideLength;


        // caseCount 입력
        caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            // input
            sideLength = Integer.parseInt(br.readLine());

            String[] nightLocationString = br.readLine().split(" ");
            nightLocation[0] = Integer.parseInt(nightLocationString[0]);
            nightLocation[1] = Integer.parseInt(nightLocationString[1]);

            String[] requireLocationString = br.readLine().split(" ");
            requireLocation[0] = Integer.parseInt(requireLocationString[0]);
            requireLocation[1] = Integer.parseInt(requireLocationString[1]);

            // 입력을 기반으로 상황설정
            visit = new int[sideLength][sideLength];
            if (nightLocation[0] == requireLocation[0] && nightLocation[1] == requireLocation[1]) {
                System.out.println("0");
            } else {
                queue.add(nightLocation[0]);
                queue.add(nightLocation[1]);

                // 입력 기반으로 BFS 실행하고, BFS 끝나면 진행횟수를 반환
                int depth = 0;
                bfs(depth);
                System.out.println(visit[requireLocation[0]][requireLocation[1]]);
            }
        }
    }

    public static void bfs(int depth) {

        int x = queue.poll();
        int y = queue.poll();

        // 만약 찾은 경우
        if (x == requireLocation[0] && y == requireLocation[1]) {
            queue.clear();
            return;
        }
        // 아닌 경우
        else {
            // 경우의 수 8개 int 배열로 만들기
            int[][] results = new int[8][2];

            results[0][0] = x - 2;
            results[0][1] = y + 1;

            results[1][0] = x - 2;
            results[1][1] = y - 1;

            results[2][0] = x - 1;
            results[2][1] = y + 2;

            results[3][0] = x - 1;
            results[3][1] = y - 2;

            results[4][0] = x + 1;
            results[4][1] = y + 2;

            results[5][0] = x + 1;
            results[5][1] = y - 2;

            results[6][0] = x + 2;
            results[6][1] = y + 1;

            results[7][0] = x + 2;
            results[7][1] = y - 1;

            // 큐에다가 나머지 넣기
            for (int[] result : results) {
                // 범위 밖의 숫자인 경우
                if (!(result[0] >= 0 && result[0] < visit[0].length && result[1] >= 0 && result[1] < visit[0].length)) {
                    continue;
                }
                // 범위 안에 있고 방문하지 않은 경우
                if (visit[result[0]][result[1]] == 0) {
                    queue.add(result[0]);
                    queue.add(result[1]);
                    visit[result[0]][result[1]] = visit[x][y] + 1;
                }
            }

            bfs(depth + 1);
        }
    }

}
