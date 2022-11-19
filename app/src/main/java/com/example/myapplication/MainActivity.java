package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button productScore, compareProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productScore = (Button) findViewById(R.id.btnImpactScore);
        productScore.setOnClickListener(this);
        compareProducts = (Button) findViewById(R.id.btnCompareProducts);
        compareProducts.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnImpactScore:

        }
    }
}