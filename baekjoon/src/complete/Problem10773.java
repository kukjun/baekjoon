package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10773 {

  public static void main(String[] args) throws Exception {
    Stack<Integer> stack = new Stack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;

    int k = Integer.parseInt(br.readLine());

    for (int i = 0; i < k; i++) {
      int input = Integer.parseInt(br.readLine());

      if(input == 0) {
        stack.pop();
      }
      else {
        stack.add(input);
      }
    }
    while(!stack.isEmpty()) {
      sum += stack.pop();
    }
    System.out.println(sum);
  }
}
