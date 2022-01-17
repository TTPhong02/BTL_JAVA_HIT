package Controller;

import Basic.Bill;
import Basic.Shoes;

import java.util.ArrayList;
import java.util.List;

public class BillController {
    private Bill bill = new Bill();
    private FileController fileController = new FileController();

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
            for( int i = 0; i < data.length ; i++){
                shoes.add(new Shoes(data[0],data[1],data[2],data[3],data[4],data[5],Double.parseDouble(data[6]),data[7],Integer.parseInt(data[8]) ));
            }
            bills.add(new Bill(data[0],data[1],shoes,Float.parseFloat(data[3])));

        }
        fileController.CloseFileAfterRead();
        return bills;
    }
    public void writeBill(List<Bill> bills, String namefile){
        fileController.OpenFileToRead(namefile);
        for(Bill bill : bills){
            fileController.getPrintWriter().println(bill.getIdBill()+"|"+bill.getIdPerson()+"|"+bill.getDiscount()+"|"+bill.getShoes());
        }
        fileController.CloseFileAfterWrite();
    }
}
