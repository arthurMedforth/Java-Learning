import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Day4 {

    public static String[] getInput(){

      int count = 0;

      try {
        // create a new file object
        File file = new File("input.txt");
  
        // create an object of Scanner
        // associated with the file
        Scanner sc1 = new Scanner(file);
  
        // read each line and
        // count number of lines
        while(sc1.hasNextLine()) {
  
          sc1.nextLine();
  
          count++;
          
        }
  
        String[] stringArray = new String[count];
  
        Scanner sc2 = new Scanner(file);
  
        int i = 0;
  
        while(sc2.hasNextLine())
        {
  
          stringArray[i++] = sc2.nextLine();
  
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

      String[] stringArray = getInput();

      // Convert first line into set of "random" integers

      for (int i = 1; i < stringArray.length; i++){
        
        if (stringArray[i] == ""){
           
          continue;

        }

      }

    }

}
