import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Day3a {
    
    public static void main(String[] args){

        int count = 0;

        int zeroCount;

        int oneCount;

        String gammaString = "";

        String epsilonString = "";


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

            int counter = 0;

            while (counter<stringArray[0].length()){
                
                zeroCount = 0;

                oneCount = 0;

                for (String binaryString:stringArray){

                    char testChar = binaryString.charAt(counter);

                    if (testChar=='0'){

                        zeroCount++;

                    }else{

                        oneCount++;

                    }

                }
                
                if (oneCount>zeroCount){

                    gammaString += "1";

                    epsilonString += "0";

                }else{

                    gammaString += "0";

                    epsilonString += "1";

                }

                counter ++;

            }

            int gammaDecimal = Integer.parseInt(gammaString,2);

            int epsilonDecimal = Integer.parseInt(epsilonString,2);
            
            System.out.println(gammaDecimal*epsilonDecimal);

        } catch(Exception e){

            e.printStackTrace();

        }

    }

}
