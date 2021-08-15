package complete;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem2075 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Queue<Integer> pQ = new PriorityQueue<>();

    int[][] dataSet;
    int n = Integer.parseInt(br.readLine());
    dataSet = new int[n][n];

    for(int i=0; i<n;i++) {
      String[] str = br.readLine().split(" ");
      for(int j=0; j<n; j++) {
        dataSet[i][j] = Integer.parseInt(str[j]);
      }
    }




    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        if(pQ.isEmpty()) {
          pQ.add(dataSet[i][j]);
        } else {
          if(pQ.peek() <= dataSet[i][j]) {
            pQ.offer(dataSet[i][j]);
          }
          if(pQ.size() > n) {
            pQ.poll();
          }
        }
      }
    }

    System.out.println(pQ.peek());
    br.close();
    bw.close();

  }

}
