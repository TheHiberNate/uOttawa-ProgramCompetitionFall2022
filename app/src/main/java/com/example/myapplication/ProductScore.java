package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProductScore extends AppCompatActivity implements View.OnClickListener {
    private Button calculate;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_score);

        score = (TextView) findViewById(R.id.productScore);
        calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                // method to calculate here
                score.setText(answer);
                break;
        }
    }
}