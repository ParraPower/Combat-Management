/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Services;

import combat.management.Business.CSVScanner;
import combat.management.Models.Payment;
import combat.management.Business.CSVHelpers;
import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class PaymentsService {
    private CSVScanner _csvScanner;
    
    public PaymentsService() {
        _csvScanner = new CSVScanner();
        
    }
    public ArrayList<Payment> getPaymentsHistoryForStudent(int studentId, String filePath) {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        ArrayList<ArrayList<String>> readData = new ArrayList<ArrayList<String>>();
        
        try {
            readData = CSVScanner.Process(filePath);
            
            readData.forEach((action) ->  { 
                //System.out.print(action);
                Payment payment = new Payment(action);
                if (payment.StudentID() == studentId) {
                    payments.add(payment);
                } 
            }); 
        }
        catch(Exception e) {
            System.out.println("I messed up");
        }
        
        return payments;
    }
    /*public boolean AddStudent(Student student, String filePath) {
        try {
            student.ID = getNextIDForAddingStudent(filePath);
            
            ArrayList<Student> students = this.getStudentsFromFile(filePath);
            ArrayList<String[]> dataToWrite = new ArrayList<>();
            
            for (int i = 0; i < students.size(); ++i) {
                dataToWrite.add(students.get(i).GetAsStringArray());
            }
            
            dataToWrite.add(student.GetAsStringArray());
            
            return overwriteCSVFile(dataToWrite, filePath);
        }
        catch(Exception e) {
            return false;
        }
    }*/
    public boolean addPaymentHistoryForStudent(Payment newPayment, String filePath) {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        ArrayList<ArrayList<String>> readData = new ArrayList<ArrayList<String>>();
        
        ArrayList<Payment> payementsFotStudent = this.getPaymentsHistoryForStudent(newPayment.StudentID(), filePath);
        ArrayList<String[]> dataToWrite = new ArrayList<>();
        
        try {
            readData = CSVScanner.Process(filePath);
            
            for (int i = 0; i < payementsFotStudent.size(); ++i) {
                dataToWrite.add(payementsFotStudent.get(i).GetAsStringArray());
            } 
            
            dataToWrite.add(newPayment.GetAsStringArray());
            
            return CSVHelpers.overwriteCSVFile(dataToWrite, filePath);
        }
        catch(Exception e) {
            System.out.println("I messed up");
            return false;
        }
    }
}
