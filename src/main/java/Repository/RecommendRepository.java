package Repository;

import Controller.Recommned.BookRecommend;

import java.util.HashMap;
import java.util.LinkedList;

public class RecommendRepository {

    private static final RecommendRepository instance = new RecommendRepository();
    private final LinkedList<BookRecommend> bookRecommendRepository = new LinkedList<>();

    public LinkedList<BookRecommend> getRepository() {
        return bookRecommendRepository;
    }

    private RecommendRepository() {

        HashMap<String, String> bookRecommendMap = new HashMap<>();
        bookRecommendMap.put("소설", "1");
        bookRecommendMap.put("한국", "2");
        bookRecommendRepository.add(new BookRecommend(1,"한국소설 1" , bookRecommendMap));
        bookRecommendRepository.add(new BookRecommend(2,"한국소설 2" , bookRecommendMap));
   }

    public static RecommendRepository getInstance() {
        return instance;
    }

    public void add(BookRecommend bookRecommend ) {
        // TODO Auto-generated method stub
        bookRecommendRepository.add(bookRecommend);
    }
}