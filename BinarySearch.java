public class BinarySearch {

  public static void main(String[] args) {

    int[][] matrix = {{2,4,1},{5,6,1},{6,7,1},{6,7,1}};
    System.out.println(matrix[0].length);

    int[] arr = {6,7,8,9,1,2,3,4,5};
    boolean isAsc = arr[0] < arr[arr.length-1];
    int result = rotateBinarySearch(arr,67);
    //System.out.println(result);
  }

  static int rotateBinarySearch(int[] arr, int target){
    int start = 0;
    int end = arr.length-1;
    while (start<=end){
      int mid = (start+end)/2;
      if(arr[mid] > arr[mid+1]){
        return mid;
      }
      if(arr[start] > arr[mid]){
        end = mid -1;
      }
      else{
        start = mid +1;
      }
    }
    return -1;
  }


  static int mountainPeak(int[] arr, int target, int start, int end){
    while(start <= end){
      int mid = (start+end)/2;

      //asc section
      if(arr[mid] < arr[mid+1]){
        start = mid+1;
      }
      else{
        end = mid;
      }
    }
    return start;
  }
  static int searchInfiniteArray(int[] arr, int target){
    int start = 0;
    int end = 1;

    while(target > arr[end]){
      int newstart = end + 1;
      end = 2*(end-start+1)+end;
      start = newstart;
    }
    int result = binarySearch(arr,target,start,end);
    return result;
  }


  static int binarySearch(int[] arr, int target, int start, int end){

    while(start <= end){
      int mid = (start+end)/2;
      if(arr[mid] == target){
        return mid;
      }
      if (target > arr[mid])
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }

  static int binarySearch2(int[] arr, int target, boolean isAsc){

    int start = 0;
    int end = arr.length-1;
    int st = -1;
    while(start <= end){
      int mid = (start+end)/2;
      if (target > arr[mid])
        start = mid + 1;
      else if(target < arr[mid])
        end = mid - 1;
      else{
        st= mid;
        start = mid +1;
      }
    }
    return st;
  }
}
