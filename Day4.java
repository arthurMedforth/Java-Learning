import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.util.ArrayList;

public class Day4 {

    public static ArrayList<String[]> updateBoardStates(ArrayList<String[]> bingoBoards, String numberCalled){
      String[][] currentBoardState;
      String[][] newBoardState = new String[5][5]
      for (int i; i < bingoBoards.size(); i++){
        currentBoard = bingoBoards.get(i);
        
      }

      return bingoBoards;
    }

    public static ArrayList<String[][]> getBingoBoards(String[] stringArr){

      ArrayList<String[][]> bingoBoards = new ArrayList<String[][]>();
      String[][] bingoBoard = new String[5][5];
      // PARSE BINGO CARDS
      // Loop through following lines (stringArr indices)
      // String[] noSpaceStringArr = stringArr
      int n = 0;
      for (int k = 1; k < stringArr.length; k++){
        if (stringArr[k] == ""){
          n = 0;
          bingoBoard = new String[5][5];
          continue;
        }else{
          String currentRow = stringArr[k];
          String[] splitBingoBoardRow = currentRow.split("\\s+");
          
          int initCond;
          int breakCond;
          if (splitBingoBoardRow.length>5){
            initCond = 1;
            breakCond = 6;
          }else{
            initCond = 0;
            breakCond = 5;   
          }
          for (int m = initCond; m < breakCond; m++){
            if (initCond == 0){
              bingoBoard[n][m] = splitBingoBoardRow[m];
            }else{
              bingoBoard[n][m-1] = splitBingoBoardRow[m];
            }
          }
          n++;
        }
        if (n==5){
          bingoBoards.add(bingoBoard);
        }else{
          continue;
        }
      }
      return bingoBoards;
    }

    public static String[] parseInput(){
      int count = 0;
      try {
        // create a new file object
        File file = new File("input.txt");
        // create an object of Scanner
        // associated with the file
        Scanner sc1 = new Scanner(file);
        // read each line and
        // count number of lines
        while(sc1.hasNext()) {
          sc1.nextLine();
          count++;
        }
        String[] stringArray = new String[count];
        Scanner sc2 = new Scanner(file);
  
        int i = 0;

        for (int j = 0; j<count; j++){
          if (sc2.hasNextLine()){
            stringArray[i++] = sc2.nextLine();
          }else{
            if (sc2.hasNext() && sc2.hasNextLine()){
              stringArray[i++] = "-1";
            }
          }

        }

        sc1.close();
        sc2.close();

        return stringArray;

      } catch(Exception e){
          e.printStackTrace();

      }
      return null;

    }

    public static void main(String[] args) {
      // Retrieve input from txt file
      String[] stringArr = parseInput();

      // Get bingo calls on first line of input file
      String bingoCallsString = stringArr[0];
      String[] bingoCallsSplit = bingoCallsString.split("\",");

      // Populate ArrayLists with board states
      ArrayList<String[][]> bingoBoards = getBingoBoards(stringArr);

      System.out.println(Arrays.toString(bingoCallsSplit));
      System.out.println(Arrays.deepToString(bingoBoards.get(0)));

      // Loop bingo calls

      // Function to convert numbers on boards to 
      // identifier "called out" if containing called out number

      // Function to check for rows or columns of "called out" identifiers

    }
}
