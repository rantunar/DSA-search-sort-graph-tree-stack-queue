public class ReverseNum {

  public static void main(String[] args) {
    int digit = 104;
    int sum = 0;
    while(digit > 0){
      sum = sum * 10 + (digit%10);
      digit=digit/10;
    }
    System.out.println(sum);
  }
}
