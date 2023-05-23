package Dao.BookRent;

import java.sql.Date;

public class BookRent {
    final static int global_pay = 500;
    String user_name;
    int book_id;
    String book_name;
    Date end_date;
    int rent_pay;

    public BookRent(){
        this.rent_pay = global_pay;
    }

    public BookRent(String user_name,String book_name, int book_id, Date end_date, int rent_pay) {
        this.user_name = user_name;
        this.book_name = book_name;
        this.book_id = book_id;
        this.end_date = end_date;
        this.rent_pay = rent_pay;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getRent_pay() {
        return rent_pay;
    }

    public void setRent_pay(int rent_pay) {
        this.rent_pay = rent_pay;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "BookRent{" +
                "user_name='" + user_name + '\'' +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", end_date=" + end_date +
                ", rent_pay=" + rent_pay +
                '}';
    }
}
