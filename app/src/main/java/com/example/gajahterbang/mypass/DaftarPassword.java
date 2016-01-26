package com.example.gajahterbang.mypass;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by gajahterbang on 1/26/2016.
 */
public class DaftarPassword extends Activity{
    ListView lView;
    ArrayAdapter<String> adapter;
    String[] mobil = {"sedan","jeep","pickup","truck"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftarpassword);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        lView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lView.setAdapter(adapter);
    }
}
