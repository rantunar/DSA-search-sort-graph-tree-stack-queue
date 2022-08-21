import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class LevelOrderTraversal {

  static Scanner sc = null;
  static NodeLink head, tail;
  static int count = 0;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Node node = createTree();
    List<Integer> arr = new ArrayList<>();
    //bstDelete(node,20);
    //System.out.print(insertBstIterator(node,7));
    //traversal(node);
    //System.out.print(bstSearch(node,25).data);
    //recursiveTraversal(node);
    //display();
    rightView(node);
  }

  static Node bstDelete(Node root,int n){
    if(root == null) return null;
    if(root.data > n){
      root.left = bstDelete(root.left,n);
    }
    else if(root.data < n){
      root.right = bstDelete(root.right,n);
    }
    else{
      if(root.left == null) return root.right;
      else if(root.right == null) return root.left;

      root.data = minValue(root.right);
      root.right = bstDelete(root.right, root.data);
    }
    return root;
  }

  static int minValue(Node root){
    int minValue = Integer.MIN_VALUE;
    while(root != null){
      minValue = root.data;
      root = root.left;
    }
    return minValue;
  }

  static void bstSumOfPair(Node root, int sum, Set<Integer> set, List<Integer> arr){
    if(root == null) return;
    bstSumOfPair(root.left,sum,set,arr);
    if(set.contains(sum-root.data)){
      arr.add(sum-root.data);
      arr.add(root.data);
    }else{
      set.add(root.data);
    }
    bstSumOfPair(root.right,sum,set,arr);
  }

  static void checkBst(Node root, List<Integer> arr){
    if(root == null) return;
    checkBst(root.left,arr);
    arr.add(root.data);
    checkBst(root.right,arr);
  }

  static Node insertBstIterator(Node root, int n){
    Node newNode = new Node(n);
    if(root == null) return newNode;
    Node curr = root;
    Node parent = null;
    while(curr != null){
      parent = curr;
      if(curr.data > n){
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    if(parent.data > n){
      parent.left = newNode;
    }
    else{
      parent.right = newNode;
    }
    return parent;
  }

  static Node insertBst(Node root, int n){
    if(root == null) return new Node(n);
    if(root.data > n){
      root.left = insertBst(root.left,n);
    } else if(root.data < n) {
      root.right = insertBst(root.right, n);
    }
    return root;
  }

  static Node bstSearch(Node root, int n){
    if(root == null) return null;
    if(root.data == n) return root;
    if(root.data > n){
      return bstSearch(root.left,n);
    }
    return bstSearch(root.right,n);
  }

  static int lowestCommonParent(Node root, int m, int n){
    if(root == null) return -1;
    if(root.data == m || root.data == n) return root.data;
    int left = lowestCommonParent(root.left,m,n);
    int right = lowestCommonParent(root.right,m,n);
    if(left == -1) return right;
    else if(right == -1) return left;
    return root.data;
  }

  static int diameter(Node root){
    if(root == null) return 0;
    int left = diameter(root.left);
    int right = diameter(root.right);
    int height = height(root.left) + height(root.right)+1;
    return Math.max(height,Math.max(left,right));
  }

  static int height(Node root){
    if(root == null) return 0;
    return Math.max(height(root.left),height(root.right))+1;
  }

  static void display(){
    NodeLink curr = head;
    while (curr != null){
      System.out.print(curr.data+"->");
      curr = curr.next;
    }
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

  static void traversal(Node root){
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while(!queue.isEmpty()){
      Node temp = queue.remove();
      if(temp == null){
        if(queue.isEmpty()) return;
        queue.add(null);
        System.out.println();
        continue;
      }
      System.out.print(temp.data + " ");
      if(temp.left != null){
        queue.add(temp.left);
      }
      if(temp.right != null){
        queue.add(temp.right);
      }
    }
  }

  static void leftView(Node root){
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    System.out.println(root.data + " ");
    boolean flag = false;
    while(!queue.isEmpty()){
      Node temp = queue.remove();
      if(temp == null){
        if(queue.isEmpty()) return;
        queue.add(null);
        System.out.println();
        flag = true;
        continue;
      }
      if(flag)
        System.out.println(temp.data);
      if(temp.left != null){
        queue.add(temp.left);
      }
      if(temp.right != null){
        queue.add(temp.right);
      }
      flag = false;
    }
  }

  static void rightView(Node root){
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    System.out.println(root.data + " ");
    boolean flag = false;
    while(!queue.isEmpty()){
      Node temp = queue.remove();
      if(temp == null){
        if(queue.isEmpty()) return;
        queue.add(null);
        System.out.println();
        flag = true;
        continue;
      }
      if(flag)
        System.out.println(temp.data);
      if(temp.right != null){
        queue.add(temp.right);
      }
      if(temp.left != null){
        queue.add(temp.left);
      }
      flag = false;
    }
  }

  static void recursiveTraversal(Node root){
    if(root == null) return;
    recursiveTraversal(root.left);
    NodeLink newNode = new NodeLink(root.data);
    if(head == null){
      head = newNode;
      tail = newNode;
    }
    else{
      tail.next = newNode;
      newNode.prev = tail;
      tail = tail.next;
    }
    recursiveTraversal(root.right);
  }

  static int depthOfNode(Node root, int n){
    if(root == null) return Integer.MIN_VALUE;
    if(root.data == n) return 0;

    return Math.max(depthOfNode(root.left,n),depthOfNode(root.right,n))+1;
  }
}

class NodeLink {
  int data;
  NodeLink next;
  NodeLink prev;
  public NodeLink(int data){
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}