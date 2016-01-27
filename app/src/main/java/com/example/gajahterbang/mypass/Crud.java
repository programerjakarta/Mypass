package com.example.gajahterbang.mypass;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gajahterbang on 1/27/2016.
 */
public class Crud extends AppCompatActivity {

    MyDBHandler myDb;
    TextView idView;
    EditText editTextIP,editTextNAMA,editTextUSERNAME,editTextPASSWORD,editTextKETERANGAN;
    Button buttonAdd;

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
        myDb = new MyDBHandler(this);
        editTextIP = (EditText)findViewById(R.id.editTextIP);
        editTextNAMA= (EditText)findViewById(R.id.editTextNAMA);
        editTextUSERNAME = (EditText)findViewById(R.id.editTextUSERNAME);
        editTextPASSWORD = (EditText)findViewById(R.id.editTextPASSWORD);
        editTextKETERANGAN = (EditText)findViewById(R.id.editTextKETERANGAN);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        AddData();

    }

    public void AddData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    editTextIP.setText(editTextKETERANGAN.getText().toString());
                boolean isInserted = myDb.insertData(editTextIP.getText().toString(),
                        editTextNAMA.getText().toString(),
                        editTextUSERNAME.getText().toString(),
                        editTextPASSWORD.getText().toString(),
                        editTextKETERANGAN.getText().toString());
                if (isInserted == true)
                    Toast.makeText(Crud.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Crud.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
