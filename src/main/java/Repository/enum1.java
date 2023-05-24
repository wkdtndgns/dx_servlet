package Repository;

import java.util.LinkedList;
import java.util.List;

public enum enum1 {
    user((LinkedList<String>) List.of("토스", "카카오페이"));

    private final LinkedList<String> list;

    enum1(LinkedList<String> list) {
        this.list = list;
    }
}
