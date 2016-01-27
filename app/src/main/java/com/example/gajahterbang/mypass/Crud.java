package com.example.gajahterbang.mypass;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gajahterbang on 1/27/2016.
 */
public class Crud extends AppCompatActivity {

    TextView idView;
    EditText ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crud_main);
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


    }

    public void newPassword(View view) {
        idView = (TextView) findViewById(R.id.pid);
        ip = (EditText) findViewById(R.id.editText2);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Password password = new Password();

        dbHandler.addPassword(password);
        ip.setText("");
    }
}
