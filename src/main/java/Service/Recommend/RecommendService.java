package Service.Recommend;

import Controller.Recommned.BookRecommend;
import Repository.RecommendRepository;
import Dao.Book.BookDao;

import java.sql.SQLException;

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
