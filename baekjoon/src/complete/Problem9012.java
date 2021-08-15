package complete;

import java.util.Scanner;
import java.util.Stack;

public class Problem9012 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Stack<Character> stack = new Stack<>();

    int inputDataSize = Integer.parseInt(scanner.nextLine());

    for(int i=0; i< inputDataSize; i++) {
      String data = scanner.nextLine();
      char[] inData = data.toCharArray();

      // 경우의 수 생각하기
      // 1. 스택이 비었는데 ')'가 나옴
      // 2. 끝났는데 스택이 안 비어 있음
      for(char d : inData) {
        // 1.
        if (d == ')') {
          if (stack.isEmpty()) {
            stack.add('E');
            break;
          }
          else {
            stack.pop();
          }
        }
        else if (d == '(') {
          stack.add(d);
        }
      }
      // 2.
      if(stack.isEmpty()) {
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }
      while(!stack.isEmpty()) {
        stack.pop();
      }
    }
  }

}
