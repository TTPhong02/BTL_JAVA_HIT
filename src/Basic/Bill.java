package Basic;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private String idBill;
    private String idPerson;
    private List<Shoes> shoes = new ArrayList<>();
    private Float discount;

    public Bill() {}

    public Bill(String idBill, String idPerson, List<Shoes> shoes, Float discount) {
        this.idBill = idBill;
        this.idPerson = idPerson;
        this.shoes = shoes;
        this.discount = discount;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public List<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
