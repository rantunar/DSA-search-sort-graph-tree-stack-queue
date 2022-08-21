public class CountZeros {

  static int count = 0;
  public static void main(String[] args) {
    getZeros(1000003);
    System.out.println(count);
  }

  static void getZeros(int n){
    if(n==0) return;
    if(n%10 == 0) count++;
    getZeros(n/10);
  }
}
