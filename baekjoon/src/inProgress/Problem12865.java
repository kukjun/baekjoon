package inProgress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem12865 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Integer, Integer> objectMap = new HashMap<>();


    // 첫 번째 줄 입력
    String[] input1 = br.readLine().split(" ");
    int N = Integer.parseInt(input1[0]);
    int K = Integer.parseInt(input1[1]);

    // 두번째 줄부터 입력
    for(int i=0; i<N; i++) {
      String[] input2 = br.readLine().split(" ");
      int W = Integer.parseInt(input2[0]);
      int V = Integer.parseInt(input2[1]);

      // 만약 무게가 같은 물건이라면 가치가 큰 것만 저장함.
      if(objectMap.containsKey(W)) {
        if(objectMap.get(W) <= V) {
          objectMap.put(W, V);
        }
      }
      else {
        objectMap.put(W, V);
      }
    }

    int temp;
    for(int i=1; i<=K; i++) {
      if(objectMap.containsKey(i)){
        temp = objectMap.get(i);
      }
      else
      {
        temp = 0;
      }

      for(int j=1; j<i; j++) {
        
      }
    }

  }

}