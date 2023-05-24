package Controller.Recommned;

import java.util.Map;

public class BookRecommend {
    int bookId;
    String bookName;
    Map<String,String> keyMap;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getKeyMap() {
        StringBuilder sb =new StringBuilder();
        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append(": ").append(value).append(" ");
        }
        return sb.toString();
    }

    public void setKeyMap(Map<String, String> keyMap) {
        this.keyMap = keyMap;
    }

    @Override
    public String toString() {
        return "BookRecommend{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", keyMap=" + keyMap +
                '}';
    }
}
