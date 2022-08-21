public class ReduceToZero {

  static int step = 0;
  public static void main(String[] args) {
    reduceZero(14);
    System.out.println(step);
  }

  static void reduceZero(int n){
    if(n<=0) return;
    if(n%2==0){
      step++;
      reduceZero(n/2);
    }
    else{
      step++;
      reduceZero(n-1);
    }
  }
}
