package com.sinhvien.myrex;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dictionary_activity extends Activity {

    String url;
    private TextView txtDefi;
    private EditText txtSearch;
    private  Button btnSearch;

    private void bindingView(){
        txtDefi = findViewById(R.id.txtDefi);
        txtSearch =  findViewById(R.id.txtSearch);
        btnSearch = findViewById(R.id.btnSearch);
    }

    private  void  bindingAction(){
        btnSearch.setOnClickListener(this :: onBtnClickSearch);
    }

    public void onBtnClickSearch(View v)
    {
        dictionaryRequest dR = new dictionaryRequest(this, txtDefi);
        url = dictionaryEntries();
        dR.execute(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dictionary);
        bindingView();
        bindingAction();
    }

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = txtSearch.getText().toString();
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/"
                + language + "/" + word_id + "?" + "fields="
                + fields + "&strictMatch=" + strictMatch;
    }

}