package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

// 소트인사이드
public class Problem1427 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        while (N != 0) {
            list.add(N % 10);
            N /= 10;
        }

        Collections.sort(list);
        Collections.reverse(list);

        list.forEach(System.out :: print);

    }
}
