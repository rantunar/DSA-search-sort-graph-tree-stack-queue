public class ChessBoard {

  public static String run(String start, int R, int C){
    String[][] board = new String[8][8];
    char[] alpha = new char[8];
    alpha[0] = 'a';
    alpha[1] = 'b';
    alpha[2] = 'c';
    alpha[3] = 'd';
    alpha[4] = 'e';
    alpha[5] = 'f';
    alpha[6] = 'g';
    alpha[7] = 'h';
    int row = 8;
    for(int i=0; i<8; i++){
      for(int j=0; j<8 ; j++){
        board[i][j] = row+String.valueOf(alpha[j]);
      }
      row--;
    }

    int index1 = 0,index2 = 0;
    for(int i=0; i<8; i++){
      for(int j=0; j<8 ; j++){
        if(board[i][j].equals(start)) {
          index1 = i;
          index2 = j;
          break;
        }
      }
    }

    if(R >= 8) R = R%8;
    int startRowIndex = index1 -R;
    int endPosRow = startRowIndex < 0 ? 8 + startRowIndex : startRowIndex;

    if(C >= 8) C = C%8;
    int startColIndex = index2 + C;
    int endPosCol = startColIndex > 7 ? 8 - startColIndex : startColIndex;

    return board[endPosRow][endPosCol];
  }

  public static void main(String[] args) {
    System.out.println(ChessBoard.run("7b", 23, 23));
  }
}
