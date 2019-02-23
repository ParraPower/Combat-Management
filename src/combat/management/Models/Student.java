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
public class Student {
    public int ID;
    public String Firstname;
    public String Lastname;
    public int Age;
    public String Address;
    public String Suburb;
    public int Postcode;
    public String ProfileImageFilename;
    
    public Student(ArrayList<String> parsedLine) {
        ID = Integer.parseInt(parsedLine.get(0));
        Firstname = parsedLine.get(1);
        Lastname = parsedLine.get(2);
        Age =  Integer.parseInt(parsedLine.get(3));
        Address = parsedLine.get(4);
        Suburb = parsedLine.get(5);
        Postcode = Integer.parseInt(parsedLine.get(6));
        ProfileImageFilename = parsedLine.get(7);
    }
}
