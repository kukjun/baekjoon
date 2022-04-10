package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//LCS2
public class Problem9252 {

    class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] X = br.readLine().toCharArray();
        char[] Y = br.readLine().toCharArray();

        // 자동 0 초기화
        int[][] Count = new int[X.length + 1][Y.length + 1];

        // 병목 생기는 부분
        for (int i = 1; i < X.length + 1; i++) {
            for (int j = 1; j < Y.length + 1; j++) {

                if (X[i - 1] == Y[j - 1]) {
                    Count[i][j] = Count[i - 1][j - 1] + 1;
                } else {
                    if (Count[i - 1][j] > Count[i][j - 1]) {
                        Count[i][j] = Count[i - 1][j];
                    } else {
                        Count[i][j] = Count[i][j - 1];
                    }
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        int i = X.length;
        int j = Y.length;

        while (i > 0 && j > 0) {
            if (Count[i][j] == Count[i - 1][j]) {
                i--;
            } else if (Count[i][j] == Count[i][j - 1]) {
                j--;
            } else {
                stack.push(X[i-1]);
                i--;
                j--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(Count[X.length][Y.length]);
        System.out.println(sb.toString());

    }


}
