/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Services;

import combat.management.Business.CSVScanner;
import combat.management.Models.Student;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class UserService {
    private CSVScanner _csvScanner;
    
    public UserService() {
        _csvScanner = new CSVScanner();
    }
    
    public ArrayList<Student> getStudentsFromFile(String filename) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<ArrayList<String>> readData = new ArrayList<ArrayList<String>>();
        try {
            readData = CSVScanner.Process(filename);
            
            readData.forEach(action ->  { 
                //System.out.print(action);
                students.add(new Student(action));
            }); 
            
        }
        catch(Exception e) {
            throw new ArrayStoreException("1111");
        }
        
        return students;
    }
}
