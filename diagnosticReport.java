import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class diagnosticReport {
    

    public String getCO2rating(String[] diagList, int counter){
              
      int zeroCount = 0;

      int oneCount = 0;

      char leastCommon;

      for (String binaryString:diagList){

          char testChar = binaryString.charAt(counter);

          if (testChar=='0'){

              zeroCount++;

          }else{

              oneCount++;

          }

      }

      // Find least common bit value
      if (zeroCount<oneCount){

        leastCommon = '0';

      }else if(zeroCount>oneCount){

        leastCommon = '1';

      }else{

        leastCommon = '0';

      }

      boolean[] deletionIndices = new boolean[diagList.length];

      String currentString;

      for (int i = 0; i < diagList.length -1; i++){

        currentString = diagList[i];

        if (currentString.charAt(counter)!=leastCommon){
          
          deletionIndices[i] = true;

        }
        
      }
      

      // 1. Make diagList an arrayList
      List<String> diagListAmend = Arrays.asList(diagList);

      for (int j=diagList.length - 1; j==0; j--){

        if (deletionIndices[j]){

          diagListAmend.remove(j);

        }

      }

      // Convert array list back to array in form newDiagList
      String[] newDiagList = diagListAmend.toArray(new String[0]);

      if (newDiagList.length == 1){

        System.out.println(newDiagList[0]);
        return "Arthur";

      }else{

        this.getCO2rating(newDiagList,counter++);

      }
      return "Arthur";

    }

    public static void main(String[] args){

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

            diagnosticReport diagForCO2 = new diagnosticReport();
            
            int counter = 0;

            String CO2 = diagForCO2.getCO2rating(stringArray,counter); //Can I use stringArray for both?
            
            System.out.println(CO2);

        } catch(Exception e){

            e.printStackTrace();

        }

    }

}
