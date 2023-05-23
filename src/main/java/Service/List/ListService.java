package Service.List;

import Dao.Book.Book;
import Dao.Book.BookDao;

import java.sql.SQLException;
import java.util.LinkedList;

public class ListService {
    static BookDao bookDao = new BookDao();

    public LinkedList<Book> getBookList() throws SQLException {
        return bookDao.getBook();
    }
}
