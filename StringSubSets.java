import java.util.ArrayList;
import java.util.List;

public class StringSubSets {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    subsets("","abc",list);
    //list.remove("");
    System.out.println(list);
  }

  //a,ab,b,bc,c,abc,ac
  static void subsets(String p, String up,List<String> list){
    if(up.isEmpty()){
      if(p == "") return;
      list.add(p);
      return;
    }
    char ch = up.charAt(0);
    subsets(p+ch,up.substring(1),list);
    subsets(p,up.substring(1),list);
  }
}
