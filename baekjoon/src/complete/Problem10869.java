package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem10869 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int x = Integer.parseInt(st[0]);
    int y = Integer.parseInt(st[1]);

    System.out.println(x + y);
    System.out.println(x - y);
    System.out.println(x * y);
    System.out.println(x / y);
    System.out.println(x % y);

  }

}
