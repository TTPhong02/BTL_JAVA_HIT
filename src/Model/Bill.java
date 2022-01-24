package Model;

import Controller.FileController;
import Controller.PersonController;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private Integer idBill;
    private List<Person> personList = new ArrayList<>();
    private List<Shoes> shoes = new ArrayList<>();
    private Double discount;
    public Bill() {}
    public Bill(Integer idBill, List<Person> personList, List<Shoes> shoes, Double discount) {
        this.idBill = idBill;
        this.personList = personList;
        this.shoes = shoes;
        this.discount = discount;
    }

    public Bill(Integer newIDBill, Person person, Shoes shoes, Double discount) {
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

//    public String getIdPerson() {
//        return idPerson;
//    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
//
//    public void setIdPerson(String idPerson) {
//        this.idPerson = idPerson;
//    }

    public List<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
