package DataAccessLayer.interfaces;

public class DAdmin {
    int adminID;
    String adminName;
    String adminContact;
    String adminEmail;
    
    public DAdmin(int adminID, String adminName, String adminContact, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminContact = adminContact;
        this.adminEmail = adminEmail;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    
}
