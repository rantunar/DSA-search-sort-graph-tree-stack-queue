public class RemoveCharSequence {

  public static void main(String[] args) {
    System.out.println(removeCharSeq("","sdapplefasdaapple"));
  }

  static String removeCharSeq(String p , String up){
    if(up.isEmpty()){
      return p;
    }
    char ch = up.charAt(0);
    if(up.startsWith("apple")){
      return removeCharSeq(p,up.substring(5));
    }
    return removeCharSeq(p+ch,up.substring(1));
  }
}
