package co.ke.snilloc.translatorapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

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
    }
}