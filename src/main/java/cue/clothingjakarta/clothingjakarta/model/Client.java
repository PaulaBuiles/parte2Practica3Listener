package cue.clothingjakarta.clothingjakarta.model;

public class Client{
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String confirm_password;
    private String email;
    private String address;


    public Client( Integer id, String name,String username, String password,String confirm_password, String email, String address ) {
        this.id =id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
