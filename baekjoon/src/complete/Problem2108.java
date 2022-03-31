package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

// 통계학
public class Problem2108 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        int[] lines = new int[line];
        int[] sorted = new int[line + 1];

        // 개수 파악을 위한 count 배열
        int[] count = new int[8001];

        // 산술평균
        int average = 0;
        // 중앙값
        int middleValue = 0;
        // 최빈값들
        List<Integer> machValues = new LinkedList<>();
        int machValue = 0;
        // 범위
        int range = 0;

        // 4000을 다 더해서 계산
        for (int i = 0; i < line; i++) {
            lines[i] = Integer.parseInt(br.readLine()) + 4000;
            count[lines[i]]++;
        }

        // 최빈값 계산
        int max = 1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                machValues.clear();
                machValues.add(i);
            } else if (count[i] == max) {
                machValues.add(i);
            }
        }

        // count 배열 누적합
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // counting 정렬
        for (int i = 0; i < lines.length; i++) {
            sorted[count[lines[i]]--] = lines[i];
        }

        // 산술 평균
        int sum = 0;
        for (int i = 1; i < sorted.length; i++) {
            sum += (sorted[i] - 4000);
        }
        average = (int) (Math.round(sum / (double) (sorted.length - 1))); // Math 함수로 반올림
        sb.append(average).append("\n");

        // 중앙값
        middleValue = sorted[sorted.length / 2] - 4000;
        sb.append(middleValue).append("\n");

        // 최빈 값
        if (machValues.size() == 1) {
            machValue = machValues.get(0) - 4000;
        } else {
            machValue = machValues.get(1) - 4000;
        }
        sb.append(machValue).append("\n");

        // 범위
        range = sorted[sorted.length - 1] - sorted[1];
        sb.append(range);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
