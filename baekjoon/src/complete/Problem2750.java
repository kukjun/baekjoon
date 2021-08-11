package complete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem2750 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input1 = Integer.parseInt(br.readLine());

    ArrayList<Integer> al = new ArrayList<>();

    for(int i=0; i<input1; i++) {
      int input2 = Integer.parseInt(br.readLine());
      if(!al.contains(input2)) {
        al.add(input2);
      }
    }

    Collections.sort(al);

    for(int i : al) {
      System.out.println(i);
    }
  }

}
