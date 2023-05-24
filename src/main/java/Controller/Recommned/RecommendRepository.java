package Controller.Recommned;

import Controller.Rent.RentRepository;
import Dao.BookRent.BookRent;

import java.sql.Date;
import java.util.LinkedList;

public class RecommendRepository {

    private static final RecommendRepository instance = new RecommendRepository();
    private final LinkedList<BookRecommend> bookRecommendRepository = new LinkedList<>();

    public LinkedList<BookRecommend> getRepository() {
        return bookRecommendRepository;
    }

    private RecommendRepository() {
//        bookRecommendRepository.add(new BookRecommend("승우", "한국소설 1", 1, Date.valueOf("2023-05-20"), 500));
//        bookRecommendRepository.add(new BookRecommend("승훈", "한국소설 2", 2, Date.valueOf("2023-05-25"), 500));
//        bookRecommendRepository.add(new BookRecommend("무광", "서양소설 1", 3, Date.valueOf("2023-05-23"), 500));
    }

    public static RecommendRepository getInstance() {
        return instance;
    }

    public void add(BookRecommend bookRecommend ) {
        // TODO Auto-generated method stub
        bookRecommendRepository.add(bookRecommend);
    }
}