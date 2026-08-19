package main;

import interfaces.Displayable;

public class HospitalApp implements Displayable {

    private String  id ;
    private String  firstName;
    private String  lastName ;
    private String  dateOfBirth;
    private String  gender;
    private String phoneNumber;
    private String email;
    private String  address;
    private String  nationalId;
    private Integer  age;
    private String  activestatus;

    public HospitalApp(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String nationalId, Integer age, String activestatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.nationalId = nationalId;
        this.age = age;
        this.activestatus = activestatus;
    }
    
}
