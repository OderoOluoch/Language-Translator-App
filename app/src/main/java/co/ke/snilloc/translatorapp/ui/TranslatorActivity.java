package co.ke.snilloc.translatorapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.R;

public class TranslatorActivity extends AppCompatActivity {
    @BindView(R.id.TextInputEditText) EditText mTextInputEditText;
    @BindView(R.id.spinner) Spinner mSpinner;
    @BindView(R.id.TranslateButton) Button mTranslateButton;
    @BindView(R.id.TextTranslatedTextView) TextView mTextTranslatedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        ButterKnife.bind(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages_supported, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        mTranslateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = mTextInputEditText.getText().toString();
                String userLanguage = mSpinner.getSelectedItem().toString();


                if (userInput.isEmpty()) {
                    Toast.makeText(TranslatorActivity.this, "Enter text to translate", Toast.LENGTH_SHORT).show();
                } else {
                    TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT, Language.AFRIKAANS, userInput);

                    translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                        @Override
                        public void onSuccess(String translatedText) {
                            mTextTranslatedTextView.setText(translatedText);
                        }

                        @Override
                        public void onFailure(String ErrorText) {
                            Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        //enables user to copy the translated text
        mTextTranslatedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("TranslatedText", mTextTranslatedTextView.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(TranslatorActivity.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_login){
            accountLogin();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void accountLogin() {
        startActivity(new Intent(TranslatorActivity.this,LoginActivity.class));
        Toast.makeText(this, "Log in to your account", Toast.LENGTH_SHORT).show();
    }
}