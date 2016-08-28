package com.example.eslam.coffeeorders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int ord = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addOne(View view) {
        if (ord < 10) {
            ord += 1;
            TextView orderTextView = (TextView) findViewById(R.id.value);
            orderTextView.setText(String.valueOf(ord));
        } else {
            Toast.makeText(this, "No More", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void subOne(View view) {
        if (ord == 0) {
            Toast.makeText(this, "Can't", Toast.LENGTH_SHORT).show();
            return;
        } else {
            ord -= 1;
            TextView orderTextView = (TextView) findViewById(R.id.value);
            orderTextView.setText(String.valueOf(ord));
        }
    }

    public void reset(View view) {
        String set = "Orders Reset";
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        TextView teView = (TextView) findViewById(R.id.summary);
        teView.setText(set);
    }

    public void onClickOrder(View view) {

        EditText edText = (EditText) findViewById(R.id.name);   // Edit text NAME operation
        TextView tView = (TextView) findViewById(R.id.value);   // Amount operation

        float quantity = Float.valueOf(tView.getText().toString());

        float price = (quantity * 5);
        if(creamCase()== true){price+=4;}
        if(chocolateCase()== true){price+=3;}
        if(nutCase()== true){price+=2;}

        String ordName = "Name: " + edText.getText().toString() + "\nAmout: " + tView.getText().toString()
                + "\nWhipped Cream ? " + creamCase()
                + "\nChocolate ? " + chocolateCase()
                + "\nNuts ? " + nutCase()
                + "\nPrice: $" + String.valueOf(price);
        TextView oName = (TextView) findViewById(R.id.summary);
        oName.setText(ordName);

    }

    public boolean creamCase() {
        CheckBox crCase = (CheckBox) findViewById(R.id.cream);
        if (crCase.isChecked())
            return true;
        return false;
    }

    public boolean chocolateCase() {
        CheckBox chCase = (CheckBox) findViewById(R.id.chocolate);
        if (chCase.isChecked())
            return true;
        return false;
    }

    public boolean nutCase() {
        CheckBox nCase = (CheckBox) findViewById(R.id.nuts);
        if (nCase.isChecked())
            return true;
        return false;
    }

}