package com.sinhvien.myrex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class grammar_activity extends Activity {

    private ExpandableListView expandableListView;
    private List<String> listdataHeader;
    private HashMap<String,List<String>> listdataChild;
    private CustomExpandableListView customExpandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_grammar);
        addControl();
        customExpandableListView = new CustomExpandableListView(grammar_activity.this,listdataHeader,listdataChild);
        expandableListView.setAdapter(customExpandableListView);
    }

    private void addControl() {
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        listdataHeader = new ArrayList<>();
        listdataChild  = new HashMap<String, List<String>>();

        listdataHeader.add("12 TENSES");
        listdataHeader.add("PASSIVE VOICE");
        listdataHeader.add("CONDITIONAL SENTENCES");
        listdataHeader.add("WISHES");
        listdataHeader.add("TAG QUESTION");
        listdataHeader.add("COMPARISONS");

        List<String> tenses = new ArrayList<String>();
        tenses.add("Simple present tens");
        tenses.add("Present continuous");
        tenses.add("Present perfect");
        tenses.add("Present perfect continuous");
        tenses.add("Simple past");
        tenses.add("Past continuous");
        tenses.add("Past perfect");
        tenses.add("Past perfect continuous");
        tenses.add("Simple future");
        tenses.add("Future continuous");
        tenses.add("Future perfect");
        tenses.add("Future perfect continuous");

        List<String> passivevoice = new ArrayList<String>();
        passivevoice.add("Grammar structure");
        passivevoice.add("Special cases");

        List<String> conditional = new ArrayList<String>();
        conditional.add("Type 1");
        conditional.add("Type 2");
        conditional.add("Type 3");

        List<String> wishes = new ArrayList<String>();
        wishes.add("Type 1");
        wishes.add("Type 2");
        wishes.add("Type 3");

        listdataChild.put(listdataHeader.get(0),tenses);
        listdataChild.put(listdataHeader.get(1),passivevoice);
        listdataChild.put(listdataHeader.get(2),conditional);
        listdataChild.put(listdataHeader.get(3),wishes);
    }
}