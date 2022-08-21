public class RemoveCharRecursion {

  public static void main(String[] args) {

    System.out.println(removeChar("","sdfasda"));
  }

  static String removeChar(String p, String up){
    if(up.isEmpty()){
      return p;
    }
    char ch = up.charAt(0);
    if(ch == 'a'){
      return removeChar(p,up.substring(1));
    }
    return removeChar(p+ch,up.substring(1));
  }

}
