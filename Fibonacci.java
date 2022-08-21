public class Fibonacci {

  static int[] memo = new int[25];

  public static void main(String[] args) {
    print(4);
    //System.out.println(result);
    for(int i =0; i<4;i++){
      //System.out.println(memo[i]);
    }
  }

  static void print(int n){
    if(n==0) return;
    print(n-1);
    System.out.println(n);
  }

  //0,1,1,2,3,5,8
  static int fibo(int n){
    if(n<=1){
      memo[n] = n;
      return n;
    }
    if(memo[n] != 0) return memo[n];
    int fibo = fibo(n-1)+fibo(n-2);
    memo[n] = fibo;
    return fibo;
  }

  //0,1,1,2,3,5,8
  static int fiboIteration(int n){
    memo[0] = 0;
    memo[1] = 1;
    for(int i=2;i<n;i++){
        memo[i] = memo[i-1] + memo[i-2];
    }
    return memo[n-1];
  }
}
