package complete;
import java.util.*;

public class Problem1068 {

    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 노드 개수 입력 받기
        n = scan.nextInt();
        parent = new int[n];


        int root = 0;
        // 입력받은 노드의 부모노드 처리
        for(int i = 0; i < n; i++) {
            parent[i] = scan.nextInt();
            // 만약 루트 노드를 입력받으면, root 변수를 i로 변경
            if(parent[i] == -1) root = i;
        }
        delete = scan.nextInt();

        deleteNode(delete);

        count = 0;
        visited = new boolean[n];
        // 루트 노드부터 반복
        countLeaf(root);

        System.out.println(count);
    }

    public static void deleteNode(int d) {
        parent[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < n; i++) {
            // 만약 지금 지운 노드를 부모로 가지는 노드가 있다면, 해당 노드도 제거
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visited[s] = true;
        // 만약 지워지지 않은 노드라면 반복
        if(parent[s] != -2) {
            for(int i = 0; i < n; i++) {
                // 만약
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}
