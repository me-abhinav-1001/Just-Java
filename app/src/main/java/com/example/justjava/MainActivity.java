package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        EditText text = (EditText) findViewById(R.id.name_field);
        String value = text.getText().toString();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = whippedCream.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, value);
        displayMessage(priceMessage);
    }

    private int calculatePrice(){
        return initial_quantity*5;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream,  boolean hasChocolate, String value){
        String priceMessage = "Name :"+value;
        priceMessage += "\nAdd Whipped Cream :"+hasWhippedCream;
        priceMessage += "\nAdd Whipped Cream :"+hasChocolate;
        priceMessage += "\nQuantity :"+initial_quantity;
        priceMessage += "\nTotal :$"+price;
        priceMessage += "\nThankYou !!";
        return  priceMessage;
    }

    public void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    public void displayMessage(String msg){
        TextView priceTextView = (TextView) findViewById(R.id.quantity_price_view);
        priceTextView.setText(msg);
    }

}