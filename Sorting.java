import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sorting {

  public static void main(String[] args) {
    String str = "pool";
    //String alterStr=new StringBuilder(str).replace(0,str.length(),"*").toString();
    //String cussStar = str.replaceAll(".", "*");
    System.out.println(geD(str));

    LocalDate localDate = LocalDate.of(2022, 07, 15);
    LocalDate newDate = localDate.plusDays(89);
    String x = null;
    String m = str.replace(x != null ? x : "",x != null ? x : "");
    System.out.println(m);
  }

  static String geD(String str){
    return str.replaceAll(".", "*");
  }

  static void quick(int[] arr, int low, int high) {
    if (low >= high)
      return;
    int start = low;
    int end = high;
    int pivot = (start+end)/2;
    while (start<=end){
      while (arr[start] < arr[pivot]){
        start++;
      }
      while(arr[end] > arr[pivot]){
        end--;
      }
      if(start<=end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
      }
    }
    quick(arr,low,end);
    quick(arr,start,high);
  }
}