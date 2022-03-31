package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 좌표 정렬하기 2
public class Problem11651 {
    static class XY implements Comparable<XY> {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(XY o) {
            if (y > o.y) {
                return 1;
            }
            if (y == o.y) {
                if (x > o.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<XY> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        list.forEach(System.out :: println);

    }
}
