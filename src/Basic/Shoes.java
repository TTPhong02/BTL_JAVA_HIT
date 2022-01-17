package Basic;

import java.util.Scanner;

public class Shoes {
    private String idShoes;
    private String nameShoes;
    private String idType;
    private String nameType;
    private String color;
    private String size;
    private Double price;
    private String origin;
    private Integer quantity;
    public Shoes(){

    }
    public void NHAP(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id kiểu: ");
        idType = sc.nextLine();
        System.out.println("Nhâp tên kiểu: ");
        nameType = sc.nextLine();
        System.out.println("Nhập id Giày: ");
        idShoes = sc.nextLine();
        System.out.println("Nhập tên Giày: ");
        nameShoes = sc.nextLine();
        System.out.println("Nhập màu : ");
        color = sc.nextLine();
        System.out.println("Nhập size: ");
        size = sc.nextLine();
        System.out.println("Nhập xuất sứ: ");
        origin = sc.nextLine();
        System.out.println("Nhập giá: ");
        price = sc.nextDouble();
        System.out.println("Nhập số lượng:");
        quantity = sc.nextInt();
    }

    public void XUAT(){
        System.out.printf("%10s %20s %20s %20s %20s %20s %20s %20s  \n",idType,nameType, idShoes, nameShoes,color,price,origin,quantity);
    }

    public Shoes(String idShoes, String nameShoes, String idType, String nameType, String color, String size, Double price, String origin, Integer quantity) {
        this.idShoes = idShoes;
        this.nameShoes = nameShoes;
        this.idType = idType;
        this.nameType = nameType;
        this.color = color;
        this.size = size;
        this.price = price;
        this.origin = origin;
        this.quantity = quantity;
    }

    public String getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(String idShoes) {
        this.idShoes = idShoes;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNameShoes() {
        return nameShoes;
    }
    public void setNameShoes(String nameShoes) {
        this.nameShoes = nameShoes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "idShoes='" + idShoes + '\'' +
                ", nameShoes='" + nameShoes + '\'' +
                ", idType='" + idType + '\'' +
                ", nameType='" + nameType + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
