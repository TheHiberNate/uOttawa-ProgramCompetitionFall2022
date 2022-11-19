package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ProductScore extends AppCompatActivity implements View.OnClickListener {
    private Button calculate;
    private TextView score;
    private DatabaseReference productReference;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_score);

        score = (TextView) findViewById(R.id.productScore);
        calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(this);

        name = (EditText) findViewById(R.id.productName);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                // method to calculate here
                String id = String.valueOf(name.getText());
                productReference = FirebaseDatabase.getInstance().getReference("Products").child(id);
                calculate();
                score.setText(answer);
                break;
        }
    }

    private int calculate() {
        productReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer distance = (Integer) snapshot.child("distance").getValue();
                String type = (String) snapshot.child("transportationMeans").getValue();
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return
    }


}