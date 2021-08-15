package complete;

import java.util.Scanner;

//피보나치 수 2
public class Problem2748 {


  // DP fibonacci
  public static void fibonacci(int n) {
    long[] f = new long[n+1];
      f[0] = 0;
      if(n>=1) {
        f[1] = 1;
        if(n>=2) {
          for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
          }
        }
      }
    System.out.println(f[n]);

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    fibonacci(sc.nextInt());

    // 값의 범위를 초과하는 경우 발생, long 계산
  }


}
