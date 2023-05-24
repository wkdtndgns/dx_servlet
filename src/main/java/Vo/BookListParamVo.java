package Vo;

public class BookListParamVo {
    String Search;
    int Page;
    int Limit;

    public String getSearch() {
        return Search;
    }

    public void setSearch(String search) {
        Search = search == null ? "" : search;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = Integer.parseInt(page == null ? "1" : page);
    }

    public int getLimit() {
        return Limit;
    }

    public void setLimit(int limit) {
        Limit = limit;
    }
}
