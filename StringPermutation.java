public class StringPermutation {

  public static void main(String[] args) {
    permutation("","abc");
  }

  static void permutation(String p, String up){
    if(up.isEmpty()){
      System.out.println(p);
      return;
    }

    char ch = up.charAt(0);
    for(int i=0;i<=p.length();i++){
      String first = p.substring(0,i);
      String last = p.substring(i,p.length());
      permutation(first+ch+last, up.substring(1));
    }
  }
}
