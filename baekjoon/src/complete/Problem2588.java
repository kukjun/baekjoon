package complete;

import java.util.Scanner;

public class Problem2588 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int y1 = y;

    System.out.println(x*(y1%10));
    y1 /= 10;
    System.out.println(x*(y1%10));
    y1 /= 10;
    System.out.println(x*(y1%10));

    System.out.println(x*y);
  }


}
