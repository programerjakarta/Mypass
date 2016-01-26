package com.example.gajahterbang.mypass;

//import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;

import java.io.Console;


public class DaftarPassword extends AppCompatActivity{
    ListView lView;
    TextView tv4;
    ArrayAdapter<String> adapter;
    String[] mobil = {"sedan","jeep","pickup","truck"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tv4 = (TextView) findViewById(R.id.tv4);
        lView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mobil);
        lView.setAdapter(adapter);
        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.print(lView.getSelectedItem().toString());
                String lst_txt = parent.getItemAtPosition(position).toString().trim();
                tv4.setText(lst_txt);
                Intent i = new Intent(DaftarPassword.this, SingleList.class);
                // sending data to new activity
                i.putExtra("data",lst_txt );
                startActivity(i);

//                System.out.println("Display text"+lst_txt );
            }
        });


    }
}
