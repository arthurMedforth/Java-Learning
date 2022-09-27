import java.io.File;  // Import the File class
// Import the Scanner class to read text files
import java.util.*;


// CAN CHANGE CLASS NAME TO DIAGNOSTIC REPORT TO MAKE MORE SENSE
// REMEMBER TO CHANGE ALL INSTANCES OF OLD NAME DAY3b THOUGH!
public class Day3b {

    String[] diagRep;

    public Day3b(String[] stringArray){

      this.diagRep = stringArray;

    }
    public static Day3b getRating(Day3b diagReport, int counter, String codeString){
              
      int zeroCount = 0;

      int oneCount = 0;

      for (String binaryString:diagReport.diagRep){

          char testChar = binaryString.charAt(counter);

          if (testChar=='0'){

              zeroCount++;

          }else{

              oneCount++;

          }

      }

      // Find least common bit value
      char Common = ' ';

      switch (codeString){

        case "CO2":

        if (zeroCount<oneCount){

            Common = '0';

          }else if(zeroCount>oneCount){

            Common = '1';

          }else{

            Common = '0';

          }
          break;

        case "O2":

          if (zeroCount>oneCount){

            Common = '0';

          }else if(zeroCount<oneCount){

            Common = '1';

          }else{

            Common = '1';

          }

          break;
        }


      int[] deletionIndices = new int[diagReport.diagRep.length];

      for (int k = 0; k < deletionIndices.length; k++) {

        deletionIndices[k] = -1;

     }

      String currentString;

      for (int i = 0; i < diagReport.diagRep.length; i++){

        currentString = diagReport.diagRep[i];

        if (currentString.charAt(counter)!=Common){
          
          deletionIndices[i] = i;

        }
        
      }


      // 1. Make diagList an arrayList
      List<String> diagListAmend = new ArrayList<>(Arrays.asList(diagReport.diagRep));

      for (int j=diagReport.diagRep.length - 1; j>-1; j--){

        if (deletionIndices[j]!=-1){

          diagListAmend.remove(j);

        }

      }

      // Convert array list back to array in form newDiagList
      String[] newDiagList = diagListAmend.toArray(new String[0]);

      diagReport.diagRep = newDiagList;

      return diagReport;
  

    }

    public String introduce(){

      return "Hi";

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

            Day3b diagForCO2 = new Day3b(stringArray);

            Day3b diagForO2 = new Day3b(stringArray);

            int counter = 0;

            while (diagForCO2.diagRep.length!=1){

              diagForCO2 = getRating(diagForCO2,counter++,"CO2");

            }

            counter = 0;

            while (diagForO2.diagRep.length!=1){

              diagForO2 = getRating(diagForO2,counter++,"O2"); 

            }

            int O2Rating = Integer.parseInt(diagForO2.diagRep[0],2);

            int CO2Rating = Integer.parseInt(diagForCO2.diagRep[0],2);

            System.out.println(O2Rating*CO2Rating);

        } catch(Exception e){
            
            e.printStackTrace();

        }

    }

}
