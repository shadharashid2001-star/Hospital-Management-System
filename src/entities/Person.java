package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class Person implements Displayable {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private Integer age;
    private boolean active;


    public Person(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            Integer age,
            boolean active) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        setNationalId(nationalId);
        setAge(age);
        setActive(active);
    }


    public Person(
            String id,
            String firstName,
            String lastName) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {

        if (!HelperUtils.isValidText(id)) {
            System.out.println("ID cannot be empty.");
            return;
        }

        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (!HelperUtils.isValidText(firstName)) {
            System.out.println("First name cannot be empty.");
            return;
        }

        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if (!HelperUtils.isValidText(lastName)) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        this.lastName = lastName;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        if (!HelperUtils.isValidText(dateOfBirth)) {
            System.out.println("Date of birth cannot be empty.");
            return;
        }

        this.dateOfBirth = dateOfBirth;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (!HelperUtils.isValidText(gender)) {
            System.out.println("Gender cannot be empty.");
            return;
        }

        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (!HelperUtils.isValidPhone(phoneNumber)) {
            System.out.println("Invalid phone number.");
            return;
        }

        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!HelperUtils.isValidText(email)) {
            System.out.println("Email cannot be empty.");
            return;
        }

        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        if (!HelperUtils.isValidText(address)) {
            System.out.println("Address cannot be empty.");
            return;
        }

        this.address = address;
    }


    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {

        if (!HelperUtils.isValidText(nationalId)) {
            System.out.println("National ID cannot be empty.");
            return;
        }

        this.nationalId = nationalId;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {

        if (age == null || !HelperUtils.isValidAge(age)) {
            System.out.println("Age must be between 0 and 120.");
            return;
        }

        this.age = age;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getFullName() {

        return firstName + " " + lastName;
    }


    public boolean isAdult() {

        return age != null && age >= 18;
    }


    @Override
    public void displayInfo() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("National ID: " + nationalId);
        System.out.println("Age: " + age);
        System.out.println("Active: " + active);
    }


    @Override
    public void displaySummary() {

        System.out.println(
                "ID: " + id
                        + " - Name: "
                        + getFullName()
        );
    }


    @Override
    public String toString() {

        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
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