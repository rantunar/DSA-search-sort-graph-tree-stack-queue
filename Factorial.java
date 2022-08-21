public class Factorial {

  public static void main(String[] args) {
    int result = factorial(5);
    System.out.println(result);
    print(6);
  }

  static int factorial(int n){
    if(n==1) return 1;
    if(n==0) return 0;
    return n* factorial(n-1);
  }

  static void print(int n){
    if(n==0) return;
    print(n-1);
    System.out.println(n);
  }

}
