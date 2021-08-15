package complete;

import java.io.BufferedReader;
import java.util.Scanner;

public class Problem10430 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] input = scanner.nextLine().split(" ");

    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);

    System.out.println((a+b)%c);
    System.out.println(((a%c)+(b%c))%c);
    System.out.println((a*b)%c);
    System.out.println(((a%c)*(b%c))%c);

  }

}
