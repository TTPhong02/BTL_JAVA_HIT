package Basic;

import Basic.Shoes;

import java.util.Scanner;

public class Shop {
    private String addressShop;
    private String hotLine;
    private Shoes[] shoes;
    int n;

    public Shop() {
    }
    public void NHAP(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập địa chỉ Shop: ");
        addressShop = sc.nextLine();
        System.out.println("Nhập hotline: ");
        hotLine = sc.nextLine();
        System.out.println("Nhập các mẫu giày: ");
        n = sc.nextInt();
        shoes  = new Shoes[n];
        for(int i =0 ; i < n ; i++){
            shoes[i] = new Shoes();
            shoes[i].NHAP();
        }
    }

    public Shop(String addressShop, String hotlIne) {
        this.addressShop = addressShop;
    }

    public String getAddressShop() {
        return addressShop;
    }

    public void setAddressShop(String addressShop) {
        this.addressShop = addressShop;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void XUAT(){
        System.out.printf("Địa chỉ: %20s",addressShop);
        System.out.printf("%20s","Hotline: %20s\n",hotLine);
        System.out.printf("%100s","Thông tin các mẫu giày\n");
        System.out.printf("%10s %20s %20s %20s %20s %20s %20s %20s \n" ,"Mã kiểu","Tên Kiểu", "Mã giày", "Tên Giày","Màu","Giá","Xuất sứ","Số lượng");
        for( int i =0 ; i < n ; i++){
            shoes[i].XUAT();
        }
    }
}

