package co.ke.snilloc.translatorapp.models;

public class User {
    //To save user data as objects in firebase
    public String email;
    public String username;

    public User(){

    }

    public User(String username,String email){
        this.email = email;
        this.username = username;
    }
}
