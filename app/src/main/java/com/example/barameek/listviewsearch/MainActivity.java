package com.example.barameek.listviewsearch;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    EditText editText1;
    ListView listView1;
    ArrayList<String> arr_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr_list = new ArrayList<String>();
        arr_list.add("apple");
        arr_list.add("avocado");
        arr_list.add("banana");
        arr_list.add("bamboo");
        arr_list.add("blackberry");
        arr_list.add("cabbage");

        listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, arr_list));

        editText1 = (EditText)findViewById(R.id.editText1);
        editText1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable arg0) {
                ArrayList<String> src_list = new ArrayList<String>();
                int textlength = editText1.getText().length();
                for(int i = 0 ; i < arr_list.size() ; i++){
                    try {
                        if(editText1.getText().toString()
                                .equalsIgnoreCase(arr_list.get(i)
                                        .subSequence(0, textlength)
                                        .toString())){
                            src_list.add(arr_list.get(i));
                        }
                    } catch (Exception e) { }
                }
                listView1.setAdapter(new ArrayAdapter(MainActivity.this
                        , android.R.layout.simple_list_item_1
                        , src_list));
            }
            public void beforeTextChanged(CharSequence s, int start
                    , int count, int after) { }
            public void onTextChanged(CharSequence s, int start
                    , int before, int count) { }

        });

    }

}
