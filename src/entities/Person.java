package entities;

import interfaces.Displayable;

public class Person implements Displayable {
     private String id ;
     private String firstName;
     private String lastName;
     private String dateOfBirth;
     private String gender;
     private String phoneNumber;
     private String email;
    private String  address;
    private String nationalId;
    private Integer age;
    private boolean active;
 public Person(
         String id ,
         String firstName,
         String dateOfBirth,
         String gender,
         String phoneNumber,
         String email,
         String  address,
         String nationalId,
         String s, Integer age,
         boolean active
 ){
     setFirstName(firstName);
     setLastName(lastName);
     setId(id);
     setEmail(email);
     setAddress(address);
     setActive(active);
     setDateOfBirth(dateOfBirth);
     setGender(gender);
     setAge(age);
     setPhoneNumber(phoneNumber);
 }
public Person(
        String id,
        String firstName,
        String lastName){
     setId(id);
     setFirstName(firstName);
     setLastName(lastName);

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " +firstName+lastName);
        System.out.println("Date of birth"+dateOfBirth);
        System.out.println(" gender"+ gender);
        System.out.println("phoneNumber"+phoneNumber);
        System.out.println(" email"+email);
        System.out.println(" address"+ address);
        System.out.println(" nationalId"+ nationalId);
        System.out.println("age"+age);
        System.out.println(" active-status"+active);


    }

    @Override
    public String displaySummary() {
        System.out.println("id "+getFullName());
        return "";
    }

    public String getFullName(){
     return firstName+ "-"+lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        return id != null && id.equals(other.id);
    }



}
