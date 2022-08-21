import java.util.Stack;

public class BracketBalancing {

  public static void main(String[] args) {
    System.out.println("Valid Bracket -> "+isBracketBalanced("[([{}])]"));
  }

  static boolean isBracketBalanced(String x){
    if(x == null) return false;
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i<x.length(); i++){
      if(isOpeningBracket(x.charAt(i))){
        stack.push(x.charAt(i));
      }
      else{
        char n = stack.peek();
        if(!isMatching(n,x.charAt(i))) return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  static boolean isOpeningBracket(char x){
    return x == '(' || x == '[' || x == '{';
  }

  static boolean isMatching(char x1, char x2){
    return (x1 == '[' && x2 == ']') || (x1 == '{' && x2 == '}') || (x1 == '(' && x2 == ')');
  }
}
