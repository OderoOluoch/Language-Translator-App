package co.ke.snilloc.translatorapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.R;
import co.ke.snilloc.translatorapp.ui.models.User;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    //hook views
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupUsernameEditText) EditText mSignupUsernameEditText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupEmailAddressEditText) EditText mSignupEmailAddressEditText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupPasswordEditText) EditText mSignupPasswordEditText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupConfirmPasswordEditText) EditText mSignupConfirmPasswordEditText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupButton) Button mSignupButton;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupAlreadyMemberTextView) TextView mSignupAlreadyMemberTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SignupProgressBar) ProgressBar mSignupProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        ButterKnife.bind(this);

        //clickable views
        mSignupButton.setOnClickListener(this);
        mSignupAlreadyMemberTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSignupAlreadyMemberTextView){
            Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login to your account", Toast.LENGTH_SHORT).show();
        }
        if (v == mSignupButton){
            accountSignUp();
        }
    }

    private void accountSignUp() {
        //validate user inputs
        String username = mSignupUsernameEditText.getText().toString().trim();
        String email = mSignupEmailAddressEditText.getText().toString().trim();
        String password = mSignupPasswordEditText.getText().toString().trim();
        String confirmPassword = mSignupConfirmPasswordEditText.getText().toString().trim();

        if (username.isEmpty()){
            mSignupUsernameEditText.setError("Username is required");
            mSignupUsernameEditText.requestFocus();
            return;
        }

        if (email.isEmpty()){
            mSignupEmailAddressEditText.setError("Email is required");
            mSignupEmailAddressEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mSignupEmailAddressEditText.setError("Enter a valid email address");
            mSignupEmailAddressEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            mSignupPasswordEditText.setError("Password is required");
            mSignupPasswordEditText.requestFocus();
            return;
        }

        //firebase allows minimum of 6 characters
        if (password.length() < 6){
            mSignupPasswordEditText.setError("Minimum password character is < 6");
            mSignupPasswordEditText.requestFocus();
            return;
        }

        //if passwords are the same
        if (!password.equals(confirmPassword)){
            mSignupConfirmPasswordEditText.setError("Password doesn't match! Try again");
            mSignupConfirmPasswordEditText.requestFocus();
            return;
        }

        //set progress bar visible
        mSignupProgressBar.setVisibility(View.VISIBLE);

        //access firebase mauth object
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        //save user detail as object
                        User user = new User(username,email);

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()){
                                        Toast.makeText(SignupActivity.this, "User has been created successfully", Toast.LENGTH_SHORT).show();

                                        //stop progress bar
                                        mSignupProgressBar.setVisibility(View.GONE);

                                        //redirect user to login
                                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                                    }else{
                                        Toast.makeText(SignupActivity.this, "Failed to create! Try again", Toast.LENGTH_SHORT).show();

                                        //stop progress bar too
                                        mSignupProgressBar.setVisibility(View.GONE);
                                    }
                                });
                    }else{
                        Toast.makeText(SignupActivity.this, "Failed to create! Try again", Toast.LENGTH_SHORT).show();

                        //stop progress bar too
                        mSignupProgressBar.setVisibility(View.GONE);
                    }
                });
    }
}