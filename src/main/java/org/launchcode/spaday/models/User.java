package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {


    @NotBlank(message = "Username is required")
    @Size(min=5, max=15)
    private String username;
    @Email(regexp = ".+@.+\\..+||null")

    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    //@NotNull(message = "Passwords do not match.")
    //private String verifyPassword;

    private int id;
    private static int nextId = 1;

    public User(){
        id=nextId;
        nextId++;
    }

    public User(String username, String email, String password, int id) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        //this.id = id;
        //nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        checkPassword();
    }

//    public String getVerifyPassword() {
//        return verifyPassword;
//    }

//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//        checkPassword();
//    }

//    private void checkPassword(){
//        if(password != null && verifyPassword != null && password != verifyPassword){
//            verifyPassword = null;
//        }
//    }
//
    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
