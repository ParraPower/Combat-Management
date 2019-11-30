/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Services;

import com.opencsv.CSVWriter;
import combat.management.Business.CSVScanner;
import combat.management.Models.Student;
import combat.management.Business.CSVHelpers;
import java.io.File;
import java.io.FileWriter;
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

    public ArrayList<Student> getStudentsFromFile(String filePath) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<ArrayList<String>> readData = new ArrayList<ArrayList<String>>();
        
        try {
            readData = CSVScanner.Process(filePath);
            
            readData.forEach(action ->  { 
                //System.out.print(action);
                students.add(new Student(action));
            }); 
        }
        catch(Exception e) {
            //throw new ArrayStoreException("1111");
        }
        
        return students;
    }
    
    public boolean SaveStudent(Student student, String filePath) {
        try {
            ArrayList<Student> students = this.getStudentsFromFile(filePath);
            ArrayList<String[]> dataToWrite = new ArrayList<>();
            for (int i = 0; i < students.size(); ++i) {
                if (students.get(i).ID == student.ID) {
                    students.set(i, student);
                }
                dataToWrite.add(students.get(i).GetAsStringArray());
            }
            
            return CSVHelpers.overwriteCSVFile(dataToWrite, filePath);
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean AddStudent(Student student, String filePath) {
        try {
            student.ID = getNextIDForAddingStudent(filePath);
            
            ArrayList<Student> students = this.getStudentsFromFile(filePath);
            ArrayList<String[]> dataToWrite = new ArrayList<>();
            
            for (int i = 0; i < students.size(); ++i) {
                dataToWrite.add(students.get(i).GetAsStringArray());
            }
            
            dataToWrite.add(student.GetAsStringArray());
            
            return CSVHelpers.overwriteCSVFile(dataToWrite, filePath);
        }
        catch(Exception e) {
            return false;
        }
    }
   
    public int getNextIDForAddingStudent(String filePath){
        int nextID = 0;
        try {
            ArrayList<Student> students = getStudentsFromFile(filePath);
            
            for(Student curr : students)
            {
                if (curr.ID > nextID)
                    nextID = curr.ID;
            }
            
            return (nextID + 1);
        }
        catch(Exception e) {
            return -1;
        }
    }
}
