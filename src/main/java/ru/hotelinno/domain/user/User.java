package ru.hotelinno.domain.user;

public final class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int permissions;
    private String password;

    public int getUserID() {return userID;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public int getPermissions() {return permissions;}
    public String getPassword() {return password;}

    public void setUserID(int userID) {this.userID = userID;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setPermissions(int permissions) {this.permissions = permissions;}
    public void setPassword(String password) {this.password = password;}
}