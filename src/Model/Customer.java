package Model;

import java.util.Scanner;

public class Customer extends Person {
    private String feedBack;
    private String rate;
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy gửi cho chúng tôi feedbacks  : ");
        feedBack = sc.nextLine();
        System.out.println("Hãy đánh giá chúng tôi: ");
        rate = sc.nextLine();
    }

    public Customer(String feedBack, String rate) {
        this.feedBack = feedBack;
        this.rate = rate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}
