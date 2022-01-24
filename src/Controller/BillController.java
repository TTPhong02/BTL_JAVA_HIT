package Controller;

import Model.Bill;
import Model.Shoes;
import Model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillController {
    private Bill bill = new Bill();
    private FileController fileController = new FileController();
    private PersonController personController;
    private ShopController shopController;
    private static  BillController billController ;
    private static Scanner sc = new Scanner(System.in);
    public BillController() {
    }

    public BillController(Bill bill, FileController fileController) {
        this.bill = bill;
        this.fileController = fileController;
    }

    public List<Bill> readBill(String namefile){
        fileController.OpenFileToRead(namefile);
        List<Bill> bills = new ArrayList<>();
        while(fileController.getScanner().hasNext()){
            String information = fileController.getScanner().nextLine();
            String[] data = information.split("//|");
            ArrayList<Shoes> shoes = new ArrayList<>();
            ArrayList<Person> personList = new ArrayList<>();
            for( int i = 0; i < data.length ; i++){
                shoes.add(new Shoes(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],data[5],Double.parseDouble(data[6]),data[7],Integer.parseInt(data[8]) ));
            }
            bills.add(new Bill(Integer.parseInt(data[0]),personList,shoes,Double.parseDouble(data[3])));
        }
        fileController.CloseFileAfterRead();
        return bills;
    }
    public void writeBill(List<Bill> bills, String namefile){
        fileController.OpenFileToRead(namefile);
        for(Bill bill : bills){
            fileController.getPrintWriter().println(bill.getIdBill()+"|"+bill.getPersonList()+"|"+bill.getShoes()+"|"+bill.getDiscount());
        }
        fileController.CloseFileAfterWrite();
    }
    //tìm kiếm bằng mức giảm giá
    public void searchProductByDiscount(List<Bill> bills){
        sc.nextLine();
        bills = billController.readBill("Bill.DAT");
        Double discountSearch ;
        System.out.println("Nhập giảm giá mà bạn muốn tìm : ");
        discountSearch = sc.nextDouble();
        for ( int i =0 ; i < bills.size(); i++){
            if(bills.get(i).getDiscount().equals(discountSearch)) {
                System.out.println(bills.get(i));
            }
            else{
                System.out.println("Không có sản phảm nào có mức giảm giá như vậy !");
            }
        }
    }
    public void checkDiscount(){
        List<Person> personList = personController.readPersons("User.DAT");
        for (int i = 0 ; i< personList.size(); i++){
            if(personList.get(0).getAge()== 18){
                bill.setDiscount(20.00);
            }
        }
    }
    public void checkBill(){
        List<Person> personList = personController.readPersons("User.DAT");
        List<Shoes> shoes = shopController.readShop("Order.DAT");
        List<Bill> bills  = readBill("Bill.DAT");
        Integer newIDBill;
        checkDiscount();
        newIDBill = bill.getIdBill()+1;
        for( int i =0 ; i < personList.size(); i++){
            for( int j = 0 ; j< shoes.size();j++){
                bills.add(new Bill(newIDBill,personList.get(i),shoes.get(j),bills.get(0).getDiscount()));
                writeBill(bills,"Bill.DAT");
            }
        }

    }

    //Show bill
    public void showBill() throws IOException {
        List<Bill> bills = billController.readBill("Bill.DAT");
        checkBill();
        for( int i =0 ; i < bills.size(); i++){
            System.out.println(bills.get(i));
        }
    }

}
