public class SearchResult {
    private int pageid;
    private String title;

    public int getPageid() {
        return pageid;
    }

    public String getTitle() {
        return title;
    }

    public SearchResult(int pageid, String title) {
        this.pageid = pageid;
        this.title = title;
    }
}
