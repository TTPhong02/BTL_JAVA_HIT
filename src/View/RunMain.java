package View;

import Model.*;
import Controller.BillController;
import Controller.PersonController;
import Controller.ShopController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static Person checkUser = null;
    public static ShopController shopController = new ShopController();
    public static PersonController personController = new PersonController();
    public static BillController billController = new BillController();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ShopController shopController = new ShopController();
        List<Shoes> shoes = shopController.readShop("Product.DAT");
            PersonController personController = new PersonController();
            List<Person> personList = personController.readPersons("Person.DAT");
            BillController billController = new BillController();
            List<Bill> bills = billController.readBill("Bill.DAT");
        Start();
    }
    private static void Start() throws IOException {
        int n;
        do {
            System.out.println(".___________________________________________________________.");
            System.out.println("|                    WELCOME TO OUR SHOP                    |");
            System.out.println(".___________________________________________________________.");
            System.out.println("    |                                                   |");
            System.out.println("    |               1 : SignIn                          |");
            System.out.println("    |               2 : Create A New Account            |");
            System.out.println("    |               3 : Exit                            |");
            System.out.println("    |                                                   |  / \\");
            System.out.println("     \\___________________________________________________\\___/");
            System.out.println("Enter your choose : ");
            n = sc.nextInt();
            switch (n){
                case 1 :
                    SignIn();
                    break;
                case 2 :
                    SignUp();
                    break;
                case 3 :
                    System.exit(0);
                    System.out.println("Thanks you visit !");
                    break;
                default:
                    System.out.println("Your choose is not available !");
            }
        }while (n != 0 && n != 4);
    }
    private static void SignIn() throws IOException {
        sc.nextLine();
        String checkUserName;
        String checkPassword;
        boolean check = false;
        int n = 0;
        do {
            System.out.println("Enter Username : ");
            checkUserName = sc.nextLine();
            System.out.println("Enter Password : ");
            checkPassword = sc.nextLine();
            List<Person> personList = personController.readPersons("Person.DAT");
            for( int i = 0 ; i < personList.size() ; i++){
                if( personList.get(i).getUserName().compareTo(checkUserName) == 0 && personList.get(i).getPassword().compareTo(checkPassword) == 0){
                    check = true;
                    checkUser = personList.get(i);
                    List<Person> checkUser = new ArrayList<>();
                    checkUser.add(personList.get(i));
                    personController.writePersons(checkUser,"User.DAT");
                    if(personList.get(i).getPermission().compareToIgnoreCase("Admin") == 0){
                        Admin();
                    }else {
                        Customers();
                    }
                }else n++;
                if (check = false){
                    System.out.println("SignIn Failed ! ");
                    SignIn();
                }
                if(n > 4){
                    System.out.println("");
                    System.out.println("You have too many wrong logins !");
                    System.out.println("");
                    System.out.println("");
                    Start();
                }
            }
        }while(check = true );
    }

    private static void SignUp(){
        List<Person> personList = personController.readPersons("Person.DAT");
        sc.nextLine();
        String newUsername;
        String newPassword;
        String newCheckPassword;
        Integer newId;
        String newNamePerson;
        Integer newAge;
        String newAddress;
        String newPhoneNumber;
        String newEmail;
        String newPermission = "Customer";
        System.out.println("Enter Username : ");
        newUsername = sc.nextLine();
        boolean check = true;
        for (int i = 0 ; i < personList.size(); i++){
            if(personList.get(i).getUserName().compareTo(newUsername) == 0){
                System.out.println("Valid Username !");
                check = false;
            }
        }
        if( check){
            System.out.println("Valid Username ! ");
            System.out.println("Enter Password: ");
            newPassword = sc.nextLine();
            System.out.println("Re-enter Password: ");
            newCheckPassword = sc.nextLine();
            if (newPassword.equals(newCheckPassword)){
                System.out.println("Valid Password");
                newId = personList.size()+1;
                System.out.println("NamePerson: ");
                newNamePerson = sc.nextLine();
                System.out.println("Age : ");
                newAge = sc.nextInt();
                System.out.println("Address : ");
                newAddress = sc.nextLine();
                System.out.println("PhoneNumber : ");
                newPhoneNumber = sc.nextLine();
                System.out.println("Email : ");
                newEmail = sc.nextLine();
                personList.add(new Person(newId, newUsername,newPassword,newNamePerson,newAge,newAddress,newPhoneNumber,newEmail,newPermission));
                System.out.println("Account successfully created ! ");
                personController.writePersons(personList,"Person.DAT");
            }else {
                System.out.println("Wrong password !");
            }
        }
    }
    public static void Admin() throws IOException {
        int n;
        do {
            System.out.println("<================== ADMIN ==================>");
            System.out.println("|       1  : Show Product                   |");
            System.out.println("|       2  : Add Product                    |");
            System.out.println("|       3  : Delete Product                 |");
            System.out.println("|       4  : Change Information Product     |");
            System.out.println("|       5  : Search Product                 |");
//            System.out.println("|       6  : Show Bill                      |");
//            System.out.println("|       7  : Show Turnover                  |");
            System.out.println("|       6  : Manage Users                   |");
            System.out.println("|       7  : Change Information             |");
            System.out.println("|       8 : Logout                         |");
            System.out.println("<================! Welcome !================>");
            List<Shoes> shoes = shopController.readShop("Product.DAT");
            List<Bill> bills = billController.readBill("Bill.DAT");
            List<Person> personList = personController.readPersons("Person.DAT");
            System.out.println("Lựa chọn của bạn : ");
            n = sc.nextInt();
            switch (n){
                case 1 :
                    System.out.println("");
                    System.out.println("");
                    shopController.showProduct(shoes);
                    System.out.println("");
                    System.out.println("");
                    sc.nextLine();
                    String back;
                    System.out.println("Do you want some choose [Y/N] : ");
                    back = sc.nextLine();
                    if(back.compareToIgnoreCase("Y")==0){
                        Admin();
                    }else{
                        System.out.println("Thanks You ! See You Later !");
                    }
                    break;
                case 2 :
                    shopController.addProduct(shoes);
                    break;
                case 3 :
                    shopController.deleteProduct();
                    break;
                case 4 :
                    shopController.editInformationProduct();
                    break;
                case 5 :
                    searchProduct();
                    break;
//                case 6 :
//                    billController.showBill();
//                    break;
//                case 7 :
//                    ShowTurnover();
//                    break;
                case 6 :
                    personController.manageUsers();
                    break;
                case 7 :
                    personController.editInformation();
                    break;
                case 8 :
                    Start();
                    break;
                case 0 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choose is not available !");
            }
         }while(n != -1 && n != 11);
    }
    public static void Customers() throws IOException {
        List<Person> personList = personController.readPersons("Person.DAT");
        List<Shoes> shoes = shopController.readShop("Product.DAT");
        List<Bill> bills = billController.readBill("Bill.DAT");
        int n;
        do {
            System.out.println("<==================Customer=================>");
            System.out.println("|          1 : Show Product                 |");
            System.out.println("|          2 : Search Product               |");
            System.out.println("|          3 : Buy Shoes                    |");
            System.out.println("|          4 : Change Your Information      |");
            System.out.println("|          5 : Logout                       |");
            System.out.println("<=================! Welcome !===============>");
            System.out.println("Lựa chọn của bạn : ");
            n = sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1 :
                    shopController.showProduct(shoes);
                    String back;
                    System.out.println("Do you want some choose [Y/N] : ");
                    back = sc.nextLine();
                    if(back.compareToIgnoreCase("Y")==0){
                        Customers();
                    }else{
                        System.out.println("Thanks You ! See You Later !");
                    }
                    break;
                case 2 :
                    searchProduct();
                    break;
                case 3:
                    shopController.buyShoes();
                    break;
                case 4 :
                    personController.editInformation();
                    break;
                case 5 :
                    Start();
                case 0 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choose is not available !");
            }
        }while(n != -1 && n!=4);
    }
    // 5 : Tìm kiếm
    // Tìm theo tên
    public static void searchProduct() throws IOException {
        List<Bill> bills = billController.readBill("Bill.DAT");
        List<Person> personList = personController.readPersons("User.DAT");
        int m;
        do{
            System.out.println("<============== Search Shoes ==============>");
            System.out.println("|        1 : Search by Name                |");
            System.out.println("|        2 : Search by Size                |");
            System.out.println("|        3 : Search by Type                |");
            System.out.println("|        4 : Search by Price               |");
            System.out.println("|        5 : Search by Color               |");
            System.out.println("|        6 : Search by Discount            |");
            System.out.println("|        7 : Search Price Decrease         |");
            System.out.println("|        8 : Search Price Increase         |");
            System.out.println("|        9 : Back                          |");
            System.out.println("<================! Welcome !===============>");
            System.out.println("Nhập lựa chọn ");
            m = sc.nextInt();
            switch (m) {
                case 1:
                    shopController.searchProductByName();
                    break;
                case 2:
                    shopController.searchProductBySize();
                    break;
                case 3:
                    shopController.searchProductByType();
                    break;
                case 4:
                    shopController.searchProductByPrice();
                    break;
                case 5:
                    shopController.searchProductByColor();
                    break;
                case 6:
                    billController.searchProductByDiscount(bills);
                    break;
                case 7:
                    shopController.searchProductBySortDecrease();
                    break;
                case 8:
                    shopController.searchProductBySortIncrease();
                    break;
                case 9 :
                    if(personList.get(0).getPermission().compareToIgnoreCase("Admin")==0){
                        Admin();
                    }else{
                        Customers();
                    }
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choose is not available !");
            }
        }while (m != -1 && m != 9 );
    }
}

