package co.ke.snilloc.translatorapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.translatorapp.R;

public class TranslatorActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.TextInputEditText) EditText mTextInputEditText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.spinner) Spinner mSpinner;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.TranslateButton) Button mTranslateButton;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.TextTranslatedTextView) TextView mTextTranslatedTextView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.TranslateProgressBar) ProgressBar mTranslateProgressBar;

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

        mTranslateButton.setOnClickListener(v -> {
            String userInput = mTextInputEditText.getText().toString();
            String userLanguage = mSpinner.getSelectedItem().toString();
            mTranslateProgressBar.setVisibility(View.VISIBLE);

            if (userInput.isEmpty()) {
                Toast.makeText(TranslatorActivity.this, "Enter text to translate", Toast.LENGTH_SHORT).show();
                mTranslateProgressBar.setVisibility(View.GONE);
            } else {
               switch (userLanguage){

                   //Afrikaans
                   case "Afrikaans af":
                       TranslateAPI Afrikaans = new TranslateAPI(Language.AUTO_DETECT,Language.AFRIKAANS,userInput);

                       Afrikaans.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                       //Albanian
                   case "Albanian sq":
                       TranslateAPI Albanian = new TranslateAPI(Language.AUTO_DETECT,Language.ALBANIAN,userInput);

                       Albanian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                       //Arabic
                   case "Arabic ar":
                       TranslateAPI Arabic = new TranslateAPI(Language.AUTO_DETECT,Language.ARABIC,userInput);

                       Arabic.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                       //Armenian
                   case "Armenian hy":
                       TranslateAPI Armenian = new TranslateAPI(Language.AUTO_DETECT,Language.ARMENIAN,userInput);

                       Armenian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Azerbaijani
                   case "Azerbaijani az":
                       TranslateAPI Azerbaijani = new TranslateAPI(Language.AUTO_DETECT,Language.AZERBAIJANI,userInput);

                       Azerbaijani.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Basque
                   case "Basque eu":
                       TranslateAPI Basque = new TranslateAPI(Language.AUTO_DETECT,Language.BASQUE,userInput);

                       Basque.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Belarusian
                   case "Belarusian be":
                       TranslateAPI Belarusian = new TranslateAPI(Language.AUTO_DETECT,Language.BELARUSIAN,userInput);

                       Belarusian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Bengali
                   case "Bengali bn":
                       TranslateAPI Bengali = new TranslateAPI(Language.AUTO_DETECT,Language.BENGALI,userInput);

                       Bengali.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Bulgarian
                   case "Bulgarian bg":
                       TranslateAPI Bosnian = new TranslateAPI(Language.AUTO_DETECT,Language.BULGARIAN,userInput);

                       Bosnian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Catalan
                   case "Catalan ca":
                       TranslateAPI Catalan = new TranslateAPI(Language.AUTO_DETECT,Language.CATALAN,userInput);

                       Catalan.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Chinese_Simplified
                   case "Chinese (Simplified) zh-CN (BCP-47)":
                       TranslateAPI Chinese_Simplified = new TranslateAPI(Language.AUTO_DETECT,Language.CHINESE_SIMPLIFIED,userInput);

                       Chinese_Simplified.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Chinese_Traditional
                   case "Chinese (Traditional) zh-TW (BCP-47)":
                       TranslateAPI Chinese_Traditional = new TranslateAPI(Language.AUTO_DETECT,Language.CHINESE_TRADITIONAL,userInput);

                       Chinese_Traditional.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Croatian
                   case "Croatian hr":
                       TranslateAPI Croatian = new TranslateAPI(Language.AUTO_DETECT,Language.CROATIAN,userInput);

                       Croatian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Czech
                   case "Czech cs":
                       TranslateAPI Czech = new TranslateAPI(Language.AUTO_DETECT,Language.CZECH,userInput);

                       Czech.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Danish
                   case "Danish da":
                       TranslateAPI Danish = new TranslateAPI(Language.AUTO_DETECT,Language.DANISH,userInput);

                       Danish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Dutch
                   case "Dutch nl":
                       TranslateAPI Dutch = new TranslateAPI(Language.AUTO_DETECT,Language.DUTCH,userInput);

                       Dutch.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //English
                   case "English en":
                       TranslateAPI English = new TranslateAPI(Language.AUTO_DETECT,Language.ENGLISH,userInput);

                       English.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Estonian
                   case "Estonian et":
                       TranslateAPI Estonian = new TranslateAPI(Language.AUTO_DETECT,Language.ESTONIAN,userInput);

                       Estonian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Finnish
                   case "Finnish fi":
                       TranslateAPI Finnish = new TranslateAPI(Language.AUTO_DETECT,Language.FINNISH,userInput);

                       Finnish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //French
                   case "French fr":
                       TranslateAPI French = new TranslateAPI(Language.AUTO_DETECT,Language.FRENCH,userInput);

                       French.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Galician
                   case "Galician gl":
                       TranslateAPI Galician = new TranslateAPI(Language.AUTO_DETECT,Language.GALICIAN,userInput);

                       Galician.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Georgian
                   case "Georgian ka":
                       TranslateAPI Georgian = new TranslateAPI(Language.AUTO_DETECT,Language.GEORGIAN,userInput);

                       Georgian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //German
                   case "German de":
                       TranslateAPI German = new TranslateAPI(Language.AUTO_DETECT,Language.GERMAN,userInput);

                       German.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Greek
                   case "Greek el":
                       TranslateAPI Greek = new TranslateAPI(Language.AUTO_DETECT,Language.GREEK,userInput);

                       Greek.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Gujarati
                   case "Gujarati gu":
                       TranslateAPI Gujarati = new TranslateAPI(Language.AUTO_DETECT,Language.GUJARATI,userInput);

                       Gujarati.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Haitian
                   case "Haitian Creole ht":
                       TranslateAPI Haitian = new TranslateAPI(Language.AUTO_DETECT,Language.HAITIAN_CREOLE,userInput);

                       Haitian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Hebrew
                   case "Hebrew he**":
                       TranslateAPI Hebrew = new TranslateAPI(Language.AUTO_DETECT,Language.HEBREW,userInput);

                       Hebrew.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Hindi
                   case "Hindi hi":
                       TranslateAPI Hindi = new TranslateAPI(Language.AUTO_DETECT,Language.HINDI,userInput);

                       Hindi.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Hungarian
                   case "Hungarian hu":
                       TranslateAPI Hungarian = new TranslateAPI(Language.AUTO_DETECT,Language.HUNGARIAN,userInput);

                       Hungarian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Icelandic
                   case "Icelandic is":
                       TranslateAPI Icelandic = new TranslateAPI(Language.AUTO_DETECT,Language.ICELANDIC,userInput);

                       Icelandic.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Indonesian
                   case "Indonesian id":
                       TranslateAPI Indonesian = new TranslateAPI(Language.AUTO_DETECT,Language.INDONESIAN,userInput);

                       Indonesian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Irish
                   case "Irish ga":
                       TranslateAPI Irish = new TranslateAPI(Language.AUTO_DETECT,Language.IRISH,userInput);

                       Irish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Italian
                   case "Italian it":
                       TranslateAPI Italian = new TranslateAPI(Language.AUTO_DETECT,Language.ITALIAN,userInput);

                       Italian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Japanese
                   case "Japanese ja":
                       TranslateAPI Japanese = new TranslateAPI(Language.AUTO_DETECT,Language.JAPANESE,userInput);

                       Japanese.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Kannada
                   case "Kannada kn":
                       TranslateAPI Kannada = new TranslateAPI(Language.AUTO_DETECT,Language.KANNADA,userInput);

                       Kannada.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Korean
                   case "Korean ko":
                       TranslateAPI Korean = new TranslateAPI(Language.AUTO_DETECT,Language.KOREAN,userInput);

                       Korean.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Latin
                   case "Latin la":
                       TranslateAPI Latin = new TranslateAPI(Language.AUTO_DETECT,Language.LATIN,userInput);

                       Latin.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Latvian
                   case "Latvian lv":
                       TranslateAPI Latvian = new TranslateAPI(Language.AUTO_DETECT,Language.LATVIAN,userInput);

                       Latvian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Macedonian
                   case "Macedonian mk":
                       TranslateAPI Macedonian = new TranslateAPI(Language.AUTO_DETECT,Language.MACEDONIAN,userInput);

                       Macedonian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Malay
                   case "Malay ms":
                       TranslateAPI Malay = new TranslateAPI(Language.AUTO_DETECT,Language.MALAY,userInput);

                       Malay.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Maltese
                   case "Maltese mt":
                       TranslateAPI Maltese = new TranslateAPI(Language.AUTO_DETECT,Language.MALTESE,userInput);

                       Maltese.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Norwegian
                   case "Norwegian no":
                       TranslateAPI Norwegian = new TranslateAPI(Language.AUTO_DETECT,Language.NORWEGIAN,userInput);

                       Norwegian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Persian
                   case "Persian fa":
                       TranslateAPI Persian = new TranslateAPI(Language.AUTO_DETECT,Language.PERSIAN,userInput);

                       Persian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Polish
                   case "Polish pl":
                       TranslateAPI Polish = new TranslateAPI(Language.AUTO_DETECT,Language.POLISH,userInput);

                       Polish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Portuguese
                   case "Portuguese (Portugal, Brazil) pt":
                       TranslateAPI Portuguese = new TranslateAPI(Language.AUTO_DETECT,Language.PORTUGUESE,userInput);

                       Portuguese.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Romanian
                   case "Romanian ro":
                       TranslateAPI Romanian = new TranslateAPI(Language.AUTO_DETECT,Language.ROMANIAN,userInput);

                       Romanian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Russian
                   case "Russian ru":
                       TranslateAPI Russian = new TranslateAPI(Language.AUTO_DETECT,Language.RUSSIAN,userInput);

                       Russian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Serbian
                   case "Serbian sr":
                       TranslateAPI Serbian = new TranslateAPI(Language.AUTO_DETECT,Language.SERBIAN,userInput);

                       Serbian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Slovak
                   case "Slovak sk":
                       TranslateAPI Slovak = new TranslateAPI(Language.AUTO_DETECT,Language.SLOVAK,userInput);

                       Slovak.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Slovenian
                   case "Slovenian sl":
                       TranslateAPI Slovenian = new TranslateAPI(Language.AUTO_DETECT,Language.SLOVENIAN,userInput);

                       Slovenian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Spanish
                   case "Spanish es":
                       TranslateAPI Spanish = new TranslateAPI(Language.AUTO_DETECT,Language.SPANISH,userInput);

                       Spanish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Swahili
                   case "Swahili sw":
                       TranslateAPI Swahili = new TranslateAPI(Language.AUTO_DETECT,Language.SWAHILI,userInput);

                       Swahili.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Tamil
                   case "Tamil ta":
                       TranslateAPI Tamil = new TranslateAPI(Language.AUTO_DETECT,Language.TAMIL,userInput);

                       Tamil.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Telugu
                   case "Telugu te":
                       TranslateAPI Telugu = new TranslateAPI(Language.AUTO_DETECT,Language.TELUGU,userInput);

                       Telugu.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Thai
                   case "Thai th":
                       TranslateAPI Thai = new TranslateAPI(Language.AUTO_DETECT,Language.THAI,userInput);

                       Thai.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Turkish
                   case "Turkish tr":
                       TranslateAPI Turkish = new TranslateAPI(Language.AUTO_DETECT,Language.TURKISH,userInput);

                       Turkish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Ukrainian
                   case "Ukrainian uk":
                       TranslateAPI Ukrainian = new TranslateAPI(Language.AUTO_DETECT,Language.UKRAINIAN,userInput);

                       Ukrainian.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Urdu
                   case "Urdu ur":
                       TranslateAPI Urdu = new TranslateAPI(Language.AUTO_DETECT,Language.URDU,userInput);

                       Urdu.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Vietnamese
                   case "Vietnamese vi":
                       TranslateAPI Vietnamese = new TranslateAPI(Language.AUTO_DETECT,Language.VIETNAMESE,userInput);

                       Vietnamese.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Tamil
                   case "Welsh cy":
                       TranslateAPI Welsh = new TranslateAPI(Language.AUTO_DETECT,Language.WELSH,userInput);

                       Welsh.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;

                   //Yiddish
                   case "Yiddish yi":
                       TranslateAPI Yiddish = new TranslateAPI(Language.AUTO_DETECT,Language.YIDDISH,userInput);

                       Yiddish.setTranslateListener(new TranslateAPI.TranslateListener() {
                           @Override
                           public void onSuccess(String translatedText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               mTextTranslatedTextView.setText(translatedText);
                           }

                           @Override
                           public void onFailure(String ErrorText) {
                               mTranslateProgressBar.setVisibility(View.GONE);
                               Toast.makeText(TranslatorActivity.this, "Failed try again later!", Toast.LENGTH_SHORT).show();
                           }
                       });
                       break;
               }
            }
            mTranslateProgressBar.setVisibility(View.GONE);
        });

        //enables user to copy the translated text
        mTextTranslatedTextView.setOnClickListener(v -> {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("TranslatedText", mTextTranslatedTextView.getText().toString());
            clipboardManager.setPrimaryClip(clipData);

            Toast.makeText(TranslatorActivity.this, "Copied", Toast.LENGTH_SHORT).show();
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