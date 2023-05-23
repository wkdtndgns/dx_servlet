package Service.List;

import Dao.Book.Book;
import Dao.Book.BookDao;

import java.sql.SQLException;
import java.util.LinkedList;

public class ListService {
    static BookDao bookDao = new BookDao();


    // 도서 검색 서비스
    public LinkedList<Book> getBookList() throws SQLException {
        return bookDao.getBook();
    }
}
