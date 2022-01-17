package Programs;

import Basic.*;
import Controller.BillController;
import Controller.PersonController;
import Controller.ShopController;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    private static Person person;
    private static ShopController shopController = new ShopController();
    private static PersonController personController = new PersonController();
    private static BillController billController = new BillController();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ShopController shopController = new ShopController();
        List<Shoes> shoes = shopController.readShop("Product.DAT");
//            shoes.add(new Shoes("G01", "Nike Air Force 1","K01","Cao cổ","Trắng","43",450000.00,"USA",40));
//            shoes.add(new Shoes("G02", "Alphabounce 2021","K02","Thể Thao","Đen - Trắng","44",600000.00,"China",20));
//            shoes.add(new Shoes("G03", "Air Jordan 1","K03","Cổ thấp","Đỏ","38",2000000.00,"USA",21));
//            shoes.add(new Shoes("G04", "Adidas Ultraboost 4.0","K02","Thể Thao","Xám","43",400000.00,"Canada",35));
//            shoes.add(new Shoes("G01", "Nike Air Force 1","K01","Cao cổ","Trắng","41",450000.00,"USA",24));
//            shoes.add(new Shoes("G02", "Alphabounce 2021","K02","Thể Thao","Đen - Đỏ","44",600000.00,"China",90));
//            shopController.writeShop(shoes,"Product.DAT");

            PersonController personController = new PersonController();
//            FileWriter fileWriter = new FileWriter("Person.DAT", true);
            List<Person> personList = personController.readPersons("Person.DAT");
//            personList.add(new Person("U01","Phong762002","Tranthanhphong762002*","Thanh Phong", 19,"Hà Nội", "0359650520","Phong762002@gmail.com","Admin"));
//            personList.add(new Person("U02","Phong7620021","Tranthanhphong762002**","Thanh Phong Trần", 20,"Hà Nam", "0459650520","Phong7620022@gmail.com","Customer"));
//            personList.add(new Person("U03","Phong7620022","Tranthanhphong762002***","Trần Thanh Phong", 21,"Hà Tây", "0559650520","Phong7620021@gmail.com","Customer"));
//            personController.writePersons(personList,"Person.DAT");

            BillController billController = new BillController();
//            FileWriter fileWriter = new FileWriter("Bill.DAT", true);
            List<Bill> bills = billController.readBill("Bill.DAT");
//            billController.writeBill(bills,"Bill.DAT");
        Start();
    }

    private static void Start() throws IOException {
        int n;
        do {
            System.out.println("Chào Bạn Đến Với Cửa Hàng Chúng Tôi !");
            System.out.println("Xin mời bạn chọn lựa chọn ");
            System.out.println("1 : Đăng nhập ");
            System.out.println("2 : Đăng kí tài khoản ");
            System.out.println("3 : Thoát ");
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
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng ! Mời bạn chọn lại ");
            }
        }while (n < 1 || n > 3);
    }
    private static void SignIn() throws IOException {
        List<Person> personList = personController.readPersons("Person.DAT");
        sc.nextLine();
        String newUserName;
        String newPassword;
        System.out.println("Nhập tài khoản: ");
        newUserName = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        newPassword = sc.nextLine();
        boolean check = false;
        for( int i = 0 ; i < personList.size(); i++){
            if( personList.get(i).getUserName().compareTo(newUserName) == 0 && personList.get(0).getPassword().compareTo(newPassword) == 0){
                check = true;
                List<Person> personList1 = new ArrayList<>();
                if(personList.get(i).getPermission().compareToIgnoreCase("admin") == 0){
                    System.out.println("Bạn đang đăng nhập với tư cách Admin !");
                    Admin();
                }else {
                    System.out.println("Bạn đang đăng nhập với tư cách Khách Hàng !");
//                    Customers();
                }
                if (check == false){
                    System.out.println("Đăng nhập lại !");
                }
            }
        }
    }

    private static void SignUp(){
        List<Person> personList = personController.readPersons("Person.DAT");
        sc.nextLine();
        String newUsername;
        String newPassword;
        String newCheckPassword;
        String newId;
        String newNamePerson;
        Integer newAge;
        String newAddress;
        String newPhoneNumber;
        String newEmail;
        String newPermission = "Customer";
        System.out.println("==== Tạo tài khoản mới ====");
        System.out.println("Nhập tên tài khoản: ");
        newUsername = sc.nextLine();
        boolean check = true;
        for (int i = 0 ; i < personList.size(); i++){
            if(personList.get(i).getUserName().compareTo(newUsername) == 0){
                System.out.println("Tên tài khoản không hợp lệ ");
                check = false;
            }
        }
        if( check == true){
            System.out.println("Tên tài khoản hợp lệ ! ");
            System.out.println("Nhập mật khẩu: ");
            newPassword = sc.nextLine();
            System.out.println("Nhập lại mật khẩu: ");
            newCheckPassword = sc.nextLine();
            if (newPassword.equals(newCheckPassword) == true){
                System.out.println("Mật khẩu hợp lệ !");
                Person person = new Person();
                System.out.println("ID : ");
                newId = sc.nextLine();
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
                personList.add(new Person(newId, newUsername,newPassword,newNamePerson,newAge,newAddress,newPhoneNumber,newEmail,"customer"));
                System.out.println("Tạo tài khoản thành công ! ");
                personController.writePersons(personList,"Person.DAT");
            }else {
                System.out.println("Mật khẩu không trùng khớp ! Mời bạn nhập lại !");
            }
        }

    }
    private static void Admin() throws IOException {
        System.out.println("1 : Xem thông tin tất cả sản phẩm ");
        System.out.println("2 : Thêm sản phẩm");
        System.out.println("3 : Xóa sản phẩm");
        System.out.println("4 : Sửa thông tin sản phẩm");
        System.out.println("5 : Tìm kiếm sản phẩm");
        System.out.println("6 : Xem hóa đơn");
        System.out.println("7 : Xem doanh thu ");
        System.out.println("8 : Chỉnh sửa quyền");
        System.out.println("9 : Xem danh sách tà khoản ");
        List<Person> personList = new ArrayList<>();
        List<Shoes> shoes = new ArrayList<>();
        List<Bill> bills = new ArrayList<>();
        int n;
        System.out.println("Lựa chọn của bạn : ");
        n = sc.nextInt();
        do {
            switch (n){
                case 1 :
                    ShowProduct(shoes);
                    break;
                case 2 :
                    AddProduct(shoes);
                    break;
                case 3 :
                    DeleteProduct(shoes);
                    break;
                case 4 :
                    EditInformationProduct(shoes);
                    break;
                case 5 :
                    SearchProduct(shoes);
                    break;
                case 6 :
                    ShowBill(bills);
                    break;
//                case 7 :
//                    ShowTurnover();
//                    break;
//                case 8 :
//                    EditPermission();
//                    break;
                case 9 :
                    ShowListUser(personList);
                    break;
//                case 10 :
//                    EditInformation();
//                    break;

                case 0 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng ! Mời bạn chọn lại !");
            }
        }while(n < 0 || n > 10);
    }
    //1 : Xem thông tin tất cả sản phẩm
    private static void ShowProduct(List<Shoes> shoes) throws IOException {
        shoes = shopController.readShop("Product.DAT");
        for(int i = 0; i < shoes.size(); i++){
            System.out.println(shoes.get(i));
        }
        Admin();
    }

    //2 : Thêm sản phẩm
    private static void AddProduct(List<Shoes> shoes) throws IOException {
        shoes = shopController.readShop("Product.DAT");
        String newIDShoes;
        String newNameShoes;
        String newIdType;
        String newNameType;
        String newColor;
        String newSize;
        Double newPrice;
        String newOrigin;
        Integer newQuantity;
        sc.nextLine();
        System.out.println("Id Type : ");
        newIdType = sc.nextLine();
        System.out.println("Name Type : ");
        newNameType = sc.nextLine();
        System.out.println("Id Shoes : ");
        newIDShoes = sc.nextLine();
        System.out.println("Name Shoes : ");
        newNameShoes = sc.nextLine();
        System.out.println("Color Shoes : ");
        newColor = sc.nextLine();
        System.out.println("Size Shoes : ");
        newSize = sc.nextLine();
        System.out.println("Origin Shoes : ");
        newOrigin = sc.nextLine();
        System.out.println("Quantity Shoes : ");
        newQuantity = sc.nextInt();
        System.out.println("Price Shoes : ");
        newPrice = sc.nextDouble();
        shoes.add(new Shoes(newIDShoes,newNameShoes,newIdType,newNameType,newColor,newSize,newPrice,newOrigin,newQuantity));
//        FileWriter fileWriter = new FileWriter("Product.DAT",true);
        shopController.writeShop(shoes,"Product.DAT");
        for(int i = 0; i < shoes.size(); i++){
            System.out.println(shoes.get(i));
        }
//        ShowProduct(shoes1);
        Admin();
    }
    //3 : Xóa sản phẩm theo id
    private static void DeleteProduct(List<Shoes> shoes) throws IOException {
        String idDelete;
        shoes = shopController.readShop("Product.DAT");
        List<Shoes> shoes1 = new ArrayList<>();
        sc.nextLine();
        System.out.println("Nhập id sản phẩm muốn xóa");
        idDelete = sc.nextLine();
        for( int i =0 ;i < shoes.size(); i++){
            if( idDelete.equals(shoes.get(i).getIdShoes())){
                
            }
        }
        shopController.writeShop(shoes,"Product.DAT");
        for(int i = 0; i < shoes.size(); i++){
            System.out.println(shoes.get(i));
        }
        Admin();
    }
    // 4 : Sửa thông tin sản phẩm
    private static void EditInformationProduct(List<Shoes> shoes) throws IOException {
        String newIdShoes;
        String newIdType;
        String newNameType;
        String newNameShoes;
        String newSize;
        String newColor;
        Double newPrice;
        String newOrigin;
        Integer newQuantity;
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        System.out.println("Nhập id sản phẩm muốn sửa : ");
        newIdShoes = sc.nextLine();
        System.out.println("Id Type Shoes : ");
        newIdType = sc.nextLine();
        System.out.println("Name Type Shoes : ");
        newNameType = sc.nextLine();
        System.out.println("Name Shoes : ");
        newNameShoes= sc.nextLine();
        System.out.println("Size Shoes: ");
        newSize = sc.nextLine();
        System.out.println("Color Shoes : ");
        newColor = sc.nextLine();
        System.out.println("Origin Shoes : ");
        newOrigin = sc.nextLine();
        System.out.println("Quantity Shoes : ");
        newQuantity = sc.nextInt();
        System.out.println("Price Shose : ");
        newPrice = sc.nextDouble();
        for ( int i =0 ; i < shoes.size(); i++){
            if(newIdShoes.equals(shoes.get(i).getIdShoes())){
                shoes.get(i).setIdType(newIdType);
                shoes.get(i).setNameType(newNameType);
                shoes.get(i).setNameShoes(newNameShoes);
                shoes.get(i).setSize(newSize);
                shoes.get(i).setColor(newColor);
                shoes.get(i).setPrice(newPrice);
                shoes.get(i).setOrigin(newOrigin);
                shoes.get(i).setQuantity(newQuantity);
            }
        }
        shopController.writeShop(shoes,"Product.DAT");
        for(int i = 0; i < shoes.size(); i++){
            System.out.println(shoes.get(i));
        }
        Admin();
    }
    // 5 : Tìm kiếm
    // Tìm theo tên
    private static void SearchProduct(List<Shoes> shoes) throws IOException {
        shoes = shopController.readShop("Product.DAT");
        Integer m;
        System.out.println("5.1 : Tìm theo tên ");
        System.out.println("5.2 : Tìm theo size ");
        System.out.println("5.3 : Tìm theo kiểu ");
        System.out.println("5.4 : Tìm theo giá ");
        System.out.println("5.5 : Tìm theo màu ");
        System.out.println("5.6 : Tìm theo giảm giá ");
        System.out.println("5.7 : Tìm theo mức giá giảm dần ");
        System.out.println("5.8 : Tìm theo mức giá tăng dần ");
        System.out.println("Nhập lựa chọn ");
        m = sc.nextInt();
        do{
            switch (m) {
                case 1:
                    SearchProductbyName(shoes);
                    break;
                case 2:
                    SearchProductbySize(shoes);
                    break;
                case 3:
                    SearchProductbyType(shoes);
                    break;
                case 4:
                    SearchProductbyPrice(shoes);
                    break;
                case 5:
                    SearchProductbyColor(shoes);
                    break;
                case 6:
                    SearchProductbyDiscount(shoes);
                    break;
                case 7:
                    SearchProductbySortDecrease(shoes);
                    break;
                case 8:
                    SearchProductbySortIncrease(shoes);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không đúng ! Mời bạn chọn lại !");

            }
        }while (m < 0 || m > 8 );
        Admin();
    }
    private static void SearchProductbyName(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        String nameSearch;
        System.out.println("Nhập tên cần tìm: ");
        nameSearch = sc.nextLine();
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getNameShoes().equals(nameSearch)== true) {
                System.out.println(shoes.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào tên như vậy !");
            }
        }
    }
    private static void SearchProductbySize(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        String sizeSearch ;
        System.out.println("Nhập size mà bạn muốn tìm : ");
        sizeSearch = sc.nextLine();
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getSize().equals(sizeSearch)== true) {
                System.out.println(shoes.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào có size như vậy !");
            }
        }
    }
    private static void SearchProductbyType(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        String typeSearch ;
        System.out.println("Nhập mã kiểu mà bạn muốn tìm : ");
        typeSearch = sc.nextLine();
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getIdType().equals(typeSearch)== true) {
                System.out.println(shoes.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào có kiểu như vậy !");
            }
        }
    }
    private static void SearchProductbyPrice(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        Double priceSearch ;
        System.out.println("Nhập Giá mà bạn muốn tìm : ");
        priceSearch = sc.nextDouble();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getPrice().equals(priceSearch) == true) {
                System.out.println(shoes.get(i));
                cnt++;
            }
        }
        if (cnt>0){

        }else{
            System.out.println("Không có sản phảm nào có giá như vậy !");
        }
    }
    private static void SearchProductbyColor(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        String colorSearch ;
        System.out.println("Nhập màu mà bạn muốn tìm : ");
        colorSearch = sc.nextLine();
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getColor().equals(colorSearch)== true) {
                System.out.println(shoes.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào có màu như vậy !");
            }
        }
    }
    private static void SearchProductbyDiscount(List<Shoes> shoes){
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        Double discountSearch ;
        System.out.println("Nhập giảm giá mà bạn muốn tìm : ");
        discountSearch = sc.nextDouble();
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getNameShoes().equals(discountSearch)== true) {
                System.out.println(shoes.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào có mức giảm giá như vậy !");
            }
        }
    }
    private static void SearchProductbySortDecrease(List<Shoes> shoes) throws IOException {
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        for( int i =0 ; i < shoes.size() - 1; i++){
            for( int j = i+1; j < shoes.size(); j++){
                if(shoes.get(i).getPrice() < shoes.get(j).getPrice()){
                    Shoes tg = shoes.get(i);
                    shoes.set(i, shoes.get(j));
                    shoes.set(j,tg);
                }
            }
        }
        shopController.writeShop(shoes,"Product.DAT");
        ShowProduct(shoes);
    }
    private static void SearchProductbySortIncrease(List<Shoes> shoes) throws IOException {
        sc.nextLine();
        shoes = shopController.readShop("Product.DAT");
        for( int i =0 ; i < shoes.size() - 1; i++){
            for( int j = i + 1; j < shoes.size(); j++){
                if(shoes.get(i).getPrice() > shoes.get(j).getPrice()){
                    Shoes tg = shoes.get(i);
                    shoes.set(i, shoes.get(j));
                    shoes.set(j,tg);
                }
            }
        }
        shopController.writeShop(shoes,"Product.DAT");
        ShowProduct(shoes);
    }
    private static void ShowBill(List<Bill> bills) throws IOException {
        bills = billController.readBill("Bill.DAT");
        for( int i =0 ; i < bills.size(); i++){
            System.out.println(bills.get(i));
        }
        Admin();

    }
//    private static void EditofAdmin(List<Person> personList){
//        personList  = personController.readPersons("Person.DAT");
//        String newId;
//        String newUserName;
//        String newPassword;
//        String newNamePerson;
//        Integer newAge;
//        String newAddress;
//        Integer newPhoneNumber;
//        String newEmail;
//        String newPermission;
//        System.out.println("ID: ");
//        newId = sc.nextLine();
//        System.out.println("");
//    }
    private static void ShowListUser(List<Person> personList) throws IOException {
        personList = personController.readPersons("Person.DAT");
        for( int i = 0 ; i < personList.size(); i++){
            System.out.println(personList.get(i));
        }
        Admin();
    }
}

