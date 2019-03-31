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
    public String DateOfBirth;
    public String BeltLevelDate;
    public String BeltLevel;
    public String ContactPhoneNumber;
    public String ContactEmail;
    public String EmergencyContactPhoneNumber;
    public String EmergencyContactName;
    public String MemberSinceDate;
    public String LeftOnDate;
    
    public Student(ArrayList<String> parsedLine) {
        ID = Integer.parseInt(parsedLine.get(0));
        Firstname = parsedLine.get(1);
        Lastname = parsedLine.get(2);
        Age =  Integer.parseInt(parsedLine.get(3));
        Address = parsedLine.get(4);
        Suburb = parsedLine.get(5);
        Postcode = Integer.parseInt(parsedLine.get(6));
        ProfileImageFilename = parsedLine.get(7);
        DateOfBirth = parsedLine.get(8);
        BeltLevelDate = parsedLine.get(9);
        BeltLevel = parsedLine.get(10);
        ContactPhoneNumber = parsedLine.get(11);
        ContactEmail = parsedLine.get(12);
        EmergencyContactPhoneNumber = parsedLine.get(13);
        EmergencyContactName = parsedLine.get(14);
        MemberSinceDate = parsedLine.get(15);
        LeftOnDate = parsedLine.get(16);
    }
    
    
    public String[] GetAsStringArray() {
         ArrayList<String> result = new ArrayList<String>();
         result.add(Integer.toString(ID));
         result.add(Firstname);
         result.add(Lastname);
         result.add(Integer.toString(Age));
         result.add(Address);
         result.add(Suburb);
         result.add(Integer.toString(Postcode));
         result.add(ProfileImageFilename);
         result.add(DateOfBirth);
         result.add(BeltLevelDate);
         result.add(BeltLevel);
         result.add(ContactPhoneNumber);
         result.add(ContactEmail);
         result.add(EmergencyContactPhoneNumber);
         result.add(EmergencyContactName);
         result.add(MemberSinceDate);
         result.add(LeftOnDate);

         return result.toArray(new String[result.size()]);
    }
}
