package ru.hotelinno.domain.user;

public final class User {
    private int userID;
    private String firstName;
    private String lastName;
    private int permissions;
    private String password;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPermissions() {
        return permissions;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }
}