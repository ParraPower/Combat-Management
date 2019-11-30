/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Business;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ahmed
 */
public class CSVHelpers {
    public static boolean overwriteCSVFile(ArrayList<String[]> data, String filePath) {
        try {
            File file = new File(filePath);
          
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file); 
            
            CSVWriter writer = new CSVWriter(outputfile);
            
            writer.writeAll(data); 
  
            // closing writer connection 
            writer.close(); 
            
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
}
