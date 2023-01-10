import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Day1a {
  public static void main(String[] args) {

    int count = 0; 

    try {
      // create a new file object
      File file = new File("input.txt");

      // create an object of Scanner
      // associated with the file
      Scanner sc = new Scanner(file);

      // read each line and
      // count number of lines
      while(sc.hasNextLine()) {
        sc.nextLine();
        count++;
      }
      
      int [] intArray = new int [count];
      Scanner sc2 = new Scanner(file);
      int i = 0;
      while(sc2.hasNextInt())
      {
        intArray[i++] = sc2.nextInt();
      }

      int prevTerm = 0;
      int depthIncreaseCount = 0;
      for (int j = 0; j<intArray.length; j++){
        if (j == 0){
          continue;
        }else{
          if (intArray[j]>prevTerm){
            depthIncreaseCount++;
          }
          prevTerm = intArray[j];
        }
      }

      // close scanners
      sc.close();
      sc2.close();
      System.out.println(depthIncreaseCount);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}