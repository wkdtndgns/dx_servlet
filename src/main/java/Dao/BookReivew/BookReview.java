package Dao.BookReivew;

public class BookReview {
    String user_name;
    String book_name;
    int book_id;
    int rate;

    public BookReview(String user_name, String book_name, int book_id, int rate) {
        this.user_name = user_name;
        this.book_name = book_name;
        this.book_id = book_id;
        this.rate = rate;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public int getRate() {
        return rate;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
