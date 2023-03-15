package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dictionary_activity extends Activity {

    String url;
    private TextView txtInf;
    private EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dictionary);

        txtInf = (TextView) findViewById(R.id.txtInf);
        txtSearch = (EditText) findViewById(R.id.txtSearch);
    }

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = txtSearch.getText().toString();
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void sendRequestOnClick(View v)
    {
        dictionaryRequest dR = new dictionaryRequest(this, txtInf);
        url = dictionaryEntries();
        dR.execute(url);

    }
}