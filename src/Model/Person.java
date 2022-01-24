package Model;

import java.util.Scanner;

public class Person {
    protected Integer id;
    protected String userName;
    protected String password;
    protected String namePerson;
    protected Integer age;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected String permission;
    public Person() {}
    public Person(Integer id, String userName, String password, String namePerson, Integer age, String address, String phoneNumber,String email,String permission) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.namePerson = namePerson;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email  = email;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public void display(){
        System.out.printf("%1s %5s %1s %30s %1s %20s %1s %8s %1s %20s %1s %20s %1s %30s %1s %15s %3s  \n","|",id,"|",userName,"|",namePerson,"|", age,"|",address,"|",phoneNumber,"|",email,"|",permission,"|");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", namePerson='" + namePerson + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
