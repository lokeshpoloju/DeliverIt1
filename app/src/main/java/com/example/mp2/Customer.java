package com.example.mp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customer extends AppCompatActivity {
    Button btnCtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        btnCtm = (Button) findViewById(R.id.btnCtm);
        btnCtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCustomer();
            }
        });
    }
    public void openActivityCustomer(){
        Intent i11=new Intent(this, resultCustomer.class);
        startActivity(i11);
    }

}