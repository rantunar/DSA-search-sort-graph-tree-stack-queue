import java.util.Scanner;

public class BinaryTree {

  static Scanner sc = null;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Node node = createTree();
    System.out.println("Height = "+height(node));
    System.out.println("Size = "+size(node));
    System.out.println("Max = "+max(node));
    System.out.println("Min = "+min(node));
  }

  static int min(Node root){
    if(root == null) return Integer.MAX_VALUE;
    return Math.min(root.data,Math.min(min(root.left),min(root.right)));
  }

  static int size(Node root){
    if(root == null) return 0;
    return size(root.left) + size(root.right) + 1;
  }

  static int max(Node root){
    if(root == null) return Integer.MIN_VALUE;
    return Math.max(root.data,Math.max(max(root.left),max(root.right)));
  }

  static void inOrder(Node root){
    if(root == null) return;
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
  }

  static int height(Node root){
    if(root == null) return 0;
    return Math.max(height(root.left),height(root.right))+1;
  }

  static Node createTree(){

    Node root = null;
    System.out.println("Enter data");
    int data = sc.nextInt();
    if(data == -1) return null;

    root = new Node(data);
    System.out.println("Enter Left Node");
    root.left = createTree();
    System.out.println("Enter right Node");
    root.right = createTree();
    return root;
  }
}

class Node{
  int data;
  Node left;
  Node right;
  public Node(int data){
    this.data = data;
    left = null;
    right = null;
  }
}
