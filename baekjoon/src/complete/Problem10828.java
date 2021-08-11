package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Problem10828 {

  public static void main(String[] args) throws Exception {
    Stack<Integer> stack = new Stack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      st = new StringTokenizer(input, " ");

      if (st.countTokens() == 2) {
        String input1 = st.nextToken();
        int input2 = Integer.parseInt(st.nextToken());

        if (input1.equals("push")) {
          stack.add(input2);
        }
      }
      else {
        String input3 = st.nextToken();

        if (input3.equals("top")) {
          if (stack.isEmpty()) {
            System.out.println("-1");
          }
          else {
            System.out.println(stack.peek());
          }
        } else if (input3.equals("size")) {
          System.out.println(stack.size());
        } else if (input3.equals("empty")) {
          if (stack.isEmpty()) {
            System.out.println("1");
          } else {
            System.out.println("0");
          }
        } else if (input3.equals("pop")) {
          if (stack.isEmpty()) {
            System.out.println("-1");
          } else {
            System.out.println(stack.pop());
          }
        }
      }


    }

  }


}
