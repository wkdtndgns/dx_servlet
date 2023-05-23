package Service.Update;

import Dao.Book.Book;
import Dao.Book.BookDao;

import java.sql.SQLException;
import java.util.LinkedList;

public class UpdateService {
    static BookDao bookDao = new BookDao();

    public Book getInfo(int id) throws SQLException {
        return bookDao.getBookInfo(id);
    }
    public void update(Book book, int id) throws SQLException{
        bookDao.updateBook(book, id);
    }
}
