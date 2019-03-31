/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Services;

import combat.management.Business.CSVScanner;
import combat.management.Models.Payment;
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
}
