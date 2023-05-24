package Service.Recommend;

import Controller.Recommned.BookRecommend;
import Controller.Recommned.RecommendRepository;
import Dao.Book.Book;
import Dao.Book.BookDao;
import Dao.BookRent.BookRent;
import Service.List.Vo.BookListParamVo;
import com.example.servlet.UserRepository;

import java.sql.SQLException;
import java.util.LinkedList;

public class RecommendService {
    static BookDao bookDao = new BookDao();
    private final RecommendRepository recommendRepository = RecommendRepository.getInstance();

    // 도서 추천 서비스
    public void setRecommend(BookRecommend bookRecommend) throws SQLException {
        String bookName = bookDao.getBookNameByBookId(bookRecommend.getBookId());
        bookRecommend.setBookName(bookName);
        recommendRepository.add(bookRecommend);
    }
}
