import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphOperation {

  public static void main(String[] args) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    addEdges(adjList,0,1);
    addEdges(adjList,1,3);
    addEdges(adjList,1,2);
    addEdges(adjList,2,3);
    //display(adjList);
    //countVertices(adjList);
    //countEdges(adjList);
    //System.out.println("DFS cycle = "+isCycleGraph(adjList,0,new HashSet<>(),-1));
    System.out.println("DFS find = "+DfsSearch(0,adjList,new HashSet<>(),4));
  }

  static void dfsRecursion(Map<Integer, LinkedList<Integer>> adjList, int src, List<Integer> ans, Set<Integer> visited){
    visited.add(src);
    ans.add(src);
    for(Integer i: adjList.get(src)){
      if(!visited.contains(i))
        dfsRecursion(adjList,i,ans,visited);
    }
  }

  static boolean DfsSearch(int v, Map<Integer, LinkedList<Integer>> adjList, Set<Integer> visited, int n){
    if(v == n) return true;
    visited.add(v);
    for(Integer neighbour : adjList.get(v)){
      if(!visited.contains(neighbour)){
        return DfsSearch(neighbour,adjList,visited,n);
      }
    }
    return false;
  }

  static boolean isCycleGraph(Map<Integer, LinkedList<Integer>> adjList, int src, Set<Integer> visited, int parent){
      visited.add(src);
      for(Integer neighbour : adjList.get(src)){
        if(!visited.contains(neighbour)){
          return isCycleGraph(adjList,neighbour,visited,src);
        }
        else if(parent != neighbour){
          return true;
        }
      }
      return false;
  }

  static boolean dfs(Map<Integer, LinkedList<Integer>> adjList, int src, int dest){
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(src);
    while(!stack.isEmpty()){
      int curr = stack.pop();
      if(!visited.contains(curr)) {
        System.out.print(curr + "->");
        visited.add(curr);
        for (Integer neighbour : adjList.get(curr)) {
          if (!visited.contains(neighbour)) {
            stack.push(neighbour);
          }
        }
      }
    }
    return false;
  }

  static boolean bfs(Map<Integer, LinkedList<Integer>> adjList, int src, int dest, Map<Integer,Integer> destination){
    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);
    set.add(src);
    destination.put(src,0);
    int count = 0;
    while(!queue.isEmpty()){
      int curr = queue.remove();
      count++;
      for(Integer neighbor : adjList.get(curr)){
        if(!set.contains(neighbor)) {
          destination.put(neighbor,count);
          System.out.print(neighbor+"->");
          queue.add(neighbor);
          set.add(neighbor);
        }
      }
    }
    return false;
  }

  static void addEdges(Map<Integer, LinkedList<Integer>> adjList, int source, int destination){
    if(!adjList.containsKey(source)){
      adjList.put(source, new LinkedList<>());
    }
    if(!adjList.containsKey(destination)){
      adjList.put(destination,new LinkedList<>());
    }
    adjList.get(source).add(destination);
    adjList.get(destination).add(source);
  }

  static void countVertices(Map<Integer, LinkedList<Integer>> adjList){
    System.out.println("Vertices Count = "+adjList.keySet().size());
  }

  static void countEdges(Map<Integer, LinkedList<Integer>> adjList){
    int count = 0;
    for(Integer key : adjList.keySet()){
      count = count + adjList.get(key).size();
    }
    System.out.println("Edges Count = "+count/2);
  }

  static void display(Map<Integer, LinkedList<Integer>> adjList)
  {
    StringBuilder builder = new StringBuilder();
    for (Integer v : adjList.keySet())
    {
      builder.append(v.toString() + ": ");
      for (Integer w : adjList.get(v))
      {
        builder.append(w.toString() + " ");
      }
      builder.append("\n");
    }
    System.out.println(builder.toString());
  }

}