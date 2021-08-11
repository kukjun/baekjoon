package inProgress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1068 {

  public static int leafNode;

  // Node 만들기
  public static class Node {

    private int data;

    private ArrayList<Node> child;

    public Node(int data) {
      this.data = data;
      this.child = new ArrayList<>();
    }

  }

  // Tree 만들기
  public static class Tree {

    ArrayList<Node> root;

    public Tree() {
      root = new ArrayList<>();
    }

    //method
    public void insertNode(int data, int count) {
      // root 가 빈 경우 예외처리
      if (data == -1) {
        root.add(new Node(count));
      } else {
        // root 부터 넣기
        if (root.size() != 0) {
          for (Node node : root) {
            insertNodeInside(node, data, count);
          }
        }
        else {
          root.add(new Node(data));
          for(Node node : root) {
            insertNodeInside(node, data, count);
          }
        }
      }
    }

    private static void insertNodeInside(Node node, int data, int count) {
      if (node.data == data) {
        Node newNode = new Node(count);
        node.child.add(newNode);
      } else {
        if (node.child.size() != 0) {
          for (Node inNode : node.child) {
            insertNodeInside(inNode, data, count);
          }
        }
      }
    }

    public void deleteNode(int data) {
      if (data == 0) {
        root = null;
      } else {
        if (root.size() != 0) {
          for (Node node : root) {
            if(node.data == data) {
              root.remove(node);
              return;
            }
            deleteNodeInside(node, data);
          }
        }
      }
    }

    private static void deleteNodeInside(Node node, int data) {
      if(node.child.size() != 0) {
        for (Node inNode : node.child) {
          if (inNode.data == data) {
            node.child.remove(inNode);
            return;
          }
          deleteNodeInside(inNode, data);
        }
      }
    }

    public int readLeafNode() {
      leafNode = 0;
      if (root == null) {
        return 0;
      } else {
        if (root.size() != 0) {
          for (Node node : root) {
            readLeafNodeInside(node);
          }
        } else {
          leafNode++;
        }
      }
      return leafNode;
    }

    private void readLeafNodeInside(Node node) {
      if(node.child.size() == 0) {
        leafNode++;
      }
      else {
        for (Node inNode : node.child) {
          readLeafNodeInside(inNode);
        }
      }
    }

  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int d1 = Integer.parseInt(br.readLine());

    String[] s2 = br.readLine().split(" ");
    int[] d2 = new int[s2.length];
    Tree tree = new Tree();
    for(int i=0; i<d1; i++) {
      d2[i] = Integer.parseInt(s2[i]);
      tree.insertNode(d2[i], i);
    }

    int d3 = Integer.parseInt(br.readLine());
    tree.deleteNode(d3);

    System.out.println(tree.readLeafNode());
    br.close();

  }
}