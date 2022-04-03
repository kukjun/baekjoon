package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 수 정렬하기 3
public class Problem10989 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int[] lines = new int[line];
        int[] sorted = new int[line+1];

        // 개수 파악을 위한 count 배열
        int[] count = new int[10001];

        for (int i = 0; i < line; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            count[lines[i]]++;
        }

        // count 배열 누적합
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < lines.length; i++) {
            sorted[count[lines[i]]--] = lines[i];
        }

        for (int i : sorted) {
            if(i==0) continue;
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }
}
