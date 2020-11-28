package com.example.mp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAdmin();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDriver();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCustomer();
            }
        });

    }
    public void moveToAdmin(){
        Intent i=new Intent(MainActivity.this,Admin.class);
        startActivity(i);
    }
    public void moveToDriver(){
        Intent i1= new Intent(MainActivity.this,Driver.class);
        startActivity(i1);
    }

    public void moveToCustomer(){
        Intent i2=new Intent(MainActivity.this,Customer.class);
        startActivity(i2);
    }


}