import java.util.ArrayList;
import java.util.List;

public class SubString {

  public static void main(String[] args) {
    String m = "abc";
    String n = m.substring(0,0);

    System.out.println(subString("abc"));

  }

  static List<String> subString(String in){

    List<String> out = new ArrayList<>();
    for(int i=0; i<in.length();i++){
      int count = i+1;
      while(count <= in.length()){
        String x = in.substring(i,count);
        out.add(x);
        count++;
      }
    }
    return out;
  }

}
