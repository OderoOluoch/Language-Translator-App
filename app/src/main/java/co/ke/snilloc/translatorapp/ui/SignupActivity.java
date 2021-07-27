package co.ke.snilloc.translatorapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.R;
import co.ke.snilloc.translatorapp.models.User;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    //hook views
    @BindView(R.id.SignupEmailAddressEditText) EditText mSignupEmailAddressEditText;
    @BindView(R.id.SignupPasswordEditText) EditText mSignupPasswordEditText;
    @BindView(R.id.SignupConfirmPasswordEditText) EditText mSignupConfirmPasswordEditText;
    @BindView(R.id.SignUpUsernameEditText) EditText mSignUpUsernameEditText;
    @BindView(R.id.SignupButton) Button mSignupButton;
    @BindView(R.id.SignupAlreadyMemberTextView) TextView mSignupAlreadyMemberTextView;
    @BindView(R.id.SignupProgressBar) ProgressBar mSignupProgressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
        
        mAuth = FirebaseAuth.getInstance();

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
        String username = mSignUpUsernameEditText.getText().toString().trim();
        String email = mSignupEmailAddressEditText.getText().toString().trim();
        String password = mSignupPasswordEditText.getText().toString().trim();
        String confirmPassword = mSignupConfirmPasswordEditText.getText().toString().trim();

        if (username.isEmpty()){
            mSignUpUsernameEditText.setError("Name is required");
            mSignUpUsernameEditText.requestFocus();
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

        //show progress bar
        mSignupProgressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(username,email);

                    //save it to firebase
                    FirebaseDatabase.getInstance().getReference("users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignupActivity.this, "User has been created successfully", Toast.LENGTH_SHORT).show();

                                //redirect the user to login activity
                                
                            }else{
                                Toast.makeText(SignupActivity.this, "Failed to create, Try again!", Toast.LENGTH_SHORT).show();

                                //hide progress bar
                                mSignupProgressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignupActivity.this, "Failed to create, Try again!", Toast.LENGTH_SHORT).show();

                    //hide progress bar too
                    mSignupProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}