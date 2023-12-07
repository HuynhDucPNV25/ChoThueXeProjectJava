package AdminPages;

public class UserData {

    private String name;
    private String userAccount;
    private String password;
    private String role;
    private String phone;
    private String address;
    private String gmail;
    private String idPesonnal;

    public UserData(String name, String useraccount, String password, String role, String phone, String address, String gmail, String idPesonnal) {
        this.name = name;
        this.userAccount = useraccount;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.address = address;
        this.gmail = gmail;
        this.idPesonnal = idPesonnal;
    }

    public String getName() {
        return name;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGmail() {
        return gmail;
    }

    public String getIdPesonnal() {
        return idPesonnal;
    }
}
