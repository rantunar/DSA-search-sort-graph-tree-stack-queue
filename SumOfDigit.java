public class SumOfDigit {

  static int sum = 0;
  public static void main(String[] args) {
    sum(1011114);
    System.out.println(sum);
  }

  static void sum(int n){
    if(n==0) return;
    sum = sum * 10 + (n%10);
    sum(n/10);
  }
}
