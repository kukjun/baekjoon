package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 바이러스
public class Problem2606 {

  public static class Node {
    public ArrayList<Integer> arrayList;
    public Node() {
      arrayList = new ArrayList<>();
      visit = false;
    }
    public boolean visit;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    //첫째 줄 입력
    int input1 = Integer.parseInt(br.readLine());
    Node[] com = new Node[input1+1];
    for(int i=1; i<=input1; i++) {
      com[i] = new Node();
    }


    //둘째 줄 입력
    int input2 = Integer.parseInt(br.readLine());

    for(int i=0; i<input2; i++) {
      //세번째 줄부터 입력
      st = new StringTokenizer(br.readLine(), " ");
      int front = Integer.parseInt(st.nextToken());
      int back = Integer.parseInt(st.nextToken());

      com[front].arrayList.add(back);
      com[back].arrayList.add(front);
    }

    // 정보 가공
    com[1].visit = true;
    int count=0;

    ArrayDeque<Integer> queue = new ArrayDeque<>(com[1].arrayList);
    while(!queue.isEmpty()) {
      if(!com[queue.peek()].visit) {
        int link = queue.poll();
        com[link].visit = true;
        queue.addAll(com[link].arrayList);
        count++;
      }
      else{
        queue.poll();
      }
    }
    System.out.println(count);

  }
}
