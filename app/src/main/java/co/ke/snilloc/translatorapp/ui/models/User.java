package co.ke.snilloc.translatorapp.ui.models;

public class User {
    String username,email;

    public User(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username,String email){
        this.username = username;
        this.email = email;
    }
}
