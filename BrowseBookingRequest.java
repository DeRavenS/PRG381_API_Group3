import java.time.LocalDateTime;

public class BrowseBookingRequest {
    
    String bookingID;
    String userID;
    BrowserRequest browseRequest;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String theme;
    String venue;
    String type;
    int maxGuests;
    int minGuests;
    float minCost;
    float maxCost;
    Boolean confirmed;

    public String getBookingID() {
        return bookingID;
    }
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public BrowserRequest getBrowseRequest() {
        return browseRequest;
    }
    public void setBrowseRequest(BrowserRequest browseRequest) {
        this.browseRequest = browseRequest;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getMaxGuests() {
        return maxGuests;
    }
    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
    public int getMinGuests() {
        return minGuests;
    }
    public void setMinGuests(int minGuests) {
        this.minGuests = minGuests;
    }
    public float getMinCost() {
        return minCost;
    }
    public void setMinCost(float minCost) {
        this.minCost = minCost;
    }
    public float getMaxCost() {
        return maxCost;
    }
    public void setMaxCost(float maxCost) {
        this.maxCost = maxCost;
    }
    public Boolean getConfirmed() {
        return confirmed;
    }
    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    
}
