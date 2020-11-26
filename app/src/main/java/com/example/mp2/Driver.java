package com.example.mp2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Driver extends AppCompatActivity {
    Button btndrv;
    TextView txt1;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        btndrv=(Button)findViewById(R.id.btndrv);
        txt1=(TextView)findViewById(R.id.txt1);

        db=FirebaseFirestore.getInstance();

        btndrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDriver();
            }
        });
    }

    public void getDriver(){
        db.collection("deliverit-326b5")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String str="";
                            for(DocumentSnapshot document :task.getResult()){
                                order1 or=document.toObject(order1.class);
                                str="item" +or.getDriverid() +"hello";
                            }
                            txt1.setText(str);
                        }
                    }
                });
    }

}