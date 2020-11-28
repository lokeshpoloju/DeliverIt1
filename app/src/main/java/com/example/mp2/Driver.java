package com.example.mp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Driver extends AppCompatActivity {

    EditText etDriver;
    Button btndrv;
    TextView txt1;
    FirebaseFirestore db2;
    Boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        etDriver=findViewById(R.id.etDriver);
        btndrv=findViewById(R.id.btndrv);
        txt1=findViewById(R.id.txt1);
        db2=FirebaseFirestore.getInstance();
        btndrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataDrv();
            }
        });
    }
    public void getDataDrv(){
        db2.collection("orders")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String str= "";
                            for(DocumentSnapshot document:task.getResult()){
                                Order order=document.toObject(Order.class);
                                if(etDriver.getText().toString().equals(order.getDriverid())) {
                                    str += "Hi " + order.getName() +"\n" + "Your tasks are " +order.getOrderid()+"\n" + " scheduled at " + order.getTime();
                                    flag=false;
                                }
                            }
                            if(flag==true){
                                str+="No driver Id "+etDriver.getText().toString() ;
                            }
                            txt1.setText(str);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}