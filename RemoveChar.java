public class RemoveChar {

  public static void main(String[] args) {
    System.out.println(removeString("applecappledapple","apple"));
  }

  static String removeString(String in, String x){
    StringBuilder out = new StringBuilder();
    for(int i=0; i<in.length();i++){
      if(!in.substring(i).startsWith(x)){
        out.append(in.charAt(i));
      }
      else{
        i = i+x.length()-1;
      }
    }
    return out.toString();
  }
}
