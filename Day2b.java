import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Day2b {

    public static void main(String[] args) {

        int count = 0;

        String orientationCode;

        int quantity = 0;

        int depth = 0;

        int horizPos = 0;

        int aim = 0;

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
          
          for (String command:stringArray){

            String[] splitCommand = command.split(" ");

            orientationCode = splitCommand[0];

            quantity = Integer.parseInt(splitCommand[1]);
            
            switch (orientationCode){

                case "forward":

                    horizPos += quantity;

                    depth += (aim*quantity);

                    break;

                case "up":
                    aim -= quantity;

                    break;

                case "down":
                    aim += quantity;
                    
                    break;

            }

          }

          System.out.println(horizPos*depth);

        } catch(Exception e){

            e.printStackTrace();

        }

    }

}
