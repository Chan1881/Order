package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int amount = 1;
    int basePrice = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnPlus = findViewById(R.id.btn_plus);
        final TextView tvAmount = findViewById(R.id.tv_amount);
        final CheckBox cr=findViewById(R.id.cb_c);
        final TextView ty=findViewById(R.id.tv_ty);
        final CheckBox choco=findViewById(R.id.cb_cc);
        final CheckBox va=findViewById(R.id.cb_v);

        Button btnOrder=findViewById(R.id.btn_o);



        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount>1) {
                    amount--;
                }else{
                    amount=1;
                }
                tvAmount.setText(Integer.toString(amount));
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount++;
                tvAmount.setText(Integer.toString(amount));
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalPrice=basePrice;

                if(cr.isChecked()){
                finalPrice += 1;
                }

                if(choco.isChecked()){
                    finalPrice += 2;
                }

                if(va.isChecked()){
                    finalPrice += 3;
                }

                finalPrice *= amount;

                Log.d("Final Price", Integer.toString(finalPrice));
                ty.setText("Thank for your order. \n The total price is "+ Integer.toString(finalPrice));
            }
        });
    }
}
