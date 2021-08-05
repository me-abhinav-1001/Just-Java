package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int initial_quantity=0;

    public void increment(View view){
        initial_quantity+=1;
        display(initial_quantity);
    }

    public void decrement(View view){
        if(initial_quantity>0){
            initial_quantity-=1;
            display(initial_quantity);
        }
    }

    public void submitOrder(View view){
//        displayPrice(5*initial_quantity);
        String priceMsg = "Free!!";
        displayMessage(priceMsg);
    }

    public void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    public void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.quantity_price_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void displayMessage(String msg){
        TextView priceTextView = (TextView) findViewById(R.id.quantity_price_view);
        priceTextView.setText(msg);
    }

}