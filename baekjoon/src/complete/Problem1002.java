package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1002 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //test case count
    int input1 = Integer.parseInt(br.readLine());

    //user
    int[] user1 = new int[3];
    int[] user2 = new int[3];

    for(int i=0; i<input1; i++) {
      String[] input2 = br.readLine().split(" ");
      user1[0] = Integer.parseInt(input2[0]);
      user1[1] = Integer.parseInt(input2[1]);
      user1[2] = Integer.parseInt(input2[2]);
      user2[0] = Integer.parseInt(input2[3]);
      user2[1] = Integer.parseInt(input2[4]);
      user2[2] = Integer.parseInt(input2[5]);

      //두 점사이의 거리
      double spotToSpot = Math.sqrt( Math.pow(user2[0] - user1[0], 2) + Math.pow(user2[1]-user1[1], 2) );
      int bigR = Math.max(user1[2], user2[2]);
      int smallR = Math.min(user1[2], user2[2]);

      // 경우 나누기

      // 예외, 만약 접점이 같고, 반지름의 크기도 같은 경우
        if(spotToSpot == 0 && bigR == smallR) {
        System.out.println(-1);
      }


      // 한 원 안에 두 원의 원점이 없을 경우
      else if(bigR < spotToSpot) {
        //case1 한 점에서 만나는 경우
        if(spotToSpot == bigR + smallR) {
          System.out.println(1);
        }

        //case2 두 점에서 만나는 경우
        else if(spotToSpot < bigR + smallR) {
          System.out.println(2);
        }

        //case3 안만나는 경우
        else if(spotToSpot > bigR + smallR) {
          System.out.println(0);
        }
      }

      // 한 원 안에 두 원의 원점이 있을 경우
      else {
        //case1 한 점에서 만나는 경우
        if(bigR == spotToSpot + smallR) {
          System.out.println(1);
        }

        //case2 두 점에서 만나는 경우
        else if(bigR < spotToSpot + smallR) {
          System.out.println(2);
        }

        //case3 안만나는 경우
        else if(bigR > spotToSpot + smallR) {
          System.out.println(0);
        }
      }

    }
  }

}
