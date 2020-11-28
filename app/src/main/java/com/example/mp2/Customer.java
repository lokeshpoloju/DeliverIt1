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

import java.util.Arrays;

public class Customer extends AppCompatActivity {

    EditText etCtm;
    Button btnCtm;
    TextView getDriverTxt;
    FirebaseFirestore db1;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        etCtm=findViewById(R.id.etCtm);
        btnCtm=findViewById(R.id.btnCtm);
        getDriverTxt=findViewById(R.id.getDriverTxt);
        db1= FirebaseFirestore.getInstance();
        btnCtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    public void getData(){
        db1.collection("orders")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String str= "";
                            for(DocumentSnapshot document:task.getResult()){
                                Order order=document.toObject(Order.class);
                                if(etCtm.getText().toString().equals(order.getOrderid())) {
                                    str += "Delivering by " + order.getName() + " of Order id " +order.getOrderid() + " by " + order.getTime();
                                    flag=false;
                                }
                            }
                            if(flag==true){
                                str+="Order id of "+etCtm.getText().toString() +" is not found";
                            }

                            getDriverTxt.setText(str);
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