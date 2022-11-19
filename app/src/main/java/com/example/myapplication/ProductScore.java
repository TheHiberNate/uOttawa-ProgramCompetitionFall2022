package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
                break;
        }
    }

    private void calculate() {
        productReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String distance = snapshot.child("distance").getValue().toString();
                String type = snapshot.child("transportationMeans").getValue().toString();
                int answer = ScoreCalculate(type, Integer.valueOf(distance));
                String n = String.valueOf(answer);
                System.out.println(n);
                score.setText("The score is "+" "+ n + " %");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public Integer ScoreCalculate(String vehicle, int distance) {
        int score=0;
        int plane=5;
        int train=1;
        int ship=4;
        int truck=3;

        if (distance>=10000){
            if (vehicle.equals("plane")) {
                score=(plane+5)*10;
                System.out.println("Rentrer" + score);
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+5)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+5)*10;
            }
        }
        else if (distance<10000&& distance>5000){
            if (vehicle.equals("plane")) {
                score=(plane+3)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+3)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+3)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+3)*10;
            }
        }
        else if (distance<5000&& distance>1000){
            if (vehicle.equals("plane")) {
                score=(plane+2)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+2)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+2)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+2)*10;
            }
        }
        else if (distance<1000){
            if (vehicle.equals("plane")) {
                score=(plane+1)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+1)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+1)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+1)*10;
            }
        }
        return score;
    }

}