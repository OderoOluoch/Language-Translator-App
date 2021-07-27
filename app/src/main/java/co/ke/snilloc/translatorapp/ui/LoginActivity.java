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

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    //hook all views
    @BindView(R.id.LoginEmailAddressEditText) EditText mLoginEmailAddressEditText;
    @BindView(R.id.LoginPasswordEditText) EditText mLoginPasswordEditText;
    @BindView(R.id.LoginForgotPasswordTextView) TextView mLoginForgotPasswordTextView;
    @BindView(R.id.LoginCreateAccountTextView) TextView mLoginCreateAccountTextView;
    @BindView(R.id.LoginButton) Button mLoginButton;
    @BindView(R.id.LoginProgressBar) ProgressBar mLoginProgressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        //set clickable views
        mLoginButton.setOnClickListener(this);
        mLoginCreateAccountTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginCreateAccountTextView){
            Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Create an account", Toast.LENGTH_SHORT).show();
        }
        if (v == mLoginButton){
            accountLogin();
        }
    }

    private void accountLogin() {
        //validation
        String email = mLoginEmailAddressEditText.getText().toString().trim();
        String password = mLoginPasswordEditText.getText().toString().trim();

        if (email.isEmpty()){
            mLoginEmailAddressEditText.setError("Email is required");
            mLoginEmailAddressEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mLoginEmailAddressEditText.setError("Please enter a valid email address");
            mLoginEmailAddressEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            mLoginPasswordEditText.setError("Password is required");
            mLoginPasswordEditText.requestFocus();
            return;
        }
        if (password.length() < 6){
            mLoginPasswordEditText.setError("Minimum password character is < 6");
            mLoginPasswordEditText.requestFocus();
            return;
        }

        //make progress bar visible
        mLoginProgressBar.setVisibility(View.VISIBLE);


        //firebase authentication with email and password
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this,TranslatorActivity.class));
                    Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();

                    //stop progress bar
                    mLoginProgressBar.setVisibility(View.GONE);

                }else{
                    Toast.makeText(LoginActivity.this, "Failed to login, Try again", Toast.LENGTH_SHORT).show();

                    //stop progress bar
                    mLoginProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}