/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management.Models;

import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class Payment {
    public Payment(ArrayList<String> parsedLine) {
        _studentID = Integer.parseInt(parsedLine.get(0));
        _dueDate = parsedLine.get(1);
        _amount =  Float.parseFloat(parsedLine.get(2));
        _referenceNumber = parsedLine.get(3);
        _isPaid = Boolean.parseBoolean(parsedLine.get(4));
        _paidOnTime = Boolean.parseBoolean(parsedLine.get(5));
    }
    
    private int _studentID;
    public int StudentID() {
        return this._studentID;
    }
    
    private String _referenceNumber;
    public String GetReferenceNumber() {
        return _referenceNumber;
    }
    
    private String _dueDate;
    public String GetDueDate() {
        return _dueDate;
    }
    public void SetDueDate(String dueDate) {
        this._dueDate = dueDate;
    }
    
    private float _amount;
    public float GetAmount() {
        return this._amount;
    }
    
    private boolean _isPaid;
    public boolean IsPaid() {
        return this._isPaid;
    }
    public void SetPaid(boolean isPaid) {
        this._isPaid = isPaid;
    }
    
    private boolean _paidOnTime;
    public boolean PaidOnTime() {
        return this._paidOnTime;
    }
    public void SetPaidOnTime(boolean _paidOnTime) {
        this._paidOnTime = _paidOnTime;
    } 
}
