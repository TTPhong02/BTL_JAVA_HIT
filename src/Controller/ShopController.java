package Controller;

import Model.Bill;
import Model.Person;
import Model.Shoes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static View.RunMain.*;

public class ShopController {
    private ShopController shopController;
    private PersonController personController = new PersonController();
    private Shoes shoes = new Shoes();
    private Bill bill = new Bill();
    private FileController fileController = new FileController();
    private Scanner sc = new Scanner(System.in);

    public ShopController() {
    }

    public ShopController(Shoes shoes, FileController fileController) {
        this.shoes = shoes;
        this.fileController = fileController;
    }
    public List<Shoes> readShop(String namefile) {
        fileController.OpenFileToRead(namefile);
        List<Shoes> shoes = new ArrayList<>();
        while(fileController.getScanner().hasNext()){
            String information = fileController.getScanner().nextLine();
            String[] data = information.split("\\|");
            shoes.add(new Shoes(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],data[5],Double.parseDouble(data[6]),data[7],Integer.parseInt(data[8]) ));
        }
        fileController.CloseFileAfterRead();
        return shoes;
    }
    public List<Shoes> writeShop(List<Shoes> shoes, String namefile){
        fileController.OpenFileToWrite(namefile);
        for(Shoes shoes1 : shoes){
            fileController.getPrintWriter().println(shoes1.getIdShoes()+"|"+shoes1.getNameShoes()+"|"+shoes1.getIdType()+"|"+shoes1.getNameType()+"|"+shoes1.getColor()+"|"+shoes1.getSize()+"|"+shoes1.getPrice()+"|"+shoes1.getOrigin()+"|"+shoes1.getQuantity());
        }
        fileController.CloseFileAfterWrite();
        return shoes;
    }
    //1 : Xem thông tin tất cả sản phẩm
    public void showProduct(List<Shoes> shoes) throws IOException {
        System.out.println(".------------------------------------------------------------------------------------------------------------------------------------------------------------------------.");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLIST SHOES \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%1s %5s %1s %30s %1s %8s %1s %20s %1s %20s %1s %20s %1s %20s %1s %20s %3s  \n","|","ID","|","Name","|", "ID Type","|","Name Type","|","Color","|","Price(VND)","|","Made In","|","Quantity","|");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for( int i = 0 ; i<shoes.size(); i++){
            shoes.get(i).display();
        }
    }
    public void showShoesBuy(List<Shoes> shoes) throws IOException {
        System.out.println(".------------------------------------------------------------------------------------------------------------------------------------------------------------------------.");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLIST SHOES \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%1s %5s %1s %30s %1s %8s %1s %20s %1s %20s %1s %20s %1s %20s %1s %20s %3s  \n","|","ID","|","Name","|", "ID Type","|","Name Type","|","Color","|","Price(VND)","|","Made In","|","Quantity Purchased","|");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for( int i = 0 ; i<shoes.size(); i++){
            shoes.get(i).display();
        }
    }
    //2 : Thêm sản phẩm
    public void addProduct(List<Shoes>shoes) throws IOException {
        Integer newIDShoes;
        String newNameShoes;
        String newIdType;
        String newNameType;
        String newColor;
        String newSize;
        Double newPrice;
        String newOrigin;
        Integer newQuantity;
        System.out.println("Id Type : ");
        newIdType = sc.nextLine();
        System.out.println("Name Type : ");
        newNameType = sc.nextLine();
        newIDShoes = shoes.size()+1;
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
        writeShop(shoes,"Product.DAT");
        System.out.println("Add New Product Completed !");
        String back;
        sc.nextLine();
        System.out.println("Do you want some choose [Y/N] : ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Admin();
        }else{
            System.out.println("Thanks you ! See you later ");
            System.exit(0);
        }
    }
    //3 : Xóa sản phẩm theo id
    public void deleteProduct() throws IOException {
        Integer idDelete;
        List<Shoes> shoes = readShop("Product.DAT");
        List<Shoes> shoes1 = new ArrayList<>();
        System.out.println("Enter Id Product Delete : ");
        idDelete = sc.nextInt();
        for( int i =0 ;i < shoes.size(); i++){
            if( idDelete != shoes.get(i).getIdShoes()){
                shoes1.add(shoes.get(i));
            }
        }
        writeShop(shoes1,"Product.DAT");
        System.out.println("Delete completed !");
        String back;
        System.out.println("Do you want some choose [Y/N] : ");
        sc.nextLine();
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Admin();
        }else{
            System.out.println("Thanks you ! See you later ");
            System.exit(0);
        }
    }
    // 4 : Sửa thông tin sản phẩm
    public void editInformationProduct() throws IOException {
        Integer idEdit;
        String newIdType;
        String newNameType;
        String newNameShoes;
        String newSize;
        String newColor;
        Double newPrice;
        String newOrigin;
        Integer newQuantity;
        List<Shoes> shoes = readShop("Product.DAT");
        System.out.println("Enter ID You Want Change: ");
        idEdit = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Id Type Shoes : ");
        newIdType = sc.nextLine();
        System.out.println("Enter New Name Type Shoes : ");
        newNameType = sc.nextLine();
        System.out.println("Enter New Name Shoes : ");
        newNameShoes= sc.nextLine();
        System.out.println("Enter New Size Shoes: ");
        newSize = sc.nextLine();
        System.out.println("Enter New Color Shoes : ");
        newColor = sc.nextLine();
        System.out.println("Enter New Origin Shoes : ");
        newOrigin = sc.nextLine();
        System.out.println("Enter New Quantity Shoes : ");
        newQuantity = sc.nextInt();
        System.out.println("Enter New Price Shose : ");
        newPrice = sc.nextDouble();
        for ( int i =0 ; i < shoes.size(); i++){
            if(idEdit == shoes.get(i).getIdShoes()){
                shoes.get(i).setIdShoes(idEdit);
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
        writeShop(shoes,"Product.DAT");
        System.out.println("Change Information Product Completed ! ");
        String back;
        System.out.println("Do you want some choose [Y/N] : ");
        sc.nextLine();
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y")==0){
            Admin();
        }else{
            System.out.println("Thanks you ! See you later ");
            System.exit(0);
        }
    }


    // tìm kiếm bằng tên
    public void searchProductByName() throws IOException {
        List<Shoes> shoes = readShop("Product.DAT");
        String nameSearch;
        System.out.println("Nhập tên cần tìm: ");
        nameSearch = sc.nextLine();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getNameShoes().equals(nameSearch)) {
                System.out.println(shoes.get(i));
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("Invalid Product Name !");
        }
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    // tìm kiếm bằng size
    public void searchProductBySize() throws IOException {
        List<Shoes> shoes = readShop("Product.DAT");
        String sizeSearch ;
        System.out.println("Nhập size mà bạn muốn tìm : ");
        sizeSearch = sc.nextLine();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getSize().equals(sizeSearch)) {
                System.out.println(shoes.get(i));
            }
        }
        if (cnt == 0){
            System.out.println("Invalid Product Size !");
        }
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    //tìm kiếm bằng kiểu
    public void searchProductByType() throws IOException {
        sc.nextLine();
        List<Shoes> shoes = readShop("Product.DAT");
        String typeSearch ;
        System.out.println("Nhập mã kiểu mà bạn muốn tìm : ");
        typeSearch = sc.nextLine();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getIdType().equals(typeSearch)) {
                System.out.println(shoes.get(i));
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("Invalid Product Id Type !");
        }
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    //tìm kiếm bằng giá
    public void searchProductByPrice() throws IOException {
        sc.nextLine();
        List<Shoes> shoes = readShop("Product.DAT");
        Double priceSearch ;
        System.out.println("Nhập Giá mà bạn muốn tìm : ");
        priceSearch = sc.nextDouble();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getPrice().equals(priceSearch) ) {
                System.out.println(shoes.get(i));
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("Invalid Product Price!");
        }
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    //tìm kiếm bằng màu
    public void searchProductByColor() throws IOException {
        sc.nextLine();
        List<Shoes> shoes  = readShop("Product.DAT");
        String colorSearch ;
        System.out.println("Nhập màu mà bạn muốn tìm : ");
        colorSearch = sc.nextLine();
        int cnt = 0;
        for ( int i =0 ; i < shoes.size(); i++){
            if(shoes.get(i).getColor().equals(colorSearch)) {
                System.out.println(shoes.get(i));
                cnt++;
            }
        }
        if (cnt == 0){
            System.out.println("Invalid Product Color !");
        }
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    //tìm kiếm theo mức giá giảm
    public void searchProductBySortDecrease() throws IOException {
        List<Shoes> shoes = readShop("Product.DAT");
        for( int i =0 ; i < shoes.size() - 1; i++){
            for( int j = i+1; j < shoes.size(); j++){
                if(shoes.get(i).getPrice() < shoes.get(j).getPrice()){
                    Shoes tg = shoes.get(i);
                    shoes.set(i, shoes.get(j));
                    shoes.set(j,tg);
                }
            }
        }
        writeShop(shoes,"Product.DAT");
        showProduct(shoes);
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    //tìm theo giá tăng dần
    public void searchProductBySortIncrease() throws IOException {
        List<Shoes> shoes = readShop("Product.DAT");
        for( int i =0 ; i < shoes.size() - 1; i++){
            for( int j = i + 1; j < shoes.size(); j++){
                if(shoes.get(i).getPrice() > shoes.get(j).getPrice()){
                    Shoes tg = shoes.get(i);
                    shoes.set(i, shoes.get(j));
                    shoes.set(j,tg);
                }
            }
        }
        writeShop(shoes,"Product.DAT");
        showProduct(shoes);
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
    }
    public void buyShoes() throws IOException {
        List<Shoes> shoes = readShop("Product.DAT");
        List<Shoes> order = readShop("Order.DAT");
        List<Bill> bills = billController.readBill("Bill.DAT");
        Integer idBuy;
        String checkBuy;
        int quantityBuy;
        do{
            System.out.println("Enter Id Shoes you want buy : ");
            idBuy = sc.nextInt();
            System.out.println("Enter Quantity Purchased : ");
            quantityBuy = sc.nextInt();
            for( int i = 0 ; i < shoes.size(); i++){
                if(idBuy.equals(shoes.get(i).getIdShoes())){
                    shoes.get(i).setQuantity(shoes.get(i).getQuantity() - quantityBuy );
                    writeShop(shoes,"Product.DAT");
                    order.add(shoes.get(i));
                    writeShop(order,"Order.DAT");
                    order.get(i).setQuantity(quantityBuy);
                    writeShop(order,"Order.DAT");
                }
            }
            sc.nextLine();
            System.out.println("Do you want to buy anything more ? [Y/N] ");
            checkBuy = sc.nextLine();
        }while(checkBuy.compareToIgnoreCase("Y")==0);
        System.out.println("");
        showBuy();
        System.out.println("");
        String back;
        System.out.println("Do you want some Choose !  [Y/N] ");
        back = sc.nextLine();
        if(back.compareToIgnoreCase("Y") == 0){
            searchProduct();
        }else{
            System.out.println("============ Thank you ! See you later !===========");
            System.exit(0);
        }
        //check buy
//        for(int i =0 ; i < order.size() - 1 ;i++){
//            for( int j = i + 1; j < order.size(); j++){
//                if(order.get(i).getIdShoes() == order.get(j).getIdShoes()){
//                    order.get(i).setQuantity(order.get(i).getQuantity()+order.get(j).getQuantity());
//                    order.set(j,order.get(j+1));
//                    order.set(j+1,null);
//                    writeShop(order,"Order.DAT");
//                }
//            }
//        }
    }
    public void showBuy() throws IOException {
        long total = 0;
        List<Shoes> buyShoes = readShop("Order.DAT");
        for( int i =0 ; i < buyShoes.size();i++){
            total += buyShoes.get(i).getPrice() * buyShoes.get(i).getQuantity();
//            *(bill.getDiscount()/100)
        }
        showShoesBuy(buyShoes);
        System.out.println("Total Amount To  : " + total+ " VND");
    }

}
