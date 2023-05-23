package Service.Register;

import Dao.Book.Book;
import Dao.Book.BookDao;
import Service.Register.Vo.RegisterBookVo;

import java.sql.SQLException;

public class RegisterService {

    static BookDao bookDao = new BookDao();

    public void setBookRegister(Book book) throws SQLException {

        int result =bookDao.insert(book);
        System.out.println(result);
    }
}
