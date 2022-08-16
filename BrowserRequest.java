public class BrowserRequest {
    
    int page;
    int itemsPerPage;

    public BrowserRequest(int page, int itemsPerPage) {
        this.page = page;
        this.itemsPerPage = itemsPerPage;
    }
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getItemsPerPage() {
        return itemsPerPage;
    }
    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
   
    
}
