import java.io.File;  // Import the File class
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ListIterator;  
import java.util.List;

public class Day4a {

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

    public static ArrayList<String[][]> updateBoardStates(ArrayList<String[][]> bingoBoards, String numberCalled){
      // Loop boards
      String[][] newBoardState;
      String[][] currentBoardState;

      for(int iterator = 0; iterator < bingoBoards.size(); iterator++) {

        currentBoardState = bingoBoards.get(iterator);
        newBoardState = new String[5][5];
        // Loop rows
        for (int i = 0; i < 5; i++){
          // Loop cols
          for (int j = 0; j < 5; j++){

            if (currentBoardState[i][j].equals(numberCalled)){
              newBoardState[i][j] = "X";
            }else{
              newBoardState[i][j] = currentBoardState[i][j];
            }
          }
        }
        bingoBoards.set(iterator, newBoardState);
      }

      return bingoBoards;
    }


    public static int checkForWinner(ArrayList<String[][]> bingoBoards){
      String[][] currentBoardState = new String[5][5];
      String[] rowWinState = {"X","X","X","X","X"};
      int resultCode = -1;
      for(int iterator = 0; iterator < bingoBoards.size(); iterator++) {
        currentBoardState = bingoBoards.get(iterator);
        for (int i = 0; i < 5; i++){
          for (int j = 0; j < 5; j++){
            // if (currentBoardState[i][0]=="X"&&currentBoardState[i][1]=="X"&&currentBoardState[i][2]=="X"&&currentBoardState[i][3]=="X"&&currentBoardState[i][4]=="X"){
            if (Arrays.equals(currentBoardState[i],rowWinState)){
              resultCode = iterator;
              return resultCode;
            }else if(currentBoardState[0][j]=="X" && currentBoardState[1][j]=="X" && currentBoardState[2][j]=="X" && currentBoardState[3][j]=="X" && currentBoardState[4][j]=="X"){
              resultCode = iterator;
              return resultCode;
            }else{
              continue;
            }
          }
        }
      }
      return resultCode;
    }

    public static void main(String[] args) {
      // Retrieve input from txt file
      String[] stringArr = parseInput();

      // Get bingo calls on first line of input file
      String bingoCallsString = stringArr[0];
      String[] bingoCallsSplit = bingoCallsString.split(",");

      // Populate ArrayLists with board states
      ArrayList<String[][]> bingoBoards = getBingoBoards(stringArr);

      int resultCode = -1;
      int winNumber = 0;
      // Loop bingo calls
      for (String calledNumber:bingoCallsSplit){
      // Function to convert numbers on boards to 
      // identifier "X" if containing called out number
        bingoBoards = updateBoardStates(bingoBoards, calledNumber);
        // Check for winner in row or column
        resultCode = checkForWinner(bingoBoards);

        if (resultCode != -1){
          winNumber = Integer.parseInt(calledNumber);
          break;
        }else{
          continue;
        }
      }


      
      // Calculate sum 
      String[][] winningArray = bingoBoards.get(resultCode);
      int sum = 0;
      for (int i = 0; i < 5; i++){
        for (int j = 0; j < 5; j++){
          if (winningArray[i][j]=="X"){
            continue;
          }else{
            sum += Integer.parseInt(winningArray[i][j]);
          }
        }
      }
      System.out.println(sum*winNumber);
    }   
}
