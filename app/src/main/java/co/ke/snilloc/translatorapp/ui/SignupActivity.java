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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    //hook views
    @BindView(R.id.SignupEmailAddressEditText) EditText mSignupEmailAddressEditText;
    @BindView(R.id.SignupPasswordEditText) EditText mSignupPasswordEditText;
    @BindView(R.id.SignupConfirmPasswordEditText) EditText mSignupConfirmPasswordEditText;
    @BindView(R.id.SignupButton) Button mSignupButton;
    @BindView(R.id.SignupAlreadyMemberTextView) TextView mSignupAlreadyMemberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

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
        String email = mSignupEmailAddressEditText.getText().toString().trim();
        String password = mSignupPasswordEditText.getText().toString().trim();
        String confirmPassword = mSignupConfirmPasswordEditText.getText().toString().trim();

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
    }
}