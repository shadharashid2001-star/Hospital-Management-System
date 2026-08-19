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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(String activestatus) {
        this.activestatus = activestatus;
    }
}
