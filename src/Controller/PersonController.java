package Controller;

import Model.Customer;
import Model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static View.RunMain.Admin;
import static View.RunMain.Customers;

public class PersonController {
    private FileController fileController = new FileController();
    private Person person = new Person();
    private static PersonController personController;
    private List<Person> personList = readPersons("Person.DAT");
    private List<Person> personChange = readPersons("User.DAT");
    private Scanner sc = new Scanner(System.in);
    public PersonController() {
    }

    public PersonController(Person person, FileController fileController) {
        this.person = person;
        this.fileController = fileController;
    }
    public List<Person> readPersons(String namefile){
        fileController.OpenFileToRead(namefile);
        List<Person> personList = new ArrayList<>();

        while(fileController.getScanner().hasNext()){
            String information = fileController.getScanner().nextLine();
            String[] data = information.split("\\|");
            personList.add(new Person(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4]),data[5],data[6],data[7],data[8]));
        }
        fileController.CloseFileAfterRead();
        return personList;
    }
    public List<Person> writePersons(List<Person> personList, String namefile){
        fileController.OpenFileToWrite(namefile);
        for(Person person : personList){
            fileController.getPrintWriter().println(person.getId()+ "|" +person.getUserName() + "|" + person.getPassword()+ "|" +person.getNamePerson()+"|"+person.getAge()+"|"+person.getAddress()+"|"+person.getPhoneNumber()+"|"+person.getEmail()+"|"+person.getPermission());
        }
        fileController.CloseFileAfterWrite();
        return personList;
    }
    public void manageUsers() throws IOException {
        int n;
        do {
            System.out.println("<=============== Manage Users ===============>");
            System.out.println("|       1 : Show List Users                  |");
            System.out.println("|       2 : Change Permission to Admin       |");
            System.out.println("|       3 : Change Permission to Customer    |");
            System.out.println("|       4 : Back                             |");
            System.out.println("<================! Welcome !=================>");
            System.out.println("Enter your choose : ");
            n = sc.nextInt();
            switch (n){
                case 1 :
                    showListUser();
                    break;
                case 2 :
                    changePermissionToAdmin(personList);
                    break;
                case 3 :
                    changePermissionToCustomer(personList);
                    break;
                case 4 :
                    Admin();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Your choose is not available !");
            }
        }while ( n !=0 && n !=5);
    }
    // Show list user
    public void showListUser() throws IOException {
        List<Person> personList = readPersons("Person.DAT");
        System.out.println(".-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------.");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLIST USERS \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%1s %5s %1s %30s %1s %20s %1s %8s %1s %20s %1s %20s %1s %30s %1s %15s %3s  \n","|","ID","|","Username","|", "Name","|","Age","|","Address","|","PhoneNumber","|","Email","|","Permission","|");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for( int i = 0 ; i < personList.size(); i++){
            personList.get(i).display();
        }
        String back;
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Customers();
        }else{
            System.out.println("Thanks ! See you later ");
            System.exit(0);
        }
    }
    //change permission
    public void changePermissionToAdmin(List<Person> personList) throws IOException {
        Integer idChange ;
        int n = 0;
        do{
            System.out.println("Enter id you want Upgrade Permission : ");
            idChange = sc.nextInt();
            for( int i =0 ; i <personList.size(); i++){
                if(idChange == personList.get(i).getId()){
                    personList.get(i).setPermission("Admin");
                    writePersons(personList,"Person.DAT");
                }else{
                    n++;
                }
            }
            System.out.println("Upgrade to Admin Completed !");
        }while ( n != 3);
        String back;
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Customers();
        }else{
            System.out.println("Thanks ! See you later ");
            System.exit(0);
        }
    }
    public void changePermissionToCustomer(List<Person> personList) throws IOException {
        Integer idChange ;
        int n = 0;
        do{
            System.out.println("Enter Id User you want Upgrade Permission : ");
            idChange = sc.nextInt();
            for( int i =0 ; i <personList.size(); i++){
                if(idChange == personList.get(i).getId()){
                    personList.get(i).setPermission("Customer");
                    writePersons(personList,"Person.DAT");
                }else{
                    n++;
                }
            }
            System.out.println("Upgrade to Customer Completed !");
        }while ( n != 3);
        String back;
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Customers();
        }else{
            System.out.println("Thanks ! See you later ");
            System.exit(0);
        }
    }
    public void editInformation() throws IOException {
        int n;
        do{
            System.out.println("<======== Change Information Customer =========>");
            System.out.println("|       1. Change Password                     |");
            System.out.println("|       2. Change Name                         |");
            System.out.println("|       3. Change Age                          |");
            System.out.println("|       4. Change Address                      |");
            System.out.println("|       5. Change PhoneNumber                  |");
            System.out.println("|       6. Change Email                        |");
            System.out.println("|       7. Back                                |");
            System.out.println("<=================! Welcome !==================>");
            System.out.println("Enter your choose : ");
            n = sc.nextInt();
            switch (n){
                case 1 :
                    changePassword(personChange);
                    break;
                case 2 :
                    changeName(personChange);
                    break;
                case 3 :
                    changeAge(personChange);
                    break;
                case 4 :
                    changeAddress(personChange);
                    break;
                case 5 :
                    changePhoneNumber(personChange);
                    break;
                case 6 :
                    changeEmail(personChange);
                    break;
                case 7 :
                    if(personChange.get(0).getPermission().compareToIgnoreCase("admin")==0){
                        Admin();
                    }else{
                        Customers();
                    }
                case 0 :
                    System.exit(0);
                default:
                    System.out.println("Your choose is not available !");
            }
        }while (n != 1 && n!=8 );
    }

    public void changePassword(List<Person> personChange) throws IOException {
        String newPassword;
        String checkPassword;
        String oldPassword;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your old Password : ");
            oldPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(oldPassword)==0){
                System.out.println("Enter your new Password : ");
                newPassword = sc.nextLine();
                System.out.println("Enter again new Password : ");
                checkPassword = sc.nextLine();
                if(newPassword.compareTo(checkPassword)==0){
                    personChange.get(0).setPassword(newPassword);
                    writePersons(personChange,"User.DAT");
                    for(int i =0 ; i < personList.size(); i++){
                        if(personList.get(i).getId()==personChange.get(0).getId()){
                            personList.get(i).setPassword(personChange.get(0).getPassword());
                            writePersons(personList,"Person.DAT");
                        }
                    }
                }
            }else {
                n++;
            }
        }while( n != 3);
        System.out.println("Password Has Been Changed ! ");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }
    public void changeName(List<Person> personChange) throws IOException {
        String checkPassword;
        String newName;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your Password : ");
            checkPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(checkPassword)==0){
                System.out.println("Enter your new Name : ");
                newName = sc.nextLine();
                personChange.get(0).setNamePerson(newName);
                writePersons(personChange,"User.DAT");
                for(int i =0 ; i < personList.size(); i++){
                    if(personList.get(i).getId()==personChange.get(0).getId()){
                        personList.get(i).setNamePerson(personChange.get(0).getNamePerson());
                        writePersons(personList,"Person.DAT");
                    }
                }
            }else {
                n++;
                System.out.println("Password Error ! ");
            }
        }while( n > 3);
        System.out.println("Name Has Been Changed ! ");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }

    public void changeAge(List<Person> personChange) throws IOException {
        Integer newAge;
        String checkPassword;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your Password : ");
            checkPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(checkPassword)==0){
                System.out.println("Enter your new Age : ");
                newAge = sc.nextInt();
                personChange.get(0).setAge(newAge);
                writePersons(personChange,"User.DAT");
                for(int i =0 ; i < personList.size(); i++){
                    if(personList.get(i).getId()==personChange.get(0).getId()){
                        personList.get(i).setAge(personChange.get(0).getAge());
                        writePersons(personList,"Person.DAT");
                    }
                }
            }else {
                n++;
            }
        } while (n > 3);
        System.out.println("Age Has Been Changed ! ");
        String back;
        sc.nextLine();
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }

    public void changeAddress(List<Person> personChange) throws IOException {
        String newAddress;
        String checkPassword;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your Password : ");
            checkPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(checkPassword)==0){
                System.out.println("Enter your new Address : ");
                newAddress = sc.nextLine();
                personChange.get(0).setAddress(newAddress);
                writePersons(personChange,"User.DAT");
                for(int i =0 ; i < personList.size(); i++){
                    if(personList.get(i).getId()==personChange.get(0).getId()){
                        personList.get(i).setAddress(personChange.get(0).getAddress());
                        writePersons(personList,"Person.DAT");
                    }
                }
            }else {
                n++;
            }
        }while( n > 3);
        System.out.println("Address Has Been Changed ! ");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }
    public void changePhoneNumber(List<Person> personChange) throws IOException {
        String newPhoneNumber;
        String checkPassword;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your Password : ");
            checkPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(checkPassword)==0){
                System.out.println("Enter your new PhoneNumber : ");
                newPhoneNumber = sc.nextLine();
                personChange.get(0).setPhoneNumber(newPhoneNumber);
                writePersons(personChange,"User.DAT");
                for(int i =0 ; i < personList.size(); i++){
                    if(personList.get(i).getId()==personChange.get(0).getId()){
                        personList.get(i).setPhoneNumber(personChange.get(0).getPhoneNumber());
                        writePersons(personList,"Person.DAT");
                    }
                }
            }else {
                n++;
            }
        }while( n > 3);
        System.out.println("PhoneNumber Has Been Changed ! ");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }
    public void changeEmail(List<Person> personChange) throws IOException {
        String newEmail;
        String checkPassword;
        sc.nextLine();
        int n = 0;
        do {
            System.out.println("Enter your Password : ");
            checkPassword = sc .nextLine();
            if(personChange.get(0).getPassword().compareTo(checkPassword)==0){
                System.out.println("Enter your new Email : ");
                newEmail = sc.nextLine();
                personChange.get(0).setEmail(newEmail);
                writePersons(personChange,"User.DAT");
                for(int i =0 ; i < personList.size(); i++){
                    if(personList.get(i).getId()==personChange.get(0).getId()){
                        personList.get(i).setEmail(personChange.get(0).getEmail());
                        writePersons(personList,"Person.DAT");
                    }
                }
            }else {
                n++;
            }
        }while( n > 3);
        System.out.println("PhoneNumber Has Been Changed ! ");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            editInformation();
        }
    }

}
