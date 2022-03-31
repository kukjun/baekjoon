package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 단어 정렬
public class Problem1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        Arrays.stream(strings)
                .sorted((o1, o2) -> {
                    if(o1.length()>o2.length()) return 1;
                    else if(o1.length()==o2.length()) {
                        return o1.compareTo(o2);
                    } else return -1;
                })
                .distinct()
                .forEach(System.out::println);


    }
}
